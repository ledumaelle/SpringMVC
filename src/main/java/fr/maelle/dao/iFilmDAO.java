package fr.maelle.dao;

import fr.maelle.bean.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iFilmDAO extends JpaRepository<Film,Integer> {

    List<Film> findByTitreContaining(String nom);

    List<Film> findByOrderByTitreAsc();
    List<Film> findByOrderByTitreDesc();

    List<Film> findByVuTrue();
    List<Film> findByVuFalse();

    List<Film> findByOrderByAnneeAsc();
    List<Film> findByOrderByAnneeDesc();

    List<Film> findByOrderByDureeAsc();
    List<Film> findByOrderByDureeDesc();

    List<Film> findByOrderByRealisateurNomAsc();
    List<Film> findByOrderByRealisateurNomDesc();

    List<Film> findByOrderByStyleLibelleAsc();
    List<Film> findByOrderByStyleLibelleDesc();
}
