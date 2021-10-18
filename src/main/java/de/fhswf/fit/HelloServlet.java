package de.fhswf.fit;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/aufgabe1")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try {
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>Hello World</h1>");
            response.getWriter().println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}