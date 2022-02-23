import axios from "axios";
import React from 'react'
import { useNavigate } from 'react-router-dom';
import {  toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';



export default function CreatePlatos() {
    let navigate = useNavigate();

    const agregarPlatoApi = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        let formulario: HTMLFormElement = event.currentTarget;
        let inputnombre: HTMLInputElement = formulario.nombre;
        let inputdescripcion: HTMLInputElement = formulario.descripcion;
        let inputpreciounidad: HTMLInputElement = formulario.preciounidad;
        let inputdisponible: HTMLSelectElement = formulario.disponible;


        let nombre = inputnombre.value;
        let preciounidad = parseFloat(inputpreciounidad.value);
        let disponible = inputdisponible.value;
        let descripcion = inputdescripcion.value;



        let plato = {
            nombre: nombre,
            descripcion: descripcion,
            preciounidad: preciounidad,
            disponible: disponible
        }

        let ruta = process.env.REACT_APP_API_URL + "/v2/platos";

        const axiospost = async (rutaServicio: string) => {
            let token: string = localStorage.getItem("token") as string;
            const headers = {
                headers: { Authorization: token }
            };

            await axios.post(rutaServicio,plato, headers ).then(
                (response) => {
                    console.log(response);
                    toast.success("Plato creado con exito");
                    navigate("/platos");
                }
            ).catch(
                (error) => {
                    console.log(error);
                    toast.error(error.response.data.message);
                    
                }
            );

        }

        axiospost(ruta);
    }

    return (
        <>
            <section className="book_section layout_padding">
                <div className="container">
                    <div className="heading_container heading_center">
                        <h2>
                            Guardar Plato
                        </h2>
                    </div>
                    <div className="row mt-5 ">
                        <div className="col-md-6 ">
                            <div className="form_container">
                                <form onSubmit={agregarPlatoApi} >
                                    <div>
                                        <input type="text" className="form-control" id="nombre" placeholder="Nombre" />
                                    </div>
                                    <div>
                                        <input type="text" className="form-control" id="descripcion" placeholder="Descripción" />
                                    </div>
                                    <div>
                                        <select className="form-control nice-select wide" id="disponible" >
                                            <option value="" disabled selected>
                                                Disponibilidad
                                            </option>
                                            <option value="true" >
                                                Disponible
                                            </option>
                                            <option value="false">
                                                Agotado
                                            </option>
                                        </select>
                                    </div>
                                    <div>
                                        <input type="text" className="form-control" id="preciounidad" placeholder="Precio" />
                                    </div>
                                    <div className="btn_box text-center">
                                        <button >
                                            Crear
                                        </button>
                                    </div>

                                </form>
                            </div>
                        </div>

                        <div className=" offset-md-1 col-md-5  ">
                            <div className="map_container ">
                                <div id="imgPlato" >
                                    <img src={`/imagenes/hamburguesa.svg`} style={{ "width": "80%" }} alt="" />
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </>
    )
}