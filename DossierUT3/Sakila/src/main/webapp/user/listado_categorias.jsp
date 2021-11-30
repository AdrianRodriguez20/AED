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

            <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
            <link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap-extended.min.css">
            <link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/fonts/simple-line-icons/style.min.css">
            <link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/colors.min.css">
            <link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap.min.css">

            <link href="../style/navbar_user.css" rel="stylesheet">
            <link href="../style/user_listado_categorias.css" rel="stylesheet">
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
                            <a class="nav-link " href="/sakila/Pelicula">Peliculas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="/sakila/Categoria">Categorias</a>
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
            <div class="container">
                <section id="minimal-statistics ">
                    <div id="myDiv" class="row  m-3">
                     <c:forEach items="${categorias}" var="categoria">
                        <div class=" object col-xl-3 col-sm-6 col-12">
                            <div class="card">
                                <a class="link" href="Pelicula?categoria=${categoria.getCategoryId()}">
                                <div class="card-content">
                                    <div class="card-body">
                                        <div class="media d-flex">
                                            <div class="align-self-center">
                                                <i class="fas fa-theater-masks red font-large-2 float-left"></i>
                                            </div>
                                            <div class="media-body text-right">
                                                <h3>${categoria.getName()}</h3>
                                                <span>35 peliculas</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                </a>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                    </section>
                    </div>
        </body>

        </html>