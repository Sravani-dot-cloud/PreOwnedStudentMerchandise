package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import model.Order;
import model.User;



public class OrderHistoryServlet extends HttpServlet {


protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {



    HttpSession session =
    request.getSession();



    User user =
    (User)session.getAttribute("user");



    OrderDAO dao =
    new OrderDAO();



    List<Order> orders =
    dao.getOrdersByBuyer(
    user.getEmail());



    request.setAttribute(
    "orders",
    orders);



    request.getRequestDispatcher(
    "orderHistory.jsp")
    .forward(request,response);



}

}