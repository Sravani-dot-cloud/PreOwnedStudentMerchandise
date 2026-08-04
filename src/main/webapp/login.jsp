<!DOCTYPE html>
<html>

<head>

<title>Login</title>

<link rel="stylesheet" href="css/style.css">

</head>


<body>


<div class="container">


<h2>Login</h2>


<form action="LoginServlet" method="post">


<label>Email</label>

<input type="email" name="email" required>



<label>Password</label>

<input type="password" name="password" required>



<button type="submit">
Login
</button>


</form>


<p>
New user?
<a href="register.jsp">
Register
</a>
</p>
<p>
Admin?
<a href="adminLogin.jsp">Admin Login</a>
</p>

</div>


</body>

</html>