package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Product;



public class EditProductServlet extends HttpServlet {


protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {



    Product product =
    new Product();



    product.setId(
    Integer.parseInt(
    request.getParameter("id")));




    product.setProductName(
    request.getParameter("productName"));



    product.setDescription(
    request.getParameter("description"));



    product.setPrice(
    Double.parseDouble(
    request.getParameter("price")));




    ProductDAO dao =
    new ProductDAO();



    dao.updateProduct(product);



    response.sendRedirect(
    "MyProductsServlet");


}

}