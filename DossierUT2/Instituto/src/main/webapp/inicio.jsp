<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <link href='css/inicio.css' rel="stylesheet" type="text/css">
</head>

<body class='snippet-body'>
    <div class="container-fluid px-0">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="inicio.jsp"><i class="fas fa-home"></i></a>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="alumno.jsp">Alumno<span class="sr-only"></span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Matrícula</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="#">Asignatura</a>
                    </li>
                </ul>

            </div>
        </nav>

    </div>
    <div class="container mt-5">
        <div class="row ">
            <div class="col-md-4">
                <div class="wrimagecard wrimagecard-topimage">
                    <a href="alumno.jsp">
                        <div class="wrimagecard-topimage_header text-center" style="background-color:#8CC0FF">
                            <i class="fas fa-user-graduate " style="color:white "></i>
                        </div>
                        <div class="wrimagecard-topimage_title">
                            <h4 class="text-center titulos">
                                Alumnos
                            </h4>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-md-4">
                <div class="wrimagecard wrimagecard-topimage">
                    <a href="Alumnos.html">
                        <div class="wrimagecard-topimage_header text-center" style="background-color:#8CC0FF">
                            <i class="fas fa-graduation-cap" style="color:white "></i>
                        </div>
                        <div class="wrimagecard-topimage_title">
                            <h4 class="text-center titulos">
                                Matrícula
                            </h4>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-md-4">
                <div class="wrimagecard wrimagecard-topimage">
                    <a href="Alumnos.html">
                        <div class="wrimagecard-topimage_header text-center" style="background-color:#8CC0FF">
                            <i class="fas fa-book " style="color:white "></i>

                        </div>
                        <div class="wrimagecard-topimage_title">
                            <h4 class="text-center titulos">
                                Asignatura
                            </h4>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
