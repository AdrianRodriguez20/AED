<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <title>Gestion Alumno</title>

    <link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' rel='stylesheet'>
    <link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
    <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <script type='text/javascript' src='https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js'></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap" rel="stylesheet">
    <link href='css/error.css' rel="stylesheet" type="text/css">

</head>

<body class='snippet-body'>
<div class="container-fluid px-0">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"
                aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="inicio.jsp"><i class="fas fa-home"></i></a>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="/Instituto/GestorAlumno">Alumno</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Instituto/GestorMatricula">Matrícula</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/Instituto/GestorAsignatura">Asignatura</a>
                </li>
            </ul>

        </div>
    </nav>

</div>
<div class="container">
    <h1 class="first-four">5</h1>
    <div class="cog-wheel1">
        <div class="cog1">
            <div class="top"></div>
            <div class="down"></div>
            <div class="left-top"></div>
            <div class="left-down"></div>
            <div class="right-top"></div>
            <div class="right-down"></div>
            <div class="left"></div>
            <div class="right"></div>
        </div>
    </div>

    <div class="cog-wheel2">
        <div class="cog2">
            <div class="top"></div>
            <div class="down"></div>
            <div class="left-top"></div>
            <div class="left-down"></div>
            <div class="right-top"></div>
            <div class="right-down"></div>
            <div class="left"></div>
            <div class="right"></div>
        </div>
    </div>
    <h1 class="second-four">5</h1>
    <p class="wrong-para">${pageContext.exception} </p>
    <button type="button" class="btn btn-primary " data-toggle="modal" data-target="#exampleModalLong">
        Ver detalles
    </button>

    <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
        <div class="modal-dialog" style="max-width: 50%; max-height: 10%" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Excepciones</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <h6>${pageContext.exception}</h6>
                    <c:forEach var="trace" items="${pageContext.exception.stackTrace}">
                        ${trace}<br/>
                    </c:forEach>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="js/error.js"></script>
</body>
</html>