package fr.maelle.filmotheque.servlet.film;

import fr.maelle.filmotheque.bean.Film;
import fr.maelle.filmotheque.exception.DAOException;
import fr.maelle.filmotheque.service.GestionFilm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListerFilmServlet", urlPatterns = "/lister")
public class ListerServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(ListerServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GestionFilm gestionFilm = GestionFilm.getInstance();
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/film/listeFilms.jsp");

        try {

            List<Film> films = gestionFilm.findAll();
            request.setAttribute("films", films);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        rd.forward(request, response);
    }
}
