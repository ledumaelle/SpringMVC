package fr.maelle.filmotheque.servlet.film;

import fr.maelle.filmotheque.bean.Film;
import fr.maelle.filmotheque.bean.Style;
import fr.maelle.filmotheque.exception.DAOException;
import fr.maelle.filmotheque.service.GestionFilm;
import fr.maelle.filmotheque.service.GestionStyle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SupprimerFilmServlet", urlPatterns = "/supprimerFilm")
public class SupprimerServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(fr.maelle.filmotheque.servlet.style.SupprimerServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GestionFilm gestionFilm = GestionFilm.getInstance();

        String id = request.getParameter("index");

        Film film = new Film();
        film.setId(Integer.parseInt(id));

        try {

            film = gestionFilm.findById(film.getId());

            logger.info(film);

            if (film == null) {
                logger.error("Aucun id ne correspond à ce style ! ");
            }

            gestionFilm.deleteFilm(film.getId());

        } catch (DAOException exception) {

            logger.error(exception.getMessage());
        }

        response.sendRedirect(request.getContextPath() + "/lister");

    }
}
