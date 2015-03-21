<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Votar Tema</title>
</head>
<body>
	<h2>
		Vista de <b>Añadir Tema</b>
	</h2>
	<c:set var="voteView" scope="request" value="${vote}" />
	<p>
		Se dispone a votar por el tema <b>${voteView.theme.name}</b>
	</p>
	<p>
		Pregunta: <b>${voteView.theme.question}</b>
	</p>
	<form action="/JEE_ECP/jsp/vote" method="post">
		<p>
			Nivel de estudios: <select name="studies">
				<c:forEach var="studies" items="${voteView.studies}">
					<option value="${studies.name}">${studies.name}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			Valoración: <input name="rating" type="number" min="1" max="10"/>
		</p>
			<input type="hidden" name="id" value="${voteView.theme.id}" />
		<p>
			<input type="submit" value="Votar" />
		</p>
	</form>
	<p>
		<a href="/Web/v1/home">Volver a Home</a>
	</p>
</body>
</html>