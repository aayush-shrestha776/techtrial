package com.TechSansar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.TechSansar.util.CookiesUtil;
import com.TechSansar.util.SessionUtil;

/**
 * @author Malisha Kushwaha
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ Clear cookies (already fine)
        CookiesUtil.deleteCookie(response, "role");

        // ✅ Invalidate session
        SessionUtil.invalidateSession(request);

        // ✅ Prevent caching of old session/header info
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        // ✅ Redirect to home or login
        request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
    }
}
