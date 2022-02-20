import '../../style/style.css';
export default function SobreNosotros() {
    return (
        <>
            <section className="about_section layout_padding">
                <div className="container  ">

                    <div className="row">
                        <div className="col-md-6 ">
                            <div className="img-box">
                                <img src="imagenes/about-img.png" alt="" />
                            </div>
                        </div>
                        <div className="col-md-6">
                            <div className="detail-box">
                                <div className="heading_container">
                                    <h2>
                                        La Chubascada
                                    </h2>
                                </div>
                                <p style={{"textAlign":"justify"}} >
                                    Nuestro restaurante ofrece a sus clientes diferentes espacios con una capacidad de mas de 400 comensales. Disponemos de salones privados, donde podrá celebrar sus acontecimientos familiares mas especiales y de empresa. Además de nuestra carta muy variada, que destaca por sus productos frescos y de gran calidad.
                                </p>
                                <a href="">
                                    Contacta con nosotros
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </>
    )
}
