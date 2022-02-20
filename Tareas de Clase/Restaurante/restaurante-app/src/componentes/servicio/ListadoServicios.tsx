import axios from 'axios';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { useParams } from 'react-router-dom';
import '../../style/servicio/ListadoServicios.css';
import { Servicio } from '../../interfaces/Servicio';

export default function ListadoServicios() {

    const [stservicios, setStservicios] = useState<Servicio[]>(new Array<Servicio>());

    useEffect(
        () => {
            const getServicios = async () => {
                let rutaServicios = process.env.REACT_APP_API_URL + "/v1/servicios/";
                let { data } = await axios.get(rutaServicios);
                setStservicios(data);
            }
            getServicios();
        },
        []
    )

    return (
        <>
            <section className="food_section layout_padding">
                <div className="container">
                    <div className="heading_container heading_center">
                        <h2>
                            Servicios
                        </h2>
                    </div>
                    <div className="filters-content">

                        <div className="limiter">
                            <div className="container-table100">
                                <div className="wrap-table100">
                                    <div className="table100 ver1 m-b-110">
                                        <div className="table100-head">
                                            <table>
                                                <thead>
                                                    <tr className="row100 head">
                                                        <th className="cell100 column1">Numero mesa</th>
                                                        <th className="cell100 column2">Fecha</th>
                                                        <th className="cell100 column3">Hora</th>
                                                        <th className="cell100 column4">Pagado</th>
                                                        <th className="cell100 column5">Ver</th>
                                                    </tr>
                                                </thead>
                                            </table>
                                        </div>

                                        <div className="table100-body js-pscroll">
                                            <table>
                                                {

                                                    stservicios.map((servicio: Servicio) => (
                                                        <tbody>
                                                            <tr className="row100 body">
                                                                <td className="cell100 column1">{servicio.nummesa}</td>
                                                                <td className="cell100 column2">
                                                                    {new Date(servicio.fechacomienzo).toLocaleDateString()}</td>
                                                                <td className="cell100 column3">
                                                                    {new Date(servicio.fechacomienzo).toLocaleTimeString()}
                                                                </td>
                                                                <td className="cell100 column4">
                                                                    {servicio.pagada ? "Si" : "No"}
                                                                </td>
                                                                <td className="cell100 column5">
                                                                    <Link to={`/servicios/${servicio.idservicio}`} >
                                                                        <button className="btn " style={{ "background": "#6c7ae0" }}>
                                                                            <i className="fa fa-eye" style={{ "color": "white" }} ></i>
                                                                        </button>
                                                                    </Link>
                                                                </td>

                                                            </tr>
                                                        </tbody>
                                                    ))
                                                }

                                            </table>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </>
    )

}