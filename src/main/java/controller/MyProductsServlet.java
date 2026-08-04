package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Product;
import model.User;



public class MyProductsServlet extends HttpServlet {



protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {



    HttpSession session =
    request.getSession();



    User user =
    (User)session.getAttribute("user");



    ProductDAO dao =
    new ProductDAO();



    List<Product> products =
    dao.getProductsBySeller(
    user.getEmail());



    request.setAttribute(
    "products",
    products);



    request.getRequestDispatcher(
    "myProducts.jsp")
    .forward(request,response);



}

}