<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="es">

        <head>
            <title>Sakila</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <meta name="author" content="Adrián Rodríguez Fuentes">

            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
            <link rel="icon" href="https://icon-library.com/images/film-icon/film-icon-0.jpg">
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
            <link href="../style/navbar_user.css" rel="stylesheet">
            <link href="../style/user_listado_actores.css" rel="stylesheet">

        </head>

        <body>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
                <a class="navbar-brand" href="/sakila">SAKILA</a>

                <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">

                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="/sakila/user/listado_peliculas.html">Peliculas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="/sakila/user/listado_category.html">Categorias</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="/sakila/user/listado_actores.html">Actores</a>
                        </li>
                    </ul>
                </div>
            </nav>

            <div class="container mt-3">
                <div class="row justify-content-center">
                    <c:forEach items="${actores}" var="actor">
                    <!-- Actor-->
                    <div class="col-12 col-sm-6 col-lg-3">
                        <div class="single_advisor_profile wow fadeInUp" data-wow-delay="0.3s" style="visibility: visible; animation-delay: 0.3s; animation-name: fadeInUp;">

                            <div class="advisor_thumb"><img src="../img/Actores/adrian.png" alt="">

                            </div>
                            <div class="single_advisor_details_info">
                                <h6>${actor.getFirstName() }</h6>
                                <p class="designation">${actor.getLastName()} </p>
                            </div>
                        </div>
                    </div>
			</c:forEach>
                </div>
            </div>

        </html>