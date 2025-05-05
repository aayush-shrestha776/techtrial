package com.TechSansar.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(asyncSupported = true, urlPatterns = {"/search"})
public class SearchController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");

        if (query == null || query.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Search field cannot be empty!");
            request.getRequestDispatcher("search.jsp").forward(request, response);
            return;
        }

        if (!query.matches("[a-zA-Z0-9\\s]+")) {
            request.setAttribute("errorMessage", "Only letters, numbers, and spaces are allowed!");
            request.getRequestDispatcher("search.jsp").forward(request, response);
            return;
        }

        // If valid, proceed with search logic
        request.setAttribute("searchResult", "You searched for: " + query); // replace with actual result logic
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }
}
