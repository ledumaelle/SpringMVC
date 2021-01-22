package fr.maelle.filmotheque.servlet.style;

import fr.maelle.filmotheque.bean.Film;
import fr.maelle.filmotheque.bean.Style;
import fr.maelle.filmotheque.exception.DAOException;
import fr.maelle.filmotheque.service.GestionStyle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListerStyleServlet", urlPatterns = "/listerStyle")
public class ListerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/style/listeStyles.jsp");

        GestionStyle gestionStyle = GestionStyle.getInstance();

        /*Style style1 = new Style();
        style1.setLibelle("STYLE 1");

        Style style2 = new Style();
        style2.setLibelle("STYLE 2");

        Style style3 = new Style();
        style3.setLibelle("STYLE 3");

        try {

            gestionStyle.addStyle(style1);
            gestionStyle.addStyle(style2);
            gestionStyle.addStyle(style3);
        }
        catch (DAOException exception)
        {
            exception.printStackTrace();
        }*/

        try {

            List<Style> styles = gestionStyle.findAll();
            request.setAttribute("styles", styles);

        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

        rd.forward(request, response);

    }
}
