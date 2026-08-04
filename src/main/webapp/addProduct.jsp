<!DOCTYPE html>
<html>

<head>

<title>Add Product</title>

<link rel="stylesheet" href="css/style.css">

</head>


<body>


<div class="container">


<h2>Add Pre-Owned Product</h2>


<form action="AddProductServlet"
method="post"
enctype="multipart/form-data">


<label>Product Name</label>

<input type="text" name="productName" required>



<label>Category</label>

<select name="categoryId">


<option value="1">Books</option>

<option value="2">Electronics</option>

<option value="3">Furniture</option>

<option value="4">Stationery</option>

<option value="5">Others</option>


</select>



<label>Description</label>

<textarea name="description"></textarea>



<label>Price</label>

<input type="number" name="price" required>




<label>Upload Image</label>

<input type="file"
name="image"
accept="image/*">



<button type="submit">
Add Product
</button>


</form>


</div>


</body>

</html>