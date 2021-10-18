package de.fhswf.fit;

import java.util.Map;
import java.util.Collections;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/echo", "/secure"})
public class EchoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body><h2>Request Parameters</h2>");
            Map<String, String[]> params = request.getParameterMap();
            for (String key : params.keySet()) {
                for (String value : params.get(key)) {
                    out.println(key + ": " + value + "<br>");
                }
            }
            out.println("<h2>Headers</h2>");
            for (String key : Collections.list(request.getHeaderNames())) {
                out.println(key + ": " + request.getHeader(key) + "<br>");
            }
            out.println("</body></html>");
        }   
    }
} 