package fr.maelle.filmotheque.dao;

import fr.maelle.filmotheque.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class GenericDAOImpl<T, U> implements GenericDAO<T, U> {

    private static final Logger logger = LogManager.getLogger(GenericDAOImpl.class);

    public void add(T entity) throws DAOException {

        EntityManager entityManager = DAOutil.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        try {

            entityManager.persist(entity);
            entityTransaction.commit();

        } catch (Exception exception) {

            logger.error("Erreur lors de l'ajout de l'entité " + entity);

            entityTransaction.rollback();
            throw new DAOException("Erreur lors de l'ajout de l'entité " + entity + " : " + exception.getMessage());
        }

    }

    public void delete(T entity) throws DAOException {

        EntityManager entityManager = DAOutil.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        try {

            entityManager.remove(entity);
            entityTransaction.commit();

        } catch (Exception exception) {

            entityTransaction.rollback();
            throw new DAOException("Erreur lors de la suppression de l'entité " + entity + " : " + exception.getMessage());
        }

    }

    public void update(T entity) throws DAOException {

        EntityManager entityManager = DAOutil.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        try {

            entityManager.merge(entity);
            entityTransaction.commit();

        } catch (Exception exception) {

            entityTransaction.rollback();
            throw new DAOException("Erreur lors de la modification de l'entité " + entity + " : " + exception.getMessage());
        }

    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public T findById(Class c, U id) {

        return (T) DAOutil.getEntityManager().find(c, id);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<T> findAll(Class c) {

        String requete = "select object(c) from " + c.getName() + " c";
        return DAOutil.getEntityManager().createQuery(requete, c).getResultList();
    }
}
