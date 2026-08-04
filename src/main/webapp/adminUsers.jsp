<%@ page import="java.util.List" %>
<%@ page import="model.User" %>


<!DOCTYPE html>
<html>

<head>

<title>Manage Users</title>

<link rel="stylesheet"
href="css/style.css">

</head>


<body>


<h2>Registered Users</h2>



<%

List<User> users =
(List<User>)request.getAttribute("users");


if(users != null){


for(User u : users){

%>


<div class="product">


<h3>
<%=u.getName()%>
</h3>


<p>
Email:
<%=u.getEmail()%>
</p>


<p>
Phone:
<%=u.getPhone()%>
</p>


<p>
Role:
<%=u.getRole()%>
</p>


</div>


<%

}

}

%>


</body>

</html>