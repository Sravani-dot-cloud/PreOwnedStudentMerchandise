<%@ page import="model.Product" %>


<%

Product p =
(Product)request.getAttribute("product");

%>



<!DOCTYPE html>

<html>


<head>

<title>Edit Product</title>

<link rel="stylesheet"
href="css/style.css">

</head>



<body>


<div class="container">


<h2>Edit Product</h2>


<form action="EditProductServlet"
method="post">



<input type="hidden"
name="id"
value="<%=p.getId()%>">



<label>Product Name</label>

<input type="text"
name="productName"
value="<%=p.getProductName()%>">



<label>Description</label>

<textarea name="description">
<%=p.getDescription()%>
</textarea>



<label>Price</label>

<input type="number"
name="price"
value="<%=p.getPrice()%>">



<button type="submit">
Update Product
</button>



</form>


</div>


</body>


</html>