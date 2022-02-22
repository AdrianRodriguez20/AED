import React from 'react'
import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Mesa } from '../../interfaces/Mesa';
import { useNavigate } from 'react-router-dom';

export default function UpdateMesas() {

    let navigate = useNavigate();
    const [stmesa, setStmesa] = useState<Mesa>({} as Mesa);
    const { id } = useParams();
    useEffect(
        () => {
            const getMesa = async (id: string | undefined) => {
                let rutaMesa = process.env.REACT_APP_API_URL + "/v2/mesas/" + id;
                let token: string = localStorage.getItem("token") as string;
                const headers = {
                    headers: { Authorization: token }
                };
                let { data } = await axios.get(rutaMesa, headers);
                setStmesa(data);
            }
            getMesa(id);
        }, []);

    const actualizarMesaApi = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        let formulario: HTMLFormElement = event.currentTarget;

        let inputnummesa: HTMLInputElement = formulario.nummesa;
        let selectocupantesmax: HTMLSelectElement = formulario.ocupantesmax;

        let nummesa = parseInt(inputnummesa.value);
        let ocupantesmax = parseInt(selectocupantesmax.value);

        let mesa = {
            nummesa: nummesa,
            ocupantesmax: ocupantesmax
        }

        let ruta = process.env.REACT_APP_API_URL + "/v2/mesas/" + id;

        const axiospost = async (rutaMesa: string) => {
            let token: string = localStorage.getItem("token") as string;
            const headers = {
                headers: { Authorization: token }
            };
            try {
                const { data } = await axios.put(rutaMesa, mesa, headers);
                console.log(data);
                navigate("/mesas");
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

        setStmesa({
            ...stmesa,
            [name]: value
        });

    }

    const handleChangeSelect = (event: React.ChangeEvent<HTMLSelectElement>) => {
        event.preventDefault();
        const name = event.target.id;
        const value = event.target.value;

        setStmesa({
            ...stmesa,
            [name]: value
        });

    }


    return (

        <>

            <section className="book_section layout_padding">
                <div className="container">
                    <div className="heading_container heading_center">
                        <h2>
                            Actualizar Mesa
                        </h2>
                    </div>
                    <div className="row">
                        <div className="col-md-6">
                            <div className="form_container">
                                <form onSubmit={actualizarMesaApi}>
                                    <div>
                                        <input 
                                        type="number"
                                         className="form-control" 
                                         id="nummesa" 
                                         placeholder="Número de mesa"
                                         value={stmesa.nummesa}
                                            onChange={handleChange}
                                          />
                                    </div>

                                    <div>
                                        <select className="form-control nice-select wide" id="ocupantesmax" onChange={handleChangeSelect}>
                                            <option value="0" disabled selected>
                                                Número de comensales
                                            </option>
                                            <option value="2" selected={stmesa.ocupantesmax === 2}>
                                                2
                                            </option>
                                            <option value="3" selected={stmesa.ocupantesmax === 3}>
                                                3
                                            </option>
                                            <option value="4" selected={stmesa.ocupantesmax === 4}>
                                                4
                                            </option>
                                            <option value="5" selected={stmesa.ocupantesmax === 5}>
                                                5
                                            </option>
                                            <option value="6" selected={stmesa.ocupantesmax === 6}>
                                                6
                                            </option>
                                            <option value="7" selected={stmesa.ocupantesmax === 7}>
                                                7
                                            </option>
                                            <option value="8" selected={stmesa.ocupantesmax === 8}>
                                                8
                                            </option>
                                        </select>
                                    </div>

                                    <div className="btn_box text-center">
                                        <button>
                                            Actualizar
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>

                        <div className=" offset-md-1 col-md-5  ">
                            <div className="map_container ">

                                <div id="imgPlato" >
                                    <img src={`/imagenes/mesas/${stmesa.ocupantesmax}.png`} style={{ "width": "50%" }} alt="" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </>
    )
}