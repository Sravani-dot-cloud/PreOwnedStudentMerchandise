package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Product;
import model.User;

import java.io.File;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import javax.servlet.annotation.WebServlet;

@MultipartConfig
public class AddProductServlet extends HttpServlet {


protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {



    HttpSession session =
    request.getSession();



    User user =
    (User) session.getAttribute("user");



    if(user == null){

        response.sendRedirect("login.jsp");

        return;

    }
    Product product = new Product();

 // Get values
 String productName = request.getParameter("productName");
 String description = request.getParameter("description");
 String priceStr = request.getParameter("price");
 String categoryStr = request.getParameter("categoryId");

 // Validation
 if (productName == null || productName.trim().isEmpty()) {
     response.getWriter().println("Product name is required");
     return;
 }

 if (priceStr == null || priceStr.trim().isEmpty()) {
     response.getWriter().println("Price is required");
     return;
 }

 double price = Double.parseDouble(priceStr);

 if (price <= 0) {
     response.getWriter().println("Price must be greater than zero");
     return;
 }

 int categoryId = Integer.parseInt(categoryStr);

 // Set values
 product.setProductName(productName);
 product.setCategoryId(categoryId);
 product.setDescription(description);
 product.setPrice(price);

    Part filePart =
    		request.getPart("image");


    		String fileName =
    		filePart.getSubmittedFileName();


    		String uploadPath =
    		getServletContext()
    		.getRealPath("")
    		+"uploads";


    		File uploadDir =
    		new File(uploadPath);


    		if(!uploadDir.exists()){

    		    uploadDir.mkdir();

    		}


    		filePart.write(
    		uploadPath + File.separator + fileName
    		);



    		product.setImage(fileName);


    



    product.setSellerEmail(
    user.getEmail());



    ProductDAO dao =
    new ProductDAO();



    if(dao.addProduct(product)){


        response.sendRedirect("ViewProductServlet");


    }else{


        response.getWriter()
        .println("Product Adding Failed");


    }

}

}