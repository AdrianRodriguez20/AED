<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

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
            <link href="../style/pelicula.css" rel="stylesheet">

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
                            <a class="nav-link" href="/sakila/Actores">Categorias</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/sakila/Categoria">Actores</a>
                        </li>
                    </ul>
                </div>
            </nav>

            <div class="container">
                <div class="row">
                    <div class="col-sm-12 col-lg-12">

                        <div class="feature-box-1">
                            <div class="feature-content">
                                <div class="row">
                                    <div class="col-md-4">
                                        <img class="img-fluid" src="../img/inicio/cartelera.jpg" />
                                    </div>
                                    <div class="col-md-8">
                                        <h5>${pelicula.getTitle()}</h5>
                                        <Strong >Sinopsis</Strong></br>
                                        <p class="card-text text-justify">${pelicula.getDescription()}</p>
                                        <Strong >Idioma</Strong></br>
                                        <p class="card-text text-justify">${pelicula.getLanguageId().getName()}</p>
                                        <Strong >Categorias</Strong></br>
                                        <c:forEach items="${pelicula.getFilmCategoryList()}" var="categoria">
                                            <span class="badge badge-primary">	${categoria.getCategory().getName()}</span>
                                        </c:forEach>
										</br>
										<Strong >Actores</Strong></br>
                                        <c:forEach items="${pelicula.getFilmActorList()}" var="actor">
                                            ${actor.getActor().getFirstName()} <br>
                                        </c:forEach>

                                    </div>
                                </div>


                            </div>
                        </div>

                    </div>
                </div>

            </div>

        </body>

        </html>