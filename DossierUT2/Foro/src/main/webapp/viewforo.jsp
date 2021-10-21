<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<meta charset="utf-8">
<meta name="author" content="juan carlos p.r.">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="refresh" content="20">
<title>foro web</title>


<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<h1 class="cabecera">IRC Foro</h1>
	<div class="principal">
		<div class="foro">



			David: Hola <br> Fabian: Hola <br>
			
			<c:forEach items="${mensajes}" var="men">
				${men} <br>
			</c:forEach>


		</div>


		<ul class="conectados">

		</ul>


		<form action="ForoWeb" method="POST">

			<label for="nombre">nombre: </label>
			 <input type="text" name="nombre" id="nombre" value=${nombre} ${nombre!=null?'disabled':''}>
			<textarea name="mensaje" id="mensaje" cols="20" rows="10"></textarea>
			<input type="submit" value="Enviar">

		</form>
	</div>







</body>
</html>