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
                let token: string = localStorage.getItem("token") as string;
                const headers = {
                    headers: { Authorization: token }
                };
                let rutaMesas = process.env.REACT_APP_API_URL + "/v2/mesas";
                let { data } = await axios.get(rutaMesas, headers);
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

                                                                <p style={{ "fontWeight": "bold" }}>
                                                                    Num:
                                                                </p>
                                                                <h5>
                                                                    {mesa.nummesa}
                                                                </h5>
                                                            </div>
                                                            <div className="col-md-4 text-center">
                                                                <p style={{ "fontWeight": "bold" }}>
                                                                    Comensales:
                                                                </p>
                                                                <h5>
                                                                    {mesa.ocupantesmax}
                                                                </h5>
                                                            </div>
                                                            <div className="col-md-4 text-center mt-1">
                                                             
                                                                <Link to={`/mesas/${mesa.nummesa}/update`} >
                                                                <button type="submit" id="disponible" value="true" className='buttonDisponible edit'>
                                                                                <li className='fas fa-edit'></li>
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
                    <Link to="/mesas/create">
                        <button className="botonF1">
                        <i className="fas fa-plus"></i>
                        </button>
                    </Link>
                </div>
            </section>

        </>
    )
}