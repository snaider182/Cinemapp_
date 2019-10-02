<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvido a Cineapp</title>
</head>
<body>
	<h1>Lista de Peliculas</h1>
	<ol>
		<c:forEach var="pelicula" items="${ peliculas}">
			<li>${pelicula }</li>
		</c:forEach>
	</ol>
	Tabla de peliculas:
	<table border="I">
		<thead>
			<tr>
				<th>Id</th>
				<th>Titulo</th>
				<th>Duracion</th>
				<th>Clasificación</th>
				<th>Genero</th>
			</tr>
		</thead>
					
		<tbody>
			<c:forEach var="pelicula" items="${ peliculas}">
				<tr>
					<td>${pelicula.id} </td>
					<td>${pelicula.titulo} </td>
					<td>${pelicula.duracion} </td>
					<td>${pelicula.clasificacion} </td>
					<td>${pelicula.genero} </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>