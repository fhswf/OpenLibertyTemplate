package de.fhswf.fit;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "PhoneBookServlet", urlPatterns = { "/addPerson", "/savePerson", "/removePerson" })
public class PhoneBookServlet extends HttpServlet {

    @Inject
    private PhoneBook phoneBook;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        String action = request.getServletPath();

        if (action.equals("/addPerson")) {
            phoneBook.addPerson(name, phone);
        } else if (action.equals("/savePerson")) {
            phoneBook.savePerson(name, phone);
        } else if (action.equals("/removePerson")) {
            phoneBook.removePerson(name);
        } else {
            throw new IllegalArgumentException("Unknown action: " + action);
        }

        request.getRequestDispatcher("phonebook.jsp").forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        String action = request.getServletPath();

        if (action.equals("/addPerson")) {
            phoneBook.addPerson(name, phone);
        } else if (action.equals("/savePerson")) {
            phoneBook.savePerson(name, phone);
        } else if (action.equals("/removePerson")) {
            phoneBook.removePerson(name);
        } else {
            throw new IllegalArgumentException("Unknown action: " + action);
        }

        request.getRequestDispatcher("phonebook.jsp").forward(request, response);
    }
}
