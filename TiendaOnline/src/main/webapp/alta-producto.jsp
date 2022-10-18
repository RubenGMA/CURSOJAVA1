<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Alta Producto</title>
</head>
<body>
	<h1>ALTA PRODUCTO</h1>
	<h4>Alta de un producto nuevo</h4>

	<form class="row g-3" action="AltaServlet" method="post">
		<div class="col-auto">
			<label for="nombreProducto" class="">Nombre Producto:</label> 
			<input type="text" id="nombreProducto" value="">
		</div>
		
		<div class="col-auto">
			<button type="submit" class="btn btn-primary mb-3">Confirm</button>
		</div>
	</form>


	<a class="btn-link" href="index.jsp" role="button">Volver</a>
</body>
</html>