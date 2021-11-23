<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <title>Sakila</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="AdriÃ¡n RodrÃ­guez Fuentes">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="icon" href="https://icon-library.com/images/film-icon/film-icon-0.jpg">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    <link href="../style/navbar_user.css" rel="stylesheet">
    <link href="../style/user_listado_peliculas.css" rel="stylesheet">

</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="/sakila/inicio.html">SAKILA</a>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">

            </ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="/sakila/user/listado_peliculas.jsp">Peliculas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/sakila/user/listado_category.jsp">Categorias</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/sakila/user/listado_actores.jsp">Actores</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container mt-5">
        <div class="row">
            <div class="col-md-4">
                <div class="card card-custom bg-white border-white border-0">
                    <div class="card-custom-img" style="background-image: url(../img/inicio/viudanegra.jpg);">
                    </div>
                    <div class="card-custom-avatar">
                        <img class="img-fluid" src="../img/inicio/logo_login.png" alt="Avatar" />
                    </div>
                    <div class="card-body" style="overflow-y: auto">
                        <h4 class="card-title">Black Widow</h4>
                        <p class="card-text text-justify">Al nacer, la Viuda Negra, también conocida como Natasha Romanova, se entrega a la KGB para convertirse en su agente definitivo. Cuando la URSS se separa, el gobierno intenta matarla mientras la acción se traslada a la actual Nueva
                            York.
                        </p>
                    </div>
                    <div class="card-footer text-center" style="background: inherit; border-color: inherit;">
                        <a href="#" class="btn btn-dark">Ver más</a>
                    </div>
                </div>

            </div>

            <div class="col-md-4">
            </div>
            <div class="col-md-4">
            </div>
        </div>
    </div>


</body>