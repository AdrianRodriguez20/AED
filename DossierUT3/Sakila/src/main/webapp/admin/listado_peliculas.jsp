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
    <link href="../style/navbar_admin.css" rel="stylesheet">
    <link href="../style/admin_listado_peliculas.css" rel="stylesheet">
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
                    <a class="nav-link  active" href="/sakila/admin/listado_peliculas.jsp">Gestión Peliculas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/sakila/admin/listado_categorias.jsp">Gestión Categorias</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/sakila/admin/listado_actores.jsp">Gestión Actores</a>
                </li>
            </ul>
            <!-- USER -->
            <ul class="navbar-nav ">
                <a class="nav-link logo" href="">
                    <img src="/img/inicio/user.png" class="img-fluid rounded-circle z-depth-0 img-user">
                </a>
            </ul>
        </div>
    </nav>
    <div class="container mt-3 text-right">
        <button class="btn btn-secondary addfilm">
        Add Film</i> </button>
    </div>
    <div class="limiter">
        <div class="container-table100">
            <div class="wrap-table100">
                <div class="table100 ver1 m-b-110">
                    <div class="table100-head">
                        <table>
                            <thead>
                                <tr class="row100 head">
                                    <th class="column1">ID</th>
                                    <th class="column2">Ti­tulo</th>
                                    <th class="column3">Estreno</th>
                                    <th class="column4">Ver</th>
                                    <th class="column5">Editar</th>
                                    <th class="column6">Eliminar</th>
                                </tr>
                            </thead>
                        </table>
                    </div>

                    <div class="table100-body js-pscroll">
                        <table>
                            <tbody>
                              <c:forEach items="${peliculas}" var="pelicula">
                                <tr class="row100 body">
                                    <td class="column1">${pelicula.getFilmId()}</td>
                                    <td class="column2">${pelicula.getTitle()}</td>
                          
                                    <td class="column3">${pelicula.getReleaseYear()}</td>
                                    <td class="column4">
                                      
                                    <a href="GestionPeliculas?film=${pelicula.getFilmId()}" class="btn btn-primary"> <i class="far fa-eye" style="color:white"></i></a>
                                    </td>
                                    <td class="column5">
                                       <a href="GestionPeliculas?film=${pelicula.getFilmId()}" class="btn btn-warning"> <i class="far fa-edit" style="color:white"></i></a>                                 
                                    </td>
                                    <td class="column6">
                                       <a href="Pelicula?film=${pelicula.getFilmId()}" class="btn btn-danger"><i class="fas fa-trash" style="color:white"></i></a>
                                    
                                    </td>

                                </tr>
   							</c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

</body>

</html>