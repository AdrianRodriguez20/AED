<!DOCTYPE html>
<html lang="es">

<head>
    <title>Sakila</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Adriï¿½n Rodrï¿½guez Fuentes">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="../style/menu_admin.css" rel="stylesheet">
    <link href="../style/navbar_admin.css" rel="stylesheet">
    <link rel="icon" href="https://icon-library.com/images/film-icon/film-icon-0.jpg">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
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
                    <a class="nav-link" href="/sakila/GestionCategorias?getAll=true">Gestion Categorias</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/sakila/GestionActores?getAll=true">Gestion Actores</a>
                </li>
            </ul>
            <!-- USER -->
            <ul class="navbar-nav ">
                <a class="nav-link logo" href="/sakila/Logout"">
                    <img src="../img/inicio/user.png" class="img-fluid rounded-circle z-depth-0 img-user">
                </a>
            </ul>
        </div>
    </nav>

    <section class="section services-section" id="services">
        <div class="container">

            <div class="row">

                <div class="col-sm-6 col-lg-4">
                    <a class="link" href="/sakila/GestionPeliculas?getAll=true">
                        <div class="feature-box-1">
                            <div class="icon"> <i class="fas fa-film"></i></div>
                            <div class="feature-content">
                                <h5>Gestion Peliculas</h5>
                                <p>Gestionar peliculas , aquí podrás añadir peliculas a la lista del videoclub , editarlas, ...etc.</p>
                            </div>
                        </div>
                    </a>
                </div>


                <div class="col-sm-6 col-lg-4">
                    <a class="link" href="/sakila/GestionCategorias?getAll=true">
                        <div class="feature-box-1">
                            <div class="icon"> <i class="fa fa-th"></i></div>
                            <div class="feature-content">
                                <h5>Gestion Categorias</h5>
                                <p>Gestionar categorias , aquí podrás añadir categorias a la lista del videoclub , editarlas, ...etc.</p>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-sm-6 col-lg-4">
                    <a class="link" href="/sakila/GestionActores?getAll=true">
                        <div class="feature-box-1">
                            <div class="icon"> <i class="fas fa-theater-masks"></i></div>
                            <div class="feature-content">
                                <h5>Gestion Actores</h5>
                                <p>Gestionar actores , aquí podrás añadir actores a la lista del videoclub , editarlas, ...etc.</p>
                            </div>
                        </div>
                    </a>
                </div>

                <div class="col-sm-6 col-lg-4">
                    <a class="link" href="/sakila/Pelicula">
                        <div class="feature-box-1">
                            <div class="icon"> <i class="fas fa-film"></i></div>
                            <div class="feature-content">
                                <h5>Películas</h5>
                                <p>Desde aquí podrás acceder a las peliculas , desde la vista del cliente para tener una visión general.</p>
                            </div>
                        </div>
                    </a>
                </div>

                <div class="col-sm-6 col-lg-4">
                    <a class="link" href="/sakila/Categoria">
                        <div class="feature-box-1">
                            <div class="icon"> <i class="fa fa-th"></i></div>
                            <div class="feature-content">
                                <h5>Categorias</h5>
                              <p>Desde aquí podrás acceder a las categorias , desde la vista del cliente para tener una visión general.</p>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-sm-6 col-lg-4">
                    <a class="link" href="/sakila/Actores">
                        <div class="feature-box-1">
                            <div class="icon"><i class="fas fa-theater-masks"></i></div>
                            <div class="feature-content">
                                <h5>Actores</h5>
                              <p>Desde aquí podrás acceder a los actores , desde la vista del cliente para tener una visión general.</p>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </section>
</body>



</html>