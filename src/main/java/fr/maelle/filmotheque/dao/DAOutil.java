package fr.maelle.filmotheque.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOutil {

    public static EntityManagerFactory entityManagerFactory;

    static {

        entityManagerFactory = Persistence.createEntityManagerFactory("bdd_filmotheque");
    }

    public static EntityManager getEntityManager() {

        return entityManagerFactory.createEntityManager();
    }

    public static void close() {

        entityManagerFactory.close();
    }
}
