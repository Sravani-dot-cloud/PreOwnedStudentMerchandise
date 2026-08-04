<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>


<!DOCTYPE html>

<html>


<head>

<title>Manage Products</title>

<link rel="stylesheet"
href="css/style.css">

</head>


<body>


<h2>All Products</h2>



<%

List<Product> products =
(List<Product>)request.getAttribute("products");


if(products != null){


for(Product p : products){

%>


<div class="product">


<img src="uploads/<%=p.getImage()%>"
width="150"
height="120">



<h3>
<%=p.getProductName()%>
</h3>


<p>
Price:
₹<%=p.getPrice()%>
</p>


<p>
Seller:
<%=p.getSellerEmail()%>
</p>


<p>
Status:
<%=p.getStatus()%>
</p>



<a href="DeleteProductServlet?id=<%=p.getId()%>">

Delete

</a>


</div>


<%

}

}

%>



</body>

</html>