package fr.maelle.filmotheque.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AccueilServlet", urlPatterns = "/index.jsp")
public class AccueilServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/index.jsp");
        rd.forward(request,response);
    }
}
