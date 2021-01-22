package fr.maelle.filmotheque.servlet.style;

import fr.maelle.filmotheque.bean.Style;
import fr.maelle.filmotheque.exception.DAOException;
import fr.maelle.filmotheque.service.GestionStyle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SupprimerStyleServlet", value = "/supprimerStyle")
public class SupprimerServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(SupprimerServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GestionStyle gestionStyle = GestionStyle.getInstance();

        String id = request.getParameter("index");

        Style style = new Style();
        style.setId(Integer.parseInt(id));

        try {

            style = gestionStyle.findById(style.getId());

            logger.info(style);

            if (style == null) {
                logger.error("Aucun id ne correspond à ce style ! ");
            }

            gestionStyle.deleteStyle(style.getId());

        } catch (DAOException exception) {

            logger.error(exception.getMessage());
        }

        response.sendRedirect(request.getContextPath() + "/listerStyle");

    }
}
