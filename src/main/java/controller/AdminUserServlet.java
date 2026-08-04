package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDAO;
import model.User;



public class AdminUserServlet extends HttpServlet {


protected void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {



UserDAO dao =
new UserDAO();


List<User> users =
dao.getAllUsers();



request.setAttribute(
"users",
users);



request.getRequestDispatcher(
"adminUsers.jsp")
.forward(request,response);



}

}