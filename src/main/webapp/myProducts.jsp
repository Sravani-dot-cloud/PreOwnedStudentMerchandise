<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>


<html>

<head>

<title>My Products</title>

<link rel="stylesheet" href="css/style.css">

</head>


<body>


<h2>My Listed Products</h2>


<%

List<Product> products =
(List<Product>)request.getAttribute("products");


for(Product p : products){

%>


<div class="product">


<h3>
<%=p.getProductName()%>
</h3>


<p>
Price: <%=p.getPrice()%>
</p>


<p>
Status: <%=p.getStatus()%>
</p>


<a href="DeleteProductServlet?id=<%=p.getId()%>">

Delete

</a>


</div>


<%

}

%>


</body>

</html>