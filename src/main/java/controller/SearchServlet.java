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



public class SearchServlet extends HttpServlet {


protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {



    String keyword =
    request.getParameter("keyword");



    ProductDAO dao =
    new ProductDAO();



    List<Product> products =
    dao.searchProducts(keyword);



    request.setAttribute(
    "products",
    products);



    request.getRequestDispatcher(
    "viewProducts.jsp")
    .forward(request,response);



}

}