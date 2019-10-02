<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvido a Cineapp</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" 
	  integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" 
	  crossorigin="anonymous">
<spring:url value="/resources" var="urlPublic" />

</head>
<body>

	<%-- <h1>Lista de Peliculas</h1>
	<ol>
		<c:forEach var="pelicula" items="${ peliculas}">
			<li>${pelicula }</li>
		</c:forEach>
	</ol>
--%>


	<div class="panel panel-default">
		<div class="panel-heading">Tabla de peliculas:</div>
		<div class="panel-body">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Titulo</th>
						<th>Duracion</th>
						<th>Clasificación</th>
						<th>Genero</th>
						<th>Fecha de Estreno</th>
						<th>Imagen</th>
						<th>Estatus</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="pelicula" items="${ peliculas}">
						<tr>
							<td>${pelicula.id}</td>
							<td>${pelicula.titulo}</td>
							<td>${pelicula.duracion}</td>
							<td>${pelicula.clasificacion}</td>
							<td>${pelicula.genero}</td>
							<td>${pelicula.fechaEstreno}</td>
							<td><img src="${urlPublic}/imagenes/${pelicula.imagen}" width="80" height="100"></td>
							<td>${pelicula.estatus}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>