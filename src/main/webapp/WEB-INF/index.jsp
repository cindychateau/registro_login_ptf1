<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro e Inicio de Sesión</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h2>Regístrate</h2>
				<form:form action="/registro" method="post" modelAttribute="nuevoUsuario">
					<div>
						<form:label path="nombre">Nombre</form:label>
						<form:input path="nombre" class="form-control" />
						<form:errors path="nombre" class="text-danger" />
					</div>
					<div>
						<form:label path="email">E-mail</form:label>
						<form:input path="email" class="form-control" />
						<form:errors path="email" class="text-danger" />
					</div>
					<div>
						<form:label path="contrasena">Contraseña</form:label>
						<form:password path="contrasena" class="form-control" />
						<form:errors path="contrasena" class="text-danger" />
					</div>
					<div>
						<form:label path="confirmacion">Confirmación</form:label>
						<form:password path="confirmacion" class="form-control" />
						<form:errors path="confirmacion" class="text-danger" />
					</div>
					<input type="submit" class="btn btn-success mt-3" value="Registrarme">
				</form:form>
			</div>
			<div class="col-6">
				<h2>Inicia Sesión</h2>
			</div>
		</div>
	</div>
</body>
</html>