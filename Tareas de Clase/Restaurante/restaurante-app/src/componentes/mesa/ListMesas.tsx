import axios from 'axios';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { useParams } from 'react-router-dom';
import '../../style/servicio/ListadoServicios.css';
import { Mesa } from '../../interfaces/Mesa';

export default function ListMesas() {


    const [stmesas, setStmesas] = useState<Mesa[]>(new Array<Mesa>());

    useEffect(
        () => {
            const getMesas = async () => {
                let rutaMesas = process.env.REACT_APP_API_URL + "/v1/mesas";
                let { data } = await axios.get(rutaMesas);
                setStmesas(data);
            }
            getMesas();
        },
        []
    )

    return (

        <>
            <section className="food_section layout_padding">
                <div className="container">
                    <div className="heading_container heading_center">
                        <h2>
                            Mesas
                        </h2>
                    </div>
                    <div className="filters-content">
                        <div className="row grid">
                            {
                                stmesas.map((mesa: Mesa) => {
                                    return (
                                        <div className="col-sm-6 col-lg-4  mb-3 " key={mesa.nummesa}>
                                            <div className="box" style={{ "height": "95%" }}>
                                                <div>
                                                    <div className="img-box">
                                                        <img src={`imagenes/mesas/${mesa.ocupantesmax}.png`} alt="" />
                                                    </div>
                                                    <div className="detail-box"  >
                                                        <div className="row">
                                                            <div className="col-md-4 text-center">

                                                                <p  style={{ "fontWeight": "bold"}}>
                                                                    Num:
                                                                </p>
                                                                <h5>
                                                                    {mesa.nummesa}
                                                                </h5>
                                                            </div>
                                                            <div className="col-md-4 text-center">
                                                                <p  style={{ "fontWeight": "bold"}}>
                                                                    Comensales:
                                                                </p>
                                                                <h5>
                                                                    {mesa.ocupantesmax}
                                                                </h5>
                                                            </div>
                                                            <div className="col-md-4">
                                                            <p  style={{ "fontWeight": "bold"}}>
                                                                    Editar:
                                                                </p>
                                                            <Link to={`/mesas/${mesa.nummesa}/update`} >
                                                                        <button className="btn mt-1 " style={{ "background": "#222831" , "borderColor":"white" }}>
                                                                            <i className="fa fa-pencil" style={{ "color": "white" }} ></i>
                                                                        </button>
                                                                    </Link>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    )
                                })
                            }
                        </div>
                    </div>
                </div>
            </section>

        </>
    )
}