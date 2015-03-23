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
		Vista de <b>Votos</b>
	</h2>
	<c:set var="votesView" scope="request" value="${votes}" />	
	<div>${votesView.update()}</div>
	<p>
		Estos son los votos del tema <b>${votesView.theme.name}</b>
	</p>
	<p>
		Pregunta: <b>${votesView.theme.question}</b>
	</p>
	<p>
		Total de votos: <b>${votesView.total}</b>
	</p>
	<p>
		Media de votos: <b>${votesView.average}</b>
	</p>
	<c:if test="${votesView.averageByStudies != null}">
   		<p>Media de votos para el nivel de estudios ${votesView.studies}: ${votesView.averageByStudy}<p>
	</c:if>
	<form action="/JEE_ECP/jsp/votes" method="post">
		<p>
			Nivel de estudios: 
			<select name="studies">
				<c:forEach var="studies" items="${votesView.studiesOptions}">
					<option value="${studies.name()}">${studies.name()}</option>
				</c:forEach>
			</select>
		</p>
		<p>			
			<input type="hidden" name="id" value="${votesView.theme.id}" />
			<input type="submit" value="Votar" />
		</p>
	</form>
	<p>
		<a href="/JEE_ECP/jsp/home">Volver a Home</a>
	</p>
</body>
</html>
