<%@ page import="java.util.List" %>
<%@ page import="model.Order" %>


<html>

<head>

<title>Orders</title>

<link rel="stylesheet" href="css/style.css">

</head>


<body>


<h2>My Orders</h2>



<%

List<Order> orders =
(List<Order>)request.getAttribute("orders");



for(Order o : orders){

%>


<div class="product">


<p>
Product ID:
<%=o.getProductId()%>
</p>


<p>
Date:
<%=o.getOrderDate()%>
</p>


</div>


<%

}

%>


</body>

</html>