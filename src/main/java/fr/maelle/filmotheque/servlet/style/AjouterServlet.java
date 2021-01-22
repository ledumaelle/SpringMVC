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

@WebServlet(name = "AjouterStyleServlet", urlPatterns = "/ajouterStyle")
public class AjouterServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(AjouterServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GestionStyle gestionStyle = GestionStyle.getInstance();

        String libelle = request.getParameter("libelle");

        Style style = new Style();
        style.setLibelle(libelle);

        try {

            gestionStyle.addStyle(style);
        } catch (DAOException exception)
        {
            logger.error(exception.getMessage());
            exception.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/listerStyle");
    }
}
