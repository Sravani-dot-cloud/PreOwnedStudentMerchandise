package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ProductDAO;
import model.User;


public class BuyProductServlet extends HttpServlet {


protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {


    HttpSession session =
    request.getSession();


    User user =
    (User)session.getAttribute("user");


    if(user == null){

        response.sendRedirect("login.jsp");

        return;
    }



    int productId =
    Integer.parseInt(
    request.getParameter("id"));



    ProductDAO dao =
    new ProductDAO();



    boolean result =
    dao.buyProduct(productId,
    user.getEmail());



    if(result){

        response.sendRedirect("ViewProductServlet");

    }else{

        response.getWriter()
        .println("Unable to buy product");

    }

}

}