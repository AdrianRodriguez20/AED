<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <title>Sakila</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Adrián Rodríguez Fuentes">


    <link rel="icon"
          href="https://icon-library.com/images/film-icon/film-icon-0.jpg">

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>

    <link href="../style/navbar_admin.css" rel="stylesheet">
    <link href="../style/insertar.css" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarTogglerDemo03"
            aria-controls="navbarTogglerDemo03" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="/sakila/inicio.html">SAKILA</a>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">

        </ul>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/sakila/GestionPeliculas?getAll=true">Gestion Peliculas</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="/sakila/GestionCategorias?getAll=true">Gestion Categorias</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/sakila/GestionActores?getAll=true">Gestion Actores</a>
            </li>
        </ul>
        <!-- USER -->
        <ul class="navbar-nav ">
            <a class="nav-link logo" href="/sakila/Logout"> <img
                    src="../img/inicio/user.png"
                    class="img-fluid rounded-circle z-depth-0 img-user">
            </a>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-sm-12 col-lg-12">

            <div class="feature-box-1">
                <div class="feature-content">
                    <form action="GestionCategorias" method="POST">
                        <div class="form-group">
                            <label for="nombre"><strong>Categoría</strong></label> <input
                                type="text" class="form-control" id="nombre" name="nombre"
                                placeholder="Accion">
                        </div>
                        <button type="submit" class="btn btn-primary"    name="submit"
                                value="insertar">Insertar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>