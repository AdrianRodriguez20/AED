import axios from 'axios';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { useParams } from 'react-router-dom';
import '../../style/servicio/ListadoServicios.css';
import { Servicio } from '../../interfaces/Servicio';
import {  toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

export default function ListadoServicios() {

    const [stservicios, setStservicios] = useState<Servicio[]>(new Array<Servicio>());

    useEffect(
        () => {
            const getServicios = async () => {
                let token: string = localStorage.getItem("token") as string;
                const headers = {
                    headers: { Authorization: token }
                };
                let rutaServicios = process.env.REACT_APP_API_URL + "/v2/servicios/";
                let { data } = await axios.get(rutaServicios, headers);
             
                setStservicios(data);
            }
            getServicios();
        },
        []
    )
    const borrarServicioApi = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        let formulario: HTMLFormElement   = event.currentTarget;
        let inputId: HTMLInputElement  = formulario.idservicio;
        let id = inputId.value;
        let token: string = localStorage.getItem("token") as string;
        const headers = {
            headers: { Authorization: token }
        };
        let ruta = process.env.REACT_APP_API_URL + "/v2/servicios/";
        const axiosdelete = async (rutaServicios: string) => {

            await axios.delete(rutaServicios +id ,headers).then(
                (response) => {
                    setStservicios(  stservicios.filter(servicio => servicio.idservicio !== Number(id)) );
                    toast.success("Servicio borrado correctamente");
                }
            ).catch(
                (error) => {
                    toast.error(error.response.data.message);
                }
            );

        } 
         axiosdelete(ruta);
            
    }

    return (
        <>
            <section className="food_section layout_padding">
                <div className="container">
                    <div className="heading_container heading_center">
                        <h2>
                            Servicios
                        </h2>
                    </div>
                    <div className="filters-content ">

                        <div className="limiter">
                            <div className="container-table100">
                                <div className="wrap-table100">
                                    <div className="table100 ver1 m-b-110">
                                        <div className="table100-head">
                                            <table>
                                                <thead>
                                                    <tr className="row100 head">
                                                        <th className="cell100 column1">Num  </th>
                                                        <th className="cell100 column2">Fecha</th>
                                                        <th className="cell100 column3">Hora</th>
                                                        <th className="cell100 column4">Pagado</th>
                                                        <th className="cell100 column5">Ver</th>
                                                        <th className="cell100 column6">Editar</th>
                                                        <th className="cell100 column7">Eliminar</th>
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
                                                                <td className="cell100 column6">
                                                                     <Link  to={`/servicios/${servicio.idservicio}/update`}>
                                                                        <button className="btn " style={{ "background": "#6c7ae0" }}>
                                                                            <i className="fa fa-pencil" style={{ "color": "white" }} ></i>
                                                                        </button>
                                                                    </Link>
                                                                </td>
                                                                <td className="cell100 column7">
                                                               <form onSubmit={borrarServicioApi}>
                                                               <input type="hidden" id="idservicio" value={servicio.idservicio} />
                                                                        <button className="btn " style={{ "background": "#6c7ae0" }}>
                                                                            <i className="fa fa-trash" style={{ "color": "white" }} ></i>
                                                                        </button>
                                                                 </form>
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
                    <Link to="/servicios/create">
                        <button className="botonF1">
                        <i className="fas fa-plus"></i>
                        </button>
                    </Link>
                </div>
            </section>
        </>
    )

}