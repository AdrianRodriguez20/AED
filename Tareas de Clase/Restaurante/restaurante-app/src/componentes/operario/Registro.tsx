import '../../style/operario/Login.css';
import '../../style/operario/Registro.css';
export default function Registro() {
    return (
        <>
            <section className="food_section layout_padding">
                <div className="container">
                    <div className="row justify-content-center">
                        <div className="modal-login">
                            <div className="modal-content">
                                <div className="modal-header">
                                    <div className="avatar">
                                        <img src="../imagenes/login.png" alt="Avatar" />
                                    </div>
                                    <h4 className="modal-title">Registrarme</h4>

                                </div>
                                <div className="modal-body">
                                    <form action="Registro" method="post">
                                        <div className="form-group">
                                            <input type="text" className="form-control" name="name" placeholder="Usuario" />
                                        </div>
                                        <div className="form-group">
                                            <input type="password" className="form-control" name="password" placeholder="Contraseña" />
                                        </div>
                                        <div className="form-group">
                                            <input type="password" className="form-control" name="passwordConfirmation" placeholder="Confirma la Contraseña" />
                                        </div>
                                        <div className="form-group">
                                            <button type="submit" className="btn btn-primary btn-lg btn-block login-btn">Registrarme</button>
                                        </div>
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </>
    )
}