<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Eliminar Tema</title>
</head>
<body>
	<h2>
		Vista de <b>Eliminar Tema</b>
	</h2>
	<c:set var="deleteThemeView" scope="request" value="${deleteTheme}" />
	<form action="/JEE_ECP/jsp/deleteTheme" method="post">
		<p>
			Se dispone a borrar el tema ${deleteThemeView.theme.name}
		</p>
		<p>
			Autorización: <input name="auth" type="text"/>
		</p>
		<p>
			<input type="submit" value="Eliminar tema" />
		</p>
		<input type="hidden" name="id" value="${deleteThemeView.theme.id}" />
	</form>
	<p>
		<a href="/Web/v1/home">Volver a Home</a>
	</p>
</body>
</html>