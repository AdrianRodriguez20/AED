<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Apuesta</title>
</head>
<body>
	<form method="post" action="Principal">
		Apuesta: <input type="text" name="apuesta"><br> <input
			type="submit" value="apostar">
	</form>
	<span>Usuario: &nbsp; ${jugador.getNick()}</span><br>
	<span>Último ganador -  Nick: ${lastSecreto.getGanador()} Secreto:${lastSecreto.getNum()} Hora:${lastSecreto.getDateCreado()}</span><br>
	<span>Hora actual del secreto: ${secreto.getDateCreado()}</span><br>

	
	<c:forEach items="${jugador.getListaApuestas().values()}"
		var="numApuesta">
		<c:choose>
			<c:when test="${secreto.getNum() < numApuesta}">
   			Secreto &lt; ${numApuesta} <br>
  			</c:when>
			<c:when test="${secreto.getNum() > numApuesta}">
   			Secreto &gt; ${numApuesta}  <br>
  			</c:when>

		</c:choose>
	</c:forEach>

	<div>
	<c:forEach items="${secretos}" var="secr">
				${secr} <br>
			</c:forEach>
	</div>
</body>
</html>
