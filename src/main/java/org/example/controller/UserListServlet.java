package org.example.controller;

import org.example.model.User;
import org.example.model.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserListServlet extends HttpServlet {
    private UserDAO dao = new UserDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> users = dao.findAll();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/userList.jsp").forward(request, response);
        } catch (SQLException e) { throw new ServletException(e); }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String search = request.getParameter("search");

        try {
            List<User> users = dao.search(search);
            request.setAttribute("users", users);
            request.getRequestDispatcher("userList.jsp").forward(request, response);
        } catch (SQLException e) { throw new ServletException(e); }
    }
}


