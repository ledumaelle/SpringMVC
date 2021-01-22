package fr.maelle.filmotheque.servlet.film;

import fr.maelle.filmotheque.bean.Acteur;
import fr.maelle.filmotheque.bean.Film;
import fr.maelle.filmotheque.bean.Realisateur;
import fr.maelle.filmotheque.bean.Style;
import fr.maelle.filmotheque.exception.DAOException;
import fr.maelle.filmotheque.service.GestionFilm;
import fr.maelle.filmotheque.service.GestionStyle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AjouterFilmServlet", urlPatterns = "/ajouter")
public class AjouterServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(AjouterServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/film/ajouterFilm.jsp");
        GestionStyle gestionStyle = GestionStyle.getInstance();

        try {

            List<Style> styles = gestionStyle.findAll();
            request.setAttribute("styles", styles);

        }catch(DAOException exception){

            logger.error(exception.getMessage());
        }

        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GestionFilm gestionFilm = GestionFilm.getInstance();
        GestionStyle gestionStyle = GestionStyle.getInstance();

        String titre = request.getParameter("titre");
        String annee =request.getParameter("annee");
        String style_id =request.getParameter("style");
        String realisateur_prenom =request.getParameter("realisateur_prenom");
        String realisateur_nom =request.getParameter("realisateur_nom");
        String duree =request.getParameter("duree");
        String vu =request.getParameter("vu");

        //ACTEURS
        List<Acteur> acteurs = new ArrayList<>();

        for(int i = 0 ; i < 5 ; i++) {

            String acteur_nom =request.getParameter("nom"+i);
            String acteur_prennom =request.getParameter("prenom"+i);

            if(!acteur_nom.isEmpty()) {

                Acteur acteur = new Acteur();
                acteur.setNom(acteur_nom);
                acteur.setPrenom(acteur_prennom);

                acteurs.add(acteur);
            }
        }

        String synopsis = request.getParameter("synopsis");

        Realisateur realisateur = new Realisateur();
        realisateur.setNom(realisateur_nom);
        realisateur.setPrenom(realisateur_prenom);

        Film film = new Film();
        film.setTitre(titre);

        if(!annee.isEmpty()) {

            film.setAnnee(Integer.parseInt(annee));
        }
        film.setStyle(null);
        film.setActeurs(acteurs);

        try {

            Style style = gestionStyle.findById(Integer.parseInt(style_id));
            if(style != null) {
                film.setStyle(style);
            }
        }catch(DAOException exception) {

            logger.error(exception.getMessage());
        }
        film.setRealisateur(realisateur);
        film.setDuree(Integer.parseInt(duree));
        film.setVu(Boolean.parseBoolean(vu));
        film.setSynopsis(synopsis);

        try {

            gestionFilm.addFilm(film);

            response.sendRedirect(request.getContextPath() + "/lister");


        } catch(DAOException exception) {

            logger.error(exception.getMessage());
            doGet(request,response);
        }

    }
}
