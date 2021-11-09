<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <title>Gestion Alumno</title>

    <link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' rel='stylesheet'>
    <link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
    <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <script type='text/javascript'
            src='https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js'></script>
    <link href='css/style.css' rel="stylesheet" type="text/css">
    <script src="js/script.js" language="javascript" type="text/javascript"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap" rel="stylesheet">
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
                <li class="nav-item ">
                    <a class="nav-link" href="alumno.jsp">Alumno</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="matriculas.jsp">Matr�cula</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link " href="asignaturas.jsp">Asignatura<span class="sr-only">(current)</span></a>
                </li>
            </ul>

        </div>
    </nav>
    <div class="row justify-content-center" id="bg-div">
        <div class="col-lg-9 col-12">
            <div class="card card0">
                <div class="d-flex" id="wrapper">
                    <!-- Sidebar -->
                    <div class="bg-light border-right col-lg-2 col-4 " id="sidebar-wrapper">
                        <div class="sidebar-heading pt-5 pb-4"><strong>Asignatura</strong></div>
                        <div class="list-group list-group-flush">
                            <a data-toggle="tab" href="#menu1" id="tab1" class="tabs list-group-item active1">
                                <div class="list-div my-2">
                                    <div class="fa fa-user-plus"></div> &nbsp;&nbsp; Agregar
                                </div>
                            </a>
                            <a data-toggle="tab" href="#menu2" id="tab2" class="tabs list-group-item  bg-light">
                                <div class="list-div my-2">
                                    <div class="fa fa-trash-alt"></div> &nbsp;&nbsp; Borrar
                                </div>
                            </a>
                            <a data-toggle="tab" href="#menu3" id="tab3" class="tabs list-group-item bg-light">
                                <div class="list-div my-2">
                                    <div class="fa fa-user-edit"></div> &nbsp;&nbsp;&nbsp; Editar
                                </div>
                            </a>
                            <a data-toggle="tab" href="#menu4" id="tab4" class="tabs list-group-item bg-light">
                                <div class="list-div my-2">
                                    <div class="fa fa-search"></div> &nbsp;&nbsp;&nbsp; Buscar
                                </div>
                            </a>
                        </div>
                    </div>
                    <!-- Page Content -->
                    <div id="page-content-wrapper">
                        <div class="row pt-3" id="border-btm">
                            <div class="col-4">

                            </div>
                            <div class="col-8">
                                <div class="row justify-content-right">
                                    <div class="col-12">
                                        <p class="mb-0 mr-4 mt-4 text-right">Adri�n Rodr�guez Fuentes</p>
                                    </div>
                                </div>
                                <div class="row justify-content-right">
                                    <div class="col-12">
                                        <p class="mb-0 mr-4 text-right">2 DAM</span>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row justify-content-center">

                        </div>
                        <div class="tab-content">
                            <div id="menu1" class="tab-pane  in active">
                                <div class="row justify-content-center">
                                    <div class="col-11 ">
                                        <div class="form-card">
                                            <h3 class="mt-3 mb-4 text-center">Agregar Asignatura</h3>
                                            <form action="GestorAsignatura" method="POST">
                                                <div class="row">
                                                    <div class="col-12 col-md-4">
                                                        <div class="input-group"><input type="text"
                                                                                        id="nombreAgregar"
                                                                                        name="nombreAgregar">
                                                            <label for="nombreAgregar">Nombre</label>
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-md-8">

                                                        <div class="input-group"><input type="text"
                                                                                        id="cursoAgregar"
                                                                                        name="cursoAgregar">
                                                            <label for="cursoAgregar">Curso</label>
                                                        </div>

                                                    </div>

                                                </div>
                                                <div class="row">
                                                    <div class="col-md-3 offset-md-5"><input type="submit"
                                                                                             name="submit"
                                                                                             value="agregar"
                                                                                             class="btn btn-success placeicon">
                                                    </div>
                                                </div>

                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="menu2" class="tab-pane">

                                <div class="row justify-content-center">
                                    <div class="col-11">
                                        <div class="form-card">
                                            <h3 class="mt-3 mb-4 text-center">Borrar Asignatura</h3>
                                            <form action="GestorAsignatura" method="POST">
                                                <div class="row">

                                                    <div class="col-12">

                                                        <div class="input-group"><input type="text" id="idBorrar" name="idBorrar">
                                                            <label for="idBorrar">ID</label>
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-3 offset-md-5"><input type="submit"
                                                                                             name="submit"
                                                                                             value="borrar"
                                                                                             class="btn btn-success placeicon">
                                                    </div>
                                                </div>

                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div id="menu3" class="tab-pane">
                                <div class="row justify-content-center">
                                    <div class="col-11">
                                        <div class="form-card">

                                            <h3 class="mt-3 mb-4 text-center">Editar Asignatura</h3>
                                            <form action="GestorAsignatura" method="POST">
                                                <div class="row">
                                                    <div class="col-4">

                                                        <div class="input-group"><input type="text"
                                                                                        id="idEditar"
                                                                                        name="idEditar">
                                                            <label for="idEditar">ID</label>
                                                        </div>

                                                    </div>


                                                    <div class="col-8">
                                                        <div class="input-group"><input type="text"
                                                                                        id="nombreEditar"
                                                                                        name="nombreEditar">
                                                            <label for="nombreEditar">Nombre</label>
                                                        </div>
                                                    </div>


                                                    <div class="col-12">
                                                        <div class="input-group"><input type="text"
                                                                                        name="cursoEditar"
                                                                                        id="cursoEditar">
                                                            <label for="cursoEditar">Curso</label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-3 offset-md-5"><input type="submit"
                                                                                             name="submit"
                                                                                             value="editar"
                                                                                             class="btn btn-success placeicon">
                                                    </div>
                                                </div>

                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div id="menu4" class="tab-pane">
                                <div class="row justify-content-center">
                                    <div class="col-11">
                                        <div class="form-card">


                                            <h3 class="mt-3 mb-4 text-center">Buscar Alumno</h3>
                                            <form action="GestorAsignatura" method="POST">
                                                <div class="row">
                                                    <div class="col-6">
                                                        <div class="input-group"><input type="text" id="nombreBuscar"
                                                                                        name="nombreBuscar">
                                                            <label for="nombreBuscar">Nombre</label>
                                                        </div>
                                                    </div>


                                                    <div class="col-6">

                                                        <div class="input-group"><input type="text" id="idBuscar"
                                                                                        name="idBuscar">
                                                            <label for="idBuscar">ID</label>
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-3 offset-md-5"><input type="submit"
                                                                                             name="submit"
                                                                                             value="buscar"
                                                                                             class="btn btn-success placeicon">
                                                    </div>
                                                </div>

                                            </form>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-12 ">
                                    <textarea class="form-control" id="resultado" name="resultado" rows="10"><c:choose>
                                        <c:when test="${asignatura!=null}"> ${asignatura}
                                        </c:when>
                                        <c:when test="${asignaturas!=null}">
                                            <c:forEach items="${asignaturas}" var="asig"> ${asig}
                                            </c:forEach>
                                        </c:when>
                                    </c:choose></textarea>
            <div class="text-center mt-2">
                <button class="btn btn-success" id="clear">Limpiar</button>
                <button class="btn btn-success" id="copiar">Copiar</button>

            </div>
        </div>
    </div>
</div>


</body>

</html>