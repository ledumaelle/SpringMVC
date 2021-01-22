package fr.maelle.filmotheque.servlet.style;

import fr.maelle.filmotheque.bean.Style;
import fr.maelle.filmotheque.exception.DAOException;
import fr.maelle.filmotheque.service.GestionStyle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifierStyleServlet", urlPatterns = "/modifStyle")
public class ModifierServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(ModifierServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GestionStyle gestionStyle = GestionStyle.getInstance();

        String id = request.getParameter("id");
        String libelle = request.getParameter("libelle");

        Style styleToUpdate = new Style();
        styleToUpdate.setId(Integer.parseInt(id));
        styleToUpdate.setLibelle(libelle);

        try {

            Style style = gestionStyle.findById(styleToUpdate.getId());

            if (style == null) {

                logger.error("Aucun id ne correspond à ce style ! ");
            }

            gestionStyle.updateStyle(styleToUpdate);

        } catch (DAOException exception) {

            logger.error(exception.getMessage());
        }

        response.sendRedirect(request.getContextPath() + "/listerStyle");
    }
}
