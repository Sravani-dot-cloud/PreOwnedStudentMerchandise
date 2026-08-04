<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="model.Product"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Products</title>

<link rel="stylesheet" href="css/style.css">

<style>

body{
    background:#f5f5f5;
    font-family:Arial;
}

.container{
    width:90%;
    margin:auto;
}

h2{
    text-align:center;
    color:#2874f0;
}

.search-box{
    text-align:center;
    margin:20px;
}

.search-box input{
    width:300px;
    padding:10px;
}

.search-box button{
    padding:10px 20px;
    background:#2874f0;
    color:white;
    border:none;
    cursor:pointer;
}

.products{
    display:flex;
    flex-wrap:wrap;
    justify-content:center;
}

.product{
    width:300px;
    background:white;
    margin:15px;
    padding:15px;
    border-radius:10px;
    box-shadow:0px 0px 8px gray;
}

.product img{
    width:100%;
    height:200px;
    object-fit:cover;
    border-radius:10px;
}

.product h3{
    color:#2874f0;
}

.buy-btn{
    display:inline-block;
    background:green;
    color:white;
    padding:10px 20px;
    text-decoration:none;
    border-radius:5px;
}

.buy-btn:hover{
    background:darkgreen;
}

</style>

</head>

<body>

<div class="container">

<h2>Available Products</h2>

<div class="search-box">

<form action="SearchServlet" method="get">

<input type="text"
name="keyword"
placeholder="Search Product">

<button type="submit">
Search
</button>

</form>

</div>

<div class="products">

<%

List<Product> products =
(List<Product>)request.getAttribute("products");

if(products!=null && !products.isEmpty()){

for(Product p:products){

%>

<div class="product">

<img src="uploads/<%=p.getImage()%>"
alt="Product Image">

<h3><%=p.getProductName()%></h3>

<p>
<b>Description :</b>
<%=p.getDescription()%>
</p>

<p>
<b>Price :</b>
₹<%=p.getPrice()%>
</p>

<p>
<b>Seller :</b>
<%=p.getSellerEmail()%>
</p>

<p>
<b>Status :</b>
<%=p.getStatus()%>
</p>

<a class="buy-btn"
href="BuyProductServlet?id=<%=p.getId()%>">
Buy Now
</a>

</div>

<%

}

}else{

%>

<h3 style="text-align:center;">
No Products Available
</h3>

<%

}

%>

</div>

</div>

</body>
</html>