<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Añadir Tema</title>
</head>
<body>
	<h2>
		Vista de <b>Añadir Tema</b>
	</h2>
	<c:set var="addThemeView" scope="request" value="${addThemeView}" />
	<form action="/JEE_ECP/jsp/addTheme" method="post">
		<p>
			Nombre: <input name="name" type="text" />
		</p>
		<p>
			Pregunta: <input name="question" type="text"/>
		</p>
		<p>
			<input type="submit" value="Añadir tema" />
		</p>
	</form>
	<p>
		<a href="/Web/v1/home">Volver a Home</a>
	</p>
</body>
</html>