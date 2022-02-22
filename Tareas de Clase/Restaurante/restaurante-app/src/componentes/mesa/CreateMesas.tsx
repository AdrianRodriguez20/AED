import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import { Mesa } from '../../interfaces/Mesa';


export default function CreateMesas() {
    let navigate = useNavigate();
    const [stocupantesmax, setStocupantesmax] = useState<number>(0);


    const handleChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
        event.preventDefault();
        
        const name = event.target.id;
        const value = event.target.value;

        if (name === "ocupantesmax") {
            setStocupantesmax(parseInt(value));
        }
    }
    const agregarMesaApi = (event: React.FormEvent<HTMLFormElement>) => {
        let formulario: HTMLFormElement = event.currentTarget;
        let inputnummesa: HTMLInputElement = formulario.fechacomienzo;
        let selectocupantesmax : HTMLSelectElement = formulario.ocupantesmax;

        let nummesa = parseInt(inputnummesa.value);
        let ocupantesmax = parseInt (selectocupantesmax.value);

        let mesa = {
            nummesa: nummesa,
            selectocupantesmax: ocupantesmax
        }

        let ruta = process.env.REACT_APP_API_URL + "/v1/mesas";

        const axiospost = async (rutaMesa: string) => {
            let token: string = localStorage.getItem("token") as string;
            const headers = {
                headers: { Authorization: token }
            };
            try {
				const { data } = await axios.put(rutaMesa, mesa ,headers);
				console.log(data);

                

			} catch (error) {
				console.log(error);

			}

        }
        axiospost(ruta);
    }

    return (
        <>

            <section className="book_section layout_padding">
            <div className="container">
                    <div className="heading_container heading_center">
                        <h2>
                           Crear Mesa
                        </h2>
                    </div>
                    <div className="row">
                        <div className="col-md-6">
                            <div className="form_container">
                                <form onSubmit={agregarMesaApi}>
                                    <div>
                                        <input type="number" className="form-control" id="nummesa" placeholder="Número de mesa" />
                                    </div>

                                    <div>
                                        <select className="form-control nice-select wide" id="ocupantesmax" onChange={handleChange}>
                                            <option value="0" disabled selected>
                                                Número de comensales
                                            </option>
                                            <option value="2">
                                                2
                                            </option>
                                            <option value="3">
                                                3
                                            </option>
                                            <option value="4">
                                                4
                                            </option>
                                            <option value="5">
                                                5
                                            </option>
                                            <option value="6">
                                               6
                                            </option>
                                            <option value="7">
                                                7
                                            </option>
                                            <option value="8">
                                                8
                                            </option>
                                        </select>
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
                                <img src={`/imagenes/mesas/${stocupantesmax}.png`} style={{"width":"50%"}}  alt="" />                              
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </>
    )
}