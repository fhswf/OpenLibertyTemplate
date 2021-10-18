package de.fhswf.fit;

import java.util.Map;
import java.util.Collections;
import java.io.IOException;
import java.io.PrintWriter;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.Filter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/secure/*")
public class AuthFilter extends HttpFilter {
 
    @Override
    public void doFilter(HttpServletRequest request, 
                         HttpServletResponse response,
                         FilterChain filterChain) 
                        throws IOException, ServletException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        String username = null;
        String token = authHeader.substring(7);
        System.out.println(token);
        try {
            username = Jwts.parser()
                    .setSigningKey("secretkey")
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            System.out.println("Invalid token: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        System.out.println("Username: " + username);
	    request.getSession().setAttribute("sub", username);
	
	    // continue with next filter in chain
	    filterChain.doFilter(request, response);
    } 
}
