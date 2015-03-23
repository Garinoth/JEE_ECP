<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>Themes</title>
</head>
<body>
	<h2>
		Vista de <b>Temas</b>
	</h2>
	<c:set var="themesView" scope="request" value="${themes}" />	
	<div>${themesView.update()}</div>
	<c:forEach var="theme" items="${themesView.themes}">
		<table border="1">
			<tr>
				<td><a href="/JEE_ECP/jsp/votes?id=${theme.id}">${theme.name}</a></td>
				<td>${theme.question}</td>
				<td>
					<form action="/JEE_ECP/jsp/vote" method="get">
						<p><input type="submit" value="Votar tema"/>
						<input type="hidden" name="id" value="${theme.id}" /></p>
					</form>
				</td>
				<td>
					<form action="/JEE_ECP/jsp/deleteTheme" method="get">
						<p><input type="submit" value="Eliminar tema"/>
						<input type="hidden" name="id" value="${theme.id}" /></p>
					</form>
				</td>
			</tr>
		</table>
	</c:forEach>
	
	<form action="/JEE_ECP/jsp/addTheme" method="get">
		<p><input type="submit" value="Añadir tema"/></p>
	</form>

	<p>
		<a href="/JEE_ECP/jsp/home">Volver a Home</a>
	</p>
</body>
</html>
