package fr.maelle.filmotheque.service;

import fr.maelle.filmotheque.bean.Film;
import fr.maelle.filmotheque.dao.GenericDAOImpl;
import fr.maelle.filmotheque.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * MANAGER
 */
public class GestionFilm {

    private static final Logger logger = LogManager.getLogger(GestionFilm.class);

    private static GenericDAOImpl<Film,Integer> genericDAOImpl = null ;
    private static GestionFilm gestionFilm = null;

    public static GestionFilm getInstance() {

        if (gestionFilm == null) {

            gestionFilm = new GestionFilm();
            genericDAOImpl = new GenericDAOImpl<>();
        }

        return gestionFilm;
    }

    public void addFilm(Film film) throws DAOException {

        genericDAOImpl.add(film);
    }

    public void updateFilm(Film film) throws DAOException {

        genericDAOImpl.update(film);
    }

    public void deleteFilm(Film film) throws DAOException {

        genericDAOImpl.delete(film);
    }

    public void deleteFilm(int id) throws DAOException {

        Film film = genericDAOImpl.findById(Film.class, id);

        genericDAOImpl.delete(film);
    }

    public List<Film> findAll() throws DAOException {

        return genericDAOImpl.findAll(Film.class);
    }

    public Film findById(int id) throws DAOException {

        return genericDAOImpl.findById(Film.class, id);
    }

}
