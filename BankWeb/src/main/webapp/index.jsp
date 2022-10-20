<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Clientes</title>
</head>
<body> 
<h1>Lista Clientes</h1>
<button class="btn btn-primary" href="ListaClientesServlet" role="button">Ver Lista de clientes</button>
	<ul>
		<c:forEach var="customer" items="${requestScope.lista}">
			<li>
				${customer.firstName}, ${customer.lastName}
				<a href="cuentas?customer=${customer.firstName}">Ver cuentas</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>