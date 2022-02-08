export default function CreateMatricula() {
    return (
        <>
            <div className="container-contact100">
                <div className="wrap-contact100">
                    <form className="contact100-form validate-form" >
                        <span className="contact100-form-title">
                            Crear Matricula
                        </span>

                        <div className="wrap-input100 validate-input" >
                            <span className="label-input100">Año</span>
                            <input className="input100" type="text" id="nombre" placeholder="Introduce tu nombre" />
                            <span className="focus-input100"></span>
                        </div>


            


                        <div className="container-contact100-form-btn">
                            <div className="wrap-contact100-form-btn">
                                <div className="contact100-form-bgbtn"></div>
                                <button type='submit' className="contact100-form-btn">
                                    <span>Agregar </span>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </>
    )
}