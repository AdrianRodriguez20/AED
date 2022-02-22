import React from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Plato } from '../../interfaces/Plato';
import '../../style/plato/ListadoPlato.css';

export default function ListadoPlatos() {

    const [stplatos, setStplatos] = useState<Plato[]>(new Array<Plato>());

    useEffect(
        () => {
            const getPlatos = async () => {
                let token: string = localStorage.getItem("token") as string;
                const headers = {
                    headers: { Authorization: token }
                };
                let rutaPlatos = process.env.REACT_APP_API_URL + "/v2/platos";
                let { data } = await axios.get(rutaPlatos, headers);
                setStplatos(data);
            }
            getPlatos();
        },
        [stplatos]
    )
    const actualizarDisponibilidadApi = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        let formulario: HTMLFormElement = event.currentTarget;
        let buttonidplato: HTMLInputElement = formulario.idplato;
        let buttondisponible: HTMLInputElement = formulario.disponible;
        let idplato = buttonidplato.value;
        let disponible = buttondisponible.value;
        let token: string = localStorage.getItem("token") as string;
        const headers = {
            headers: { Authorization: token }
        };
        let ruta = process.env.REACT_APP_API_URL + "/v2/platos/" + idplato + "/disponibilidad?disponible=" + disponible;
        const axiospost = async (rutaPlatos: string) => {
            try {
                const { data } = await axios.put(rutaPlatos);

            } catch (error) {
                console.log(error);
            }
        }
        axiospost(ruta);
    }


    return (
        <>
            <section className="food_section layout_padding">
                <div className="container">
                    <div className="heading_container heading_center">
                        <h2>
                            Listado Platos
                        </h2>
                    </div>
                    <div className="filters-content">
                        <div className="row grid">
                            {
                                stplatos.map(
                                    (plato: Plato) => {
                                        return (
                                            <div className="col-sm-6 col-lg-4  mb-3 " key={plato.idplato}>
                                                <div className="box" style={{ "height": "95%" }}>
                                                    <div>
                                                        <div className="img-box">
                                                            <img src="imagenes/f1.png" alt="" />
                                                        </div>
                                                        <div className="detail-box"  >
                                                            <h5>
                                                                {plato.nombre}
                                                            </h5>
                                                            <p>
                                                                {plato.descripcion}
                                                            </p>
                                                            <div className="options">
                                                                <div className="row">
                                                                    <div className="col-8">

                                                                        <h6 className="mt-4" style={{ "fontSize": "25px" }}>
                                                                            {plato.preciounidad}€

                                                                        </h6>
                                                                    </div>
                                                                    <div className="col-4  mt-3" style={{ "display": "flex", "justifyContent": "flex-end" }}>
                                                                        <div className='ml-5 mr-3'>
                                                                            {plato.disponible ?
                                                                                <>
                                                                                    <form onSubmit={actualizarDisponibilidadApi}>

                                                                                        <input type="hidden" name="idplato" value={plato.idplato} />
                                                                                        <button type="submit" id="disponible" value="false" className='buttonDisponible disponible'>
                                                                                            Disponible

                                                                                        </button>
                                                                                    </form>
                                                                                </>
                                                                                :
                                                                                <>
                                                                                    <form onSubmit={actualizarDisponibilidadApi}>
                                                                                        <input type="hidden" id="idplato" value={plato.idplato} />
                                                                                        <button type="submit" id="disponible" value="true" className='buttonDisponible agotado'>
                                                                                            Agotado
                                                                                        </button>
                                                                                    </form>
                                                                                </>
                                                                            }

                                                                        </div>
                                                                        <Link to={`/platos/${plato.idplato}/update`} className="mt-1">
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

                                            </div>
                                        )
                                    })
                            }
                        </div>
                    </div>
                    <Link to="/platos/create">
                        <button className="botonF1">
                        <i className="fas fa-plus"></i>
                        </button>
                    </Link>
                </div>
            </section>

        </>
    )

}