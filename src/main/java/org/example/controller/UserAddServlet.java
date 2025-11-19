package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.User;
import org.example.model.UserDAO;

import java.io.IOException;
import java.sql.SQLException;


public class UserAddServlet extends HttpServlet {
    private UserDAO dao = new UserDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/userForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            dao.insert(new User(0, password, userName, email));
            response.sendRedirect("userList");
        } catch (SQLException e) { throw new ServletException(e); }
    }
}