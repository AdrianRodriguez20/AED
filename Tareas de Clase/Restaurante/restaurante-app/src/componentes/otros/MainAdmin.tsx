
import '../../style/operario/Main.css';
import { Link } from 'react-router-dom';
export default function MainMenu() {
    return (
        <>
            <section className="section services-section" id="services">
                <div className="container">
                    <div className="row">
                        <div className="col-sm-6 col-lg-4">
                            <Link className="enlaces" to="/platos">
                                <div className="feature-box-1">
                                    <div className="icon"> <i className="fas fa-cheese"></i></div>
                                    <div className="feature-content">
                                        <h5>Gestion Platos</h5>
                                        <p>Gestiona la carta del restaurante , añade nuevos platos , modificalos.</p>
                                    </div>
                                </div>
                            </Link>
                        </div>
                        <div className="col-sm-6 col-lg-4">
                            <Link className="enlaces" to="/mesas">
                                <div className="feature-box-1">
                                    <div className="icon"> <i className="fas fa-hotdog"></i></div>
                                    <div className="feature-content">
                                        <h5>Gestion Mesas</h5>
                                        <p>Gestiona las mesas del restaurante , añade nuevos platos , modificalos.</p>
                                    </div>
                                </div>
                            </Link>
                        </div>
                        <div className="col-sm-6 col-lg-4">
                            <Link className="enlaces" to="/servicios">
                                <div className="feature-box-1">
                                    <div className="icon"> <i className="fas fa-hamburger"></i></div>
                                    <div className="feature-content">
                                        <h5>Gestion Servicios</h5>
                                        <p>Gestiona los servicios del restaurante , añade nuevos platos , modificalos.</p>
                                    </div>
                                </div>
                            </Link>
                        </div>
                        <div className="col-sm-6 col-lg-4">
                            <Link className="enlaces" to="/menu">
                                <div className="feature-box-1">
                                    <div className="icon"> <i className="fas fa-pizza-slice"></i></div>
                                    <div className="feature-content">
                                        <h5>Carta</h5>
                                        <p>Desde aquí podrás acceder al menu del restaurante </p>
                                    </div>
                                </div>
                            </Link>
                        </div>
                        <div className="col-sm-6 col-lg-4">
                            <Link className="enlaces" to="/">
                                <div className="feature-box-1">
                                    <div className="icon"> <i className="fa fa-apple"></i></div>
                                    <div className="feature-content">
                                        <h5>Inicio</h5>
                                        <p>Vuelve a la la pantalla de inicio , desde aquí podrás ver la parte del cliente</p>
                                    </div>
                                </div>
                            </Link>
                        </div>
                        <div className="col-sm-6 col-lg-4">
                            <Link className="enlaces" to="/servicios/create">
                                <div className="feature-box-1">
                                    <div className="icon"><i className="fas fa-lemon"></i></div>
                                    <div className="feature-content">
                                        <h5>Reserva</h5>
                                        <p>Accede directamente desde aquí para hacer una reserva.</p>
                                    </div>
                                </div>
                            </Link>
                        </div>
                    </div>
                </div>
            </section>
        </>
    )
}