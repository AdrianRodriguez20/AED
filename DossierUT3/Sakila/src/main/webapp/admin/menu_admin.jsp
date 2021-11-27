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
                    <a class="nav-link" href="/sakila/admin/listado_peliculas.jsp">Gestion Peliculas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/sakila/admin/listado_categorias.jsp">Gestion Categorias</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/sakila/admin/listado_actores.jsp">Gestion Actores</a>
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

    <section class="section services-section" id="services">
        <div class="container">

            <div class="row">

                <div class="col-sm-6 col-lg-4">
                    <a id="link" href="/sakila/GestionPeliculas?getAll=true">
                        <div class="feature-box-1">
                            <div class="icon"> <i class="fas fa-film"></i></div>
                            <div class="feature-content">
                                <h5>Gestion Peliculas</h5>
                                <p>Vamos de brunch, yo cubro la cuenta, tu pide a gusto, Mimosa, champaña, nuestro desayuno.</p>
                            </div>
                        </div>
                    </a>
                </div>


                <div class="col-sm-6 col-lg-4">
                    <a id="link" href="/sakila/admin/listado_categorias.jsp">
                        <div class="feature-box-1">
                            <div class="icon"> <i class="fa fa-th"></i></div>
                            <div class="feature-content">
                                <h5>Gestion Categorias</h5>
                                <p>Vamos de brunch, yo cubro la cuenta, t� pide a gusto, Mimosa, champa�a, nuestro desayuno.</p>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-sm-6 col-lg-4">
                    <a id="link" href="/sakila/admin/listado_actores.jsp">
                        <div class="feature-box-1">
                            <div class="icon"> <i class="fas fa-theater-masks"></i></div>
                            <div class="feature-content">
                                <h5>Gestion Actores</h5>
                                <p>Vamos de brunch, yo cubro la cuenta, t� pide a gusto, Mimosa, champa�a, nuestro desayuno.</p>
                            </div>
                        </div>
                    </a>
                </div>

                <div class="col-sm-6 col-lg-4">
                    <a id="link" href="/sakila/user/listado_peliculas.jsp">
                        <div class="feature-box-1">
                            <div class="icon"> <i class="fas fa-film"></i></div>
                            <div class="feature-content">
                                <h5>Peli�culas</h5>
                                <p>Vamos de brunch, yo cubro la cuenta, t� pide a gusto, Mimosa, champa�a, nuestro desayuno.</p>
                            </div>
                        </div>
                    </a>
                </div>

                <div class="col-sm-6 col-lg-4">
                    <a id="link" href="/sakila/user/listado_category.jsp">
                        <div class="feature-box-1">
                            <div class="icon"> <i class="fa fa-th"></i></div>
                            <div class="feature-content">
                                <h5>Categorias</h5>
                                <p>Vamos de brunch, yo cubro la cuenta, t� pide a gusto, Mimosa, champa�a, nuestro desayuno.</p>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-sm-6 col-lg-4">
                    <a id="link" href="/sakila/user/listado_actores.jsp">
                        <div class="feature-box-1">
                            <div class="icon"><i class="fas fa-theater-masks"></i></div>
                            <div class="feature-content">
                                <h5>Actores</h5>
                                <p>Vamos de brunch, yo cubro la cuenta, t� pide a gusto, Mimosa, champa�a, nuestro desayuno.</p>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </section>
</body>



</html>