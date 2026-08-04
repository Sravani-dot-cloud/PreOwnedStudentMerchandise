package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        // Name Validation
        if (name == null || name.trim().isEmpty()) {
            response.getWriter().println("❌ Name cannot be empty.");
            return;
        }

        // Email Validation
        if (email == null || email.trim().isEmpty()) {
            response.getWriter().println("❌ Email cannot be empty.");
            return;
        }

        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email)) {
            response.getWriter().println("❌ Please enter a valid email address.");
            return;
        }

        // Password Validation
        if (password == null || password.isEmpty()) {
            response.getWriter().println("❌ Password cannot be empty.");
            return;
        }

        if (password.length() < 6) {
            response.getWriter().println("❌ Password must be at least 6 characters long.");
            return;
        }

        // Phone Validation
        if (phone == null || phone.trim().isEmpty()) {
            response.getWriter().println("❌ Phone number cannot be empty.");
            return;
        }

        if (!phone.matches("[0-9]{10}")) {
            response.getWriter().println("❌ Phone number must contain exactly 10 digits.");
            return;
        }

        UserDAO dao = new UserDAO();

        // Check if email already exists
        if (dao.emailExists(email)) {
            response.getWriter().println("❌ This email is already registered. Please use another email.");
            return;
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);

        boolean result = dao.registerUser(user);

        if (result) {
            response.sendRedirect("login.jsp");
        } else {
            response.getWriter().println("❌ Registration failed. Please try again.");
        }
    }
}