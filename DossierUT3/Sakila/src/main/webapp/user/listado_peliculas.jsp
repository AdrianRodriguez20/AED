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
            <link href="../style/user_listado_peliculas.css" rel="stylesheet">
            <link href="../style/search.css" rel="stylesheet">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
			<script src="../js/buscador_user.js"></script>

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
                            <a class="nav-link active" href="/sakila/Pelicula">Peliculas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/sakila/Categoria">Categorias</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/sakila/Actores">Actores</a>
                        </li>
                    </ul>
                </div>
            </nav>
		<div class="container mt-4">
			<div class="d-flex justify-content-center h-100">
				<div class="searchbar">
					<input class="search_input" type="text" id="search"
						placeholder="Search..."> <a href="" class="search_icon"><i
						class="fas fa-search"></i></a>
				</div>
			</div>
		</div>
            <div class="container mt-5">
                <div id="myDiv" class="row">
                    <c:forEach items="${peliculas}" var="pelicula">
                        <div class="object col-md-4 mt-3">
                            <div class="card card-custom bg-white border-white border-0">
                                <div class="card-custom-img" style="background-image: url(../img/inicio/viudanegra.jpg);">
                                </div>
                                <div class="card-custom-avatar">
                                    <img class="img-fluid" src="../img/inicio/logo_login.png" alt="Avatar" />
                                </div>
                                <div class="card-body" style="overflow-y: auto">
                                    <h4 class="card-title">${pelicula.getTitle()}</h4>
                                    <p class="card-text text-justify">${pelicula.getDescription()}
                                    </p>
                                </div>
                                <div class="card-footer text-center" style="background: inherit; border-color: inherit;">
                                    <a href="Pelicula?film=${pelicula.getFilmId()}" class="btn btn-dark">Ver más</a>
                                </div>
                            </div>

                        </div>
                    </c:forEach>

                </div>
            </div>


        </body>