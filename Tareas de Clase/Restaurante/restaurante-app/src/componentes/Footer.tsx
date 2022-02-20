import '../style/style.css';
export default function Footer() {
    return (
        <>
            <footer className="footer_section">
                <div className="container">
                    <div className="row">
                        <div className="col-md-4 footer-col">
                            <div className="footer_contact">
                                <h4>
                                    Contacta
                                </h4>
                                <div className="contact_link_box">
                                    <a href="">
                                        <i className="fa fa-map-marker" aria-hidden="true"></i>
                                        <span>
                                            Ubicación
                                        </span>
                                    </a>
                                    <a href="">
                                        <i className="fa fa-phone" aria-hidden="true"></i>
                                        <span>
                                            Llama 922-922-922
                                        </span>
                                    </a>
                                    <a href="">
                                        <i className="fa fa-envelope" aria-hidden="true"></i>
                                        <span>
                                            restaurante@gmail.com
                                        </span>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div className="col-md-4 footer-col">
                            <div className="footer_detail">
                                <a href="" className="footer-logo">
                                    La Chubascada
                                </a>
                                <p>
                                  Bienvienidos al mejor restaurante de las Islas Canarias, La Chubascada, inaugarada en marzo de 2018.
                                </p>
                                <div className="footer_social">
                                    <a href="">
                                        <i className="fa fa-facebook" aria-hidden="true"></i>
                                    </a>
                                    <a href="">
                                        <i className="fa fa-twitter" aria-hidden="true"></i>
                                    </a>
                                    <a href="">
                                        <i className="fa fa-linkedin" aria-hidden="true"></i>
                                    </a>
                                    <a href="">
                                        <i className="fa fa-instagram" aria-hidden="true"></i>
                                    </a>
                                    <a href="">
                                        <i className="fa fa-pinterest" aria-hidden="true"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div className="col-md-4 footer-col">
                            <h4>
                                Horario
                            </h4>
                            <p>
                                Miércoles - Domingo
                            </p>
                            <p>
                                 12:00 - 23:00
                            </p>
                        </div>
                    </div>
                    <div className="footer-info">
                        <p>&copy; <span id="displayYear"></span> All Rights Reserved By
                            <a href=""> La Chubascada</a><br></br>
                            &copy; <span id="displayYear"></span> Distributed By
                            <a href="" target="_blank"> Adrián Rodríguez</a>
                        </p>

                    </div>
                </div>
            </footer>
        </>
    )
}
