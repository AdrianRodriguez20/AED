import React from 'react'
import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Plato } from '../../interfaces/Plato';
import { useNavigate } from 'react-router-dom';

export default function UpdatePlatos() {
    let navigate = useNavigate();
    const [stplato, setStplato] = useState<Plato>({} as Plato);
    const { id } = useParams();
    useEffect(
        () => {
            const getPlato = async (id: string | undefined) => {
                let rutaPlato = process.env.REACT_APP_API_URL + "/v2/platos/" + id;
                let token: string = localStorage.getItem("token") as string;
                const headers = {
                    headers: { Authorization: token }
                };
                let { data } = await axios.get(rutaPlato, headers);
                setStplato(data);
            }
            getPlato(id);
        }, []);
    const actualizarPlatoApi = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        let formulario: HTMLFormElement = event.currentTarget;
        let inputpreciounidad: HTMLInputElement = formulario.preciounidad;
        let inputdisponible: HTMLInputElement = formulario.disponible;
        let inputdescripcion: HTMLInputElement = formulario.descripcion;
        let inputnombre: HTMLInputElement = formulario.nombre;

        let preciounidad = parseFloat(inputpreciounidad.value);
        let disponible = inputdisponible.value;
        let descripcion = inputdescripcion.value;
        let nombre = inputnombre.value;

        let plato = {
            idplato: stplato.idplato,
            preciounidad: preciounidad,
            disponible: disponible,
            descripcion: descripcion,
            nombre: nombre
        }

        let ruta = process.env.REACT_APP_API_URL + "/v2/platos/" + id;

        const axiospost = async (rutaServicio: string) => {
            let token: string = localStorage.getItem("token") as string;
            const headers = {
                headers: { Authorization: token }
            };
            try {
                const { data } = await axios.put(rutaServicio, plato, headers);
                console.log(data);

            } catch (error) {
                console.log(error);

            }

        }

        axiospost(ruta);
    }

    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        event.preventDefault();
        const name = event.target.id;
        const value = event.target.value;

        setStplato({
            ...stplato,
            [name]: value
        });

    }

    const handleChangeSelect = (event: React.ChangeEvent<HTMLSelectElement>) => {
        event.preventDefault();
        const name = event.target.id;
        const value = event.target.value;

        setStplato({
            ...stplato,
            [name]: value
        });

    }
    return (
        <>
            <section className="book_section layout_padding">
                <div className="container">
                    <div className="heading_container heading_center">
                        <h2>
                            Actualizar Plato
                        </h2>
                    </div>
                    <div className="row mt-5 ">
                        <div className="col-md-6 ">
                            <div className="form_container">
                                <form onSubmit={actualizarPlatoApi} >
                                    <div>
                                        <input
                                            type="text"
                                            className="form-control"
                                            id="nombre"
                                            placeholder="Nombre"
                                            value={stplato.nombre}
                                            onChange={handleChange}
                                        />
                                    </div>
                                    <div>
                                        <input
                                            type="text"
                                            className="form-control"
                                            id="descripcion"
                                            placeholder="Descripción"
                                            value={stplato.descripcion}
                                            onChange={handleChange}
                                        />
                                    </div>
                                    <div>
                                        <select
                                            className="form-control
                                        nice-select wide"
                                            id="disponible"
                                            onChange={handleChangeSelect}
                                        >
                                            <option value="" disabled >
                                                Disponibilidad
                                            </option>
                                            <option
                                                value="true"
                                                selected={stplato.disponible === true}
                                            >
                                                Disponible
                                            </option>
                                            <option
                                                value="false"
                                                selected={stplato.disponible === false}
                                            >

                                                Agotado
                                            </option>
                                        </select>
                                    </div>
                                    <div>
                                        <input
                                            type="text"

                                            className="form-control"
                                            id="preciounidad"
                                            value={stplato.preciounidad}
                                            onChange={handleChange}
                                            placeholder="Precio" />
                                    </div>
                                    <div className="btn_box text-center">
                                        <button>
                                            Crear
                                        </button>
                                    </div>

                                </form>
                            </div>
                        </div>

                        <div className=" offset-md-1 col-md-5  ">
                            <div className="map_container ">
                                <div id="imgPlato" >
                                    <img src={`/imagenes/hamburguesa2.svg`} style={{ "width": "80%" }} alt="" />
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </>
    )
}