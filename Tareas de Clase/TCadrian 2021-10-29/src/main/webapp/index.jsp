<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h5>Poner el nombre del fichero y el texto que quieras guardar</h5>
    <h6>(si no existe el fichero se crea nuevo. Si existe se sobreescribe)</h6>
   <form name="enviar" method="post" action="Principal" >
		Nombre fichero: 
		<input type="text" name="rutaGuardar" value=${rutaGuardar}><br> 
		<textarea name="contenido">${contenido}</textarea>
		<input type="submit"  value="enviar">
   	</form>
     <hr>
        <h5>Poner el nombre del fichero y el texto que quieras guardar</h5>
    <h6>(si no existe el fichero se crea nuevo. Si existe se sobreescribe)</h6>
    
    <form method="post" action="Principal">
		Nombre fichero: 
		<input type="text" name="rutaCargar"><br> 
		<input type="submit" value="cargar">
   	</form>
   	
     </body>
</html>
