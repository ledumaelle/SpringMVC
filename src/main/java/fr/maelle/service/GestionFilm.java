package fr.maelle.service;

import fr.maelle.bean.Film;
import fr.maelle.dao.iFilmDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestionFilm {

    @Autowired
    private iFilmDAO iFilmDAO;

    private static final Logger logger = LogManager.getLogger(GestionFilm.class);

    public void add(Film film){

        iFilmDAO.save(film);
    }

    public void update(Film film) {

        logger.info(film);

                try {
            iFilmDAO.save(film);

        }catch(Exception e) {

                logger.error(e.getMessage());

        }

    }

    public void delete(Film film) {

        delete(film.getId());
    }

    public void delete(int id) {

        Optional<Film> film = iFilmDAO.findById(id);

        if(film.isPresent()) {
            iFilmDAO.deleteById(film.get().getId());
        }
    }

    public List<Film> findAll() {

        return iFilmDAO.findAll();
    }

    public Optional<Film> findById(int id) {

        return iFilmDAO.findById(id);
    }

    public List<Film> findByTitreContaining(String nom) {
        return iFilmDAO.findByTitreContaining(nom);
    }

    public List<Film> findByOrderByTitreAsc() {
        return iFilmDAO.findByOrderByTitreAsc();
    }

    public List<Film> findByOrderByTitreDesc() {
        return iFilmDAO.findByOrderByTitreDesc();
    }

    public List<Film> findByVuTrue() {
        return iFilmDAO.findByVuTrue();
    }

    public List<Film> findByVuFalse() {
        return iFilmDAO.findByVuFalse();
    }

    public List<Film> findByOrderByAnneeAsc() {
        return iFilmDAO.findByOrderByAnneeAsc();
    }

    public List<Film> findByOrderByAnneeDesc() {
        return iFilmDAO.findByOrderByAnneeDesc();
    }

    public List<Film> findByOrderByRealisateurNomAsc() {
        return iFilmDAO.findByOrderByRealisateurNomAsc();
    }

    public List<Film> findByOrderByRealisateurNomDesc() {
        return iFilmDAO.findByOrderByRealisateurNomDesc();
    }

    public List<Film> findByOrderByDureeAsc() {
        return iFilmDAO.findByOrderByDureeAsc();
    }

    public List<Film> findByOrderByDureeDesc() {
        return iFilmDAO.findByOrderByDureeDesc();
    }

    public List<Film> findByOrderByStyleLibelleAsc() {
        return iFilmDAO.findByOrderByStyleLibelleAsc();
    }

    public List<Film> findByOrderByStyleLibelleDesc() {
        return iFilmDAO.findByOrderByStyleLibelleDesc();
    }
}
