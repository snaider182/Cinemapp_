<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvido a Cineapp</title>
<spring:url value="/resources" var="urlPublic" />
<link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css" />
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
							<td><fmt:formatDate value="${pelicula.fechaEstreno}" pattern="dd-MM-yyyy"/></td>
							<td><img src="${urlPublic}/imagenes/${pelicula.imagen}" width="80" height="100"></td>
							<td>
								<c:choose>
									<c:when test="${pelicula.estatus == 'Activa'}">
										<span class ="label label-success">ACTIVA</span>
									</c:when>
									<c:when test="${pelicula.estatus == 'Inactiva'}">
										<span class ="label label-danger">INACTIVA</span>
									</c:when>
									
								</c:choose>
							
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>