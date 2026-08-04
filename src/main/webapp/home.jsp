<%@ page import="model.User" %>


<%

User user =
(User)session.getAttribute("user");


if(user==null){

response.sendRedirect("login.jsp");

return;

}

%>



<!DOCTYPE html>

<html>

<head>

<title>Home</title>

<link rel="stylesheet" href="css/style.css">

</head>


<body>


<h2>
Welcome <%=user.getName()%>
</h2>


<nav>

<a href="addProduct.jsp">
Sell Product
</a>


<a href="ViewProductServlet">
Products
</a>


<a href="MyProductsServlet">
My Products
</a>


<a href="OrderHistoryServlet">
Orders
</a>


<a href="LogoutServlet">
Logout
</a>


</nav>


</body>

</html>