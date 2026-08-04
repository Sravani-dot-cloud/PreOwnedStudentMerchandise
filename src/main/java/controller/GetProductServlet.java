package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Product;



public class GetProductServlet extends HttpServlet {


protected void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {



int id =
Integer.parseInt(
request.getParameter("id"));



ProductDAO dao =
new ProductDAO();



Product product =
dao.getProductById(id);



request.setAttribute(
"product",
product);



request.getRequestDispatcher(
"editProduct.jsp")
.forward(request,response);


}

}