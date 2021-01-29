package fr.maelle.controller;

import fr.maelle.bean.Film;
import fr.maelle.bean.Style;
import fr.maelle.service.GestionFilm;
import fr.maelle.service.GestionStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/films")
public class FilmController {

    @Autowired
    private GestionFilm gestionFilm;

    @Autowired
    private GestionStyle gestionStyle;

    @GetMapping
    public ModelAndView index(String titre) {

        List<Film> films;

        if (titre != null && !titre.isBlank()) {
            films = gestionFilm.findByTitreContaining(titre);
        } else {
            films = gestionFilm.findAll();
        }

        return new ModelAndView("film/index", "films", films);
    }

    @GetMapping(path = "/show")
    public ModelAndView show(int id) {

        Optional<Film> film = gestionFilm.findById(id);

        if (film.isPresent()) {
            return new ModelAndView("film/show", "film", film.get());

        } else {
            return index(null);
        }
    }

    @GetMapping(path = "/create")
    public ModelAndView create() {

        Film film = new Film();
        List<Style> styles = gestionStyle.findAll();

        ModelAndView mav = new ModelAndView("film/create", "film", film);
        mav.getModelMap().addAttribute("styles", styles);

        return mav;
    }

    @GetMapping(path = "/edit")
    public ModelAndView edit(int id) {

        Optional<Film> film = gestionFilm.findById(id);

        if (film.isPresent()) {

            List<Style> styles = gestionStyle.findAll();

            ModelAndView mav = new ModelAndView("film/edit", "film", film.get());
            mav.getModelMap().addAttribute("styles", styles);

            return mav;
        }

        return index(null);
    }

    @PostMapping(path = "/addFilm")
    public ModelAndView addFilm(@Valid @ModelAttribute("film") Film film, BindingResult result) {

        if (result.hasErrors()) {

            List<Style> styles = gestionStyle.findAll();

            ModelAndView mav = new ModelAndView("film/create", "film", film);
            mav.getModelMap().addAttribute("styles", styles);

            return mav;

        } else {

            try {
                gestionFilm.add(film);
            } catch (Exception e) {
                System.out.println("ERREUR lors de l'ajout du film : " + film.getTitre());
            }
            return index(null);
        }
    }

    @PostMapping(path = "/updateFilm")
    public ModelAndView updateFilm(@Valid @ModelAttribute("film") Film film, BindingResult result) {

        if (result.hasErrors()) {

            List<Style> styles = gestionStyle.findAll();

            ModelAndView mav = new ModelAndView("film/edit", "film", film);
            mav.getModelMap().addAttribute("styles", styles);

            return mav;

        } else {

            System.out.println(film);

            System.out.println(film.getRealisateur().getNom());

            Film filmToUpdate = new Film();
            filmToUpdate = gestionFilm.findById(film.getId()).get();

            filmToUpdate.setTitre(film.getTitre());

            if (gestionFilm.findById(film.getId()).isPresent()) {

                System.out.println(filmToUpdate);

                try {
                    gestionFilm.update(filmToUpdate);
                } catch (Exception e) {
                    System.out.println("ERREUR lors de la maj du film : " + film.getTitre());
                }
            }

            return index(null);
        }
    }

    @GetMapping(path = "/delete")
    public ModelAndView delete(int id) {

        if (gestionFilm.findById(id).isPresent()) {

            try {

                gestionFilm.delete(id);

            } catch (Exception e) {
                System.out.println("ERREUR lors de la suppression du film : " + id);
            }

        } else {

            System.out.println("ERREUR FILM_ID n'existe pas : " + id);
        }

        return index(null);
    }

    @GetMapping(path = "/trier")
    public ModelAndView trier(String sort) {

        List<Film> films = new ArrayList<>();

        if (sort != null && !sort.isEmpty()) {

            switch (sort) {

                case "titreA":
                    films = gestionFilm.findByOrderByTitreAsc();
                    break;

                case "titreD":
                    films = gestionFilm.findByOrderByTitreDesc();
                    break;

                case "vuTrue":
                    films = gestionFilm.findByVuTrue();
                    break;

                case "vuFalse":
                    films = gestionFilm.findByVuFalse();
                    break;

                case "dureeA":
                    films = gestionFilm.findByOrderByDureeAsc();
                    break;

                case "dureeD":
                    films = gestionFilm.findByOrderByDureeDesc();
                    break;

                case "anneeA":
                    films = gestionFilm.findByOrderByAnneeAsc();
                    break;

                case "anneeD":
                    films = gestionFilm.findByOrderByAnneeDesc();
                    break;

                case "styleA":
                    films = gestionFilm.findByOrderByStyleLibelleAsc();
                    break;

                case "styleD":
                    films = gestionFilm.findByOrderByStyleLibelleDesc();
                    break;

                case "realisateurA":
                    films = gestionFilm.findByOrderByRealisateurNomAsc();
                    break;

                case "realiateurD":
                    films = gestionFilm.findByOrderByRealisateurNomDesc();
                    break;
            }
        }

        return new ModelAndView("film/index", "films", films);

    }

}
