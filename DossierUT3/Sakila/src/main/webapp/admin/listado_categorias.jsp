<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <title>Sakila</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Adri�n Rodr�guez Fuentes">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="icon" href="https://icon-library.com/images/film-icon/film-icon-0.jpg">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    <link href="../style/navbar_admin.css" rel="stylesheet">
    <link href="../style/admin_listado_categorias.css" rel="stylesheet">
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
                <a class="nav-link logo" href="">
                    <img src="../img/inicio/user.png" class="img-fluid rounded-circle z-depth-0 img-user">
                </a>
            </ul>
        </div>
    </nav>
    <div class="container mt-3 text-right">
        <a class="btn btn-danger addfilm" href="GestionCategorias?create=category">
        A�adir Categor�a</a>
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
                                    <th class="column2">Categor�a</th>
                                    <th class="column3">Ver</th>
                                    <th class="column4">Editar</th>
                                    <th class="column5">Eliminar</th>
                                </tr>
                            </thead>
                        </table>
                    </div>

                    <div class="table100-body js-pscroll">
                        <table>
                            <tbody>
                              <c:forEach items="${categorias}" var="categoria">
                                <tr class="row100 body">
                                    <td class="column1">${categoria.getCategoryId()}</td>
                                    <td class="column2">${categoria.getName()}</td>
                                    <td class="column3">
                                      
                                    <a href="Categoria?categoria=${categoria.getCategoryId()}" class="btn btn-primary"> <i class="far fa-eye" style="color:white"></i></a>
                                    </td>
                                    <td class="column4">
                                       <a href="GestionCategorias?categoria=${categoria.getCategoryId()}" class="btn btn-warning"> <i class="far fa-edit" style="color:white"></i></a>                                 
                                    </td>
                                    <td class="column5">
                                        <form action="GestionCategorias" method="post" >
                                            <input type="hidden" name="id" value="${categoria.getCategoryId()}">
                                            <button type="submit" class="btn btn-danger"  name="submit" value="borrar" onclick="return confirm('Are you sure you want to delete this item?');"> <i class="far fa-trash-alt" style="color:white"></i></button>
                                        </form>
                                    </td>

                                </tr>
   							</c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>