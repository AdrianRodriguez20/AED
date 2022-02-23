import React from 'react'
import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Plato } from '../../interfaces/Plato';
import { Servicio } from '../../interfaces/Servicio';
import { Detallefactura } from '../../interfaces/DetalleFactura';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';


export default function UpdateDetalleFactura() {

    let navigate = useNavigate();


    const [stservicio, setStservicio] = useState<Servicio>({} as Servicio);
    const { id } = useParams();
    const { idplato } = useParams();

    useEffect(() => {
        const getServicio = async (id: string | undefined) => {
            let token: string = localStorage.getItem("token") as string;
            const headers = {
                headers: { Authorization: token }
            };
            let rutaServicio = process.env.REACT_APP_API_URL + "/v2/servicios/";


            let { data } = await axios.get(rutaServicio + id, headers);


            setStservicio(data);

        }
        getServicio(id);


    }, []);






    const actualizarPlatoApi = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        let formulario: HTMLFormElement = event.currentTarget;
        let detallefactura: HTMLInputElement = formulario.cantidad;
        let cantidad = parseInt(detallefactura.value);
        let token: string = localStorage.getItem("token") as string;




        const headers = {
            headers: { Authorization: token }
        };
        let ruta = process.env.REACT_APP_API_URL + "/v2/servicios/" + id + "/platos/" + idplato;
        let data = {
            cantidad: cantidad
        }
        const axiosput = async (rutaPlato: string) => {
            try {
                axios.put(rutaPlato, data, headers);
                navigate("/servicios/" + id);
            } catch (error) {
                console.log(error);
            }
        }
        axiosput(ruta);

    }

    const borrarPlatoApi = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        let token: string = localStorage.getItem("token") as string;

        const headers = {
            headers: { Authorization: token }
        };

        let ruta = process.env.REACT_APP_API_URL + "/v2/servicios/" + id + "/platos/" + idplato;

        const axiosdelete = async (rutaDetalles: string) => {
            try {
                const { data } = await axios.delete(rutaDetalles)
                console.log(data);
                navigate("/servicios/" + id);
            } catch (error) {
                console.log(error);
            }
        }
        axiosdelete(ruta);


    }


    return (
        <>
            <section className="book_section layout_padding">
                <div className="container">
                    <div className="heading_container heading_center">
                        <h2>
                            Actualizar Unidades
                        </h2>
                    </div>

                    <div className="row">
                        <div className="col-md-6">
                            <div className="form_container">
                                <form onSubmit={actualizarPlatoApi}>
                                    {
                                        stservicio.detallefacturas?.map((detallefactura: Detallefactura) => {
                                            if (detallefactura.plato.idplato.toString() === idplato) {
                                                return (
                                                    <>
                                                        <div>
                                                            <input
                                                                type="text"
                                                                className="form-control"
                                                                value={detallefactura.plato.nombre}
                                                                readOnly
                                                            />
                                                        </div>

                                                        <div>
                                                            <input
                                                                type="number"
                                                                className="form-control"
                                                                id="cantidad"
                                                                defaultValue={detallefactura.cantidad}
                                                            />
                                                        </div>
                                                    </>
                                                )
                                            }
                                        })}
                                    <div className="btn_box text-center">
                                        <button type='submit'>
                                            Actualizar
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div className="col-md-6">
                        <div className="map_container ">
                                <div id="imgPlato" >
                                    <img src={`/imagenes/hamburguesa3.svg`} style={{ "width": "80%" }} alt="" />
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <form onSubmit={borrarPlatoApi} >

                    <button className="botonF1">
                        <i className="fas fa-trash"></i>
                    </button>
                </form >
            </section>

        </>


    )
}
