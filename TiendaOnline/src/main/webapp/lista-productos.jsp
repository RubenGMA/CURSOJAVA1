<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
<title>LISTA PRODUCTOS</title>
</head>
<body>
	<h1>Tienda Online</h1>
	<div> usuario: ${sessionScope.usuario.nombre }</div>
	<h4>Lita de productos</h4>
	<a href="comprar?id=${producto.idProducto}"></a>
	<ul>
	<c:forEach var="producto" items="${requestScope.lista}">
		<li>${producto.idProducto} - ${producto.descripcion}  <button type="button" class="btn btn-danger btn-sm" ></button></li> 
	</c:forEach>
	</ul>
</body>
</html>