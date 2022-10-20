<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Lista Clientes</title>
</head>
<body>
	<h1>Lista Clientes</h1>
	<div class="col-auto">
	<a class="btn btn-primary" href="listaclientes"
		role="button">Ver Lista de clientes</a>
	<br><br>
	<ul>
		<c:forEach var="customer" items="${requestScope.lista}">
			<li>${customer.firstName}, ${customer.lastName} <a
				href="cuentas?customer=${customer.firstName}">Ver cuentas</a>
			</li>
		</c:forEach>
	</ul>
	</div>
</body>
</html>