package fr.maelle.filmotheque.servlet.film;

import fr.maelle.filmotheque.bean.Film;
import fr.maelle.filmotheque.service.GestionFilm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/afficher", name = "AfficherFilmServlet")
public class AfficherServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(AfficherServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        logger.info("ENTRE DANS AFFICHER SERVLET");

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/film/afficherFilm.jsp");

        GestionFilm gestionFilm = GestionFilm.getInstance();

        logger.info(request.getParameter("index"));

        String id = request.getParameter("index");

        if (id == null || id.isEmpty()) {

            throw new ServletException("Id non renseigné");
        }

        try {

            Film film = gestionFilm.findById(Integer.parseInt(id));
            request.setAttribute("film", film);

        } catch (Exception exception) {

            logger.error(exception.getMessage());
            System.out.println(exception.getMessage());
        }

        rd.forward(request, response);
    }
}
