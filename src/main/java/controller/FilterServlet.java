package controller;


import java.io.IOException;
import java.util.List;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Product;


public class FilterServlet extends HttpServlet {


protected void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {



int categoryId =
Integer.parseInt(
request.getParameter("categoryId"));



double minPrice =
Double.parseDouble(
request.getParameter("minPrice"));



double maxPrice =
Double.parseDouble(
request.getParameter("maxPrice"));



ProductDAO dao =
new ProductDAO();



List<Product> products =
dao.filterProducts(
categoryId,
minPrice,
maxPrice);



request.setAttribute(
"products",
products);



request.getRequestDispatcher(
"viewProducts.jsp")
.forward(request,response);



}

}