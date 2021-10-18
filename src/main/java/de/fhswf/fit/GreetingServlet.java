package de.fhswf.fit;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * This is a simple example of an HTTP Servlet. It responds to the GET method of
 * the HTTP protocol.
 */
@WebServlet(value="/hello", initParams=@WebInitParam(name="greeting", value="Hallo Welt!"))
public class GreetingServlet extends HttpServlet {
    String greeting = "Hello World!";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String greeting = config.getInitParameter("greeting");
        if (greeting != null) {
            this.greeting = greeting;
        }
    }   

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + this.greeting + "</h1>");
        out.println("</body></html>");
    }
}
