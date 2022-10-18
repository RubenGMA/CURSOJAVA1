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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>login</title>
</head>
<body>
	<h1>Login</h1>
	<form class="row g-3" action="altaproducto" method="post">
		<div class="col-auto">

			<div>
				<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
				<div class="col-sm-10">
					<input type="" class="form-control" id="nombre" value="">
				</div>
			</div>
			<div>
				<label for="rol" class="col-sm-2 col-form-label">Rol</label>
				<div class="col-sm-10">
					<select class="form-select" aria-label="Default select example">
						<option selected>Open this select menu</option>
						<option value="1">One</option>
						<option value="2">Two</option>
						<option value="3">Three</option>
					</select>
				</div>
			</div>
			<br>
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary mb-3">Confirm</button>
			</div>

		</div>

	</form>
</body>
</html>