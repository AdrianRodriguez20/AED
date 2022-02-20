import '../style/style.css';
import '../style/operario/Login.css';
export default function Navbar() {
    return (
        <>
            <div className="sub_page">
                <div className="hero_area">
                    <div className="bg-box">
                        <img src="../imagenes/navbar.jpg" alt="" />
                    </div>
                    <header className="header_section">
                        <div className="container">
                            <nav className="navbar navbar-expand-lg custom_nav-container ">
                                <a className="navbar-brand" href="/">
                                    <span>
                                        La Chubascada
                                    </span>
                                </a>

                                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                    <span className=""> </span>
                                </button>

                                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                                    <ul className="navbar-nav  mx-auto ">
                                        <li className="nav-item active">
                                            <a className="nav-link" href="/">Inicio<span className="sr-only">(current)</span> </a>
                                        </li>
                                        <li className="nav-item ">
                                            <a className="nav-link" href="/platos">Menu  </a>
                                        </li>
                                        <li className="nav-item">
                                            <a className="nav-link" href="/sobrenosotros">Sobre Nosotros</a>
                                        </li>

                                    </ul>
                                    <div className="user_option">
                                        <a href="#myModal" data-toggle="modal" className="user_link">
                                            <i className="fa fa-user" aria-hidden="true"></i>

                                        </a>

                                        <form className="form-inline">
                                            <button className="btn  my-2 my-sm-0 nav_search-btn" type="submit">
                                                <i className="fa fa-search" aria-hidden="true"></i>
                                            </button>
                                        </form>
                                        <a href="" className="order_online">
                                        <i className='fa fa-phone'>    Reservar </i>
                                        </a>
                                    </div>
                                </div>
                            </nav>
                        </div>
                    </header>
                </div>
            </div>

            <div id="myModal" className="modal fade">
                <div className="modal-dialog modal-login">
                    <div className="modal-content">
                        <div className="modal-header">
                            <div className="avatar">
                                <img src="../imagenes/login.png" alt="Avatar" />
                            </div>
                            <h4 className="modal-title">Iniciar Sesión</h4>
                            <button type="button" className="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div className="modal-body">
                            <form action="Login" method="post">
                                <div className="form-group">
                                    <input type="text" className="form-control" name="name" placeholder="Usuario" />
                                </div>
                                <div className="form-group">
                                    <input type="password" className="form-control" name="password" placeholder="Contraseña" />
                                </div>
                                <div className="form-group">
                                    <button type="submit" className="btn btn-primary btn-lg btn-block login-btn">Login</button>
                                </div>
                            </form>
                        </div>
                        <div className="modal-footer">
                            <a href="/registro">Registrarme</a>
                        </div>
                    </div>
                </div>
            </div>

        </>
    )
}
