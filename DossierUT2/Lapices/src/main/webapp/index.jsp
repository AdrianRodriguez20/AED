<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<title>Gestionar Lapices</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
<style>
.boxImpar {
	background-color: #d9e6ed;
}

.boxPar {
	background-color: #d0e0e0;
}

body {
	background-color: #e8f4f4;
}
</style>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 mt-3">
				<h3 class="text-center boxImpar p-3 ">Gestionar Lapices</h3>
				<h4 class="text-center boxPar p-2">Lapices</h4>
			</div>
		</div>
		<div class="row m-3">
			<div class="col-md-3 boxImpar ">

				<p class="text-center font-weight-bold mt-3">Agregar lapiz</p>
				<form action="gestionlapices" METHOD="POST">
					<div class="form-group row">
						<label for="marcaAgregar" class="col-md-4 col-form-label">*Marca:</label>
						<div class="col-md-8">
							<input type="text" class="form-control" name="marcaAgregar">
						</div>
					</div>
					<div class="form-group row">
						<label for="numeroAgregar" class="col-md-4 col-form-label">Numero:</label>
						<div class="col-md-8">
							<input type="number" class="form-control" name="numeroAgregar">
						</div>
					</div>
					<div class="form-group row ">
						<div class=" col text-center">
							<button type="submit" class="btn btn-primary" name="agregar"
								value="agregar">Agregar</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-3 boxPar">
				<p class="text-center font-weight-bold mt-3">Borrar lapiz</p>
				<form action="gestionlapices" METHOD="POST">
					<div class="form-group row">
						<label for="idLapizBorrar" class="col-md-4 col-form-label">*ID:</label>
						<div class="col-md-8">
							<input type="number" class="form-control" name="idLapizBorrar">
						</div>
					</div>
					<div class="form-group row ">
						<div class=" col text-center">
							<button type="submit" class="btn btn-primary" name="borrar"
								value="borrar">Borrar</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-3 boxImpar">
				<p class="text-center font-weight-bold mt-3">Editar lapiz</p>
				<form action="gestionlapices" METHOD="POST">
					<div class="form-group row">
						<label for="idLapizEditar" class="col-md-4 col-form-label">*ID:</label>
						<div class="col-md-8">
							<input type="number" class="form-control" name="idLapizEditar">
						</div>
					</div>
					<div class="form-group row">
						<label for="marcaEditar" class="col-md-4 col-form-label">Marca:</label>
						<div class="col-md-8">
							<input type="text" class="form-control" name="marcaEditar">
						</div>
					</div>
					<div class="form-group row">
						<label for="numeroEditar" class="col-md-4 col-form-label">Número:
						</label>
						<div class="col-md-8">
							<input type="number" class="form-control" name="numeroEditar">
						</div>
					</div>
					<div class="form-group row ">
						<div class=" col text-center">
							<button type="submit" class="btn btn-primary" name="editar"
								value="editar">Editar</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-3 boxPar">
				<p class="text-center font-weight-bold mt-3">Buscar lapiz</p>
				<form action="gestionlapices" METHOD="POST">

					<div class="form-group row">
						<div class="col-md-4">
							<select class="form-control  " id="opcionBuscar" name="opcionBuscar" ID ="opcionBuscar">
								<option selected name="buscarPor" value="idLapizBuscar">ID</option>
								<option id="buscarPor" name="buscarPor"  value="marcaBuscar">Marca</option>
							</select>
						</div>
						<div class="col-md-7">
							<input type="number" class="form-control" id="lapizBuscar" name="lapizBuscar">
						</div>
					</div>
					<div class="form-group row ">
						<div class=" col text-center">
							<button type="submit" class="btn btn-primary" name="buscar"
								value="buscar">Buscar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-12">
			<textarea class="form-control" name="resultado" rows="10"><c:choose>
         <c:when test="${lapiz!=null}"> ${lapiz} </c:when> <c:when
						test="${lapices!=null}">
         <c:forEach items="${lapices}" var="lpz"> ${lpz} </c:forEach> </c:when>
      </c:choose>
           </textarea>
		</div>
	</div>
<script src="js/script.js" language="javascript" type="text/javascript"></script>
</body>

</html>