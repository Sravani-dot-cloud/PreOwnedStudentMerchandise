<%@ page import="model.Admin" %>


<%

Admin admin =
(Admin)session.getAttribute("admin");


if(admin==null){

response.sendRedirect("adminLogin.jsp");

return;

}

%>



<!DOCTYPE html>

<html>


<head>

<title>Admin Dashboard</title>

<link rel="stylesheet"
href="css/style.css">

</head>


<body>



<h2>
Welcome Admin
</h2>



<nav>

<a href="AdminUserServlet">
Manage Users
</a>


<a href="AdminProductServlet">
Manage Products
</a>


<a href="LogoutServlet">
Logout
</a>


</nav>



<div class="product">


<h3>
Admin Panel
</h3>


<p>
You can manage users and products here.
</p>


</div>



</body>

</html>