import React from 'react'
import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Plato } from '../../interfaces/Plato';

export default function Menu() {

    const [stplatosmenu, setStplatosmenu] = useState<Plato[]>(new Array<Plato>());

    useEffect(
        () => {
            const getPlatos = async () => {
                let rutaPlatos = process.env.REACT_APP_API_URL + "/v1/platos";
                let { data } = await axios.get(rutaPlatos);
                setStplatosmenu(data);
            }
            getPlatos();
        },
        []
    )
    return (
        <>
            <section className="food_section layout_padding">
                <div className="container">
                    <div className="heading_container heading_center">
                        <h2>
                            Menú
                        </h2>
                    </div>
                    <div className="filters-content">
                        <div className="row grid">
                            { 
                                    stplatosmenu.filter(plato => plato.disponible).map(
                                    (plato: Plato) => {
                                        return (
                                            <div className="col-sm-6 col-lg-4  mb-3 " key={plato.idplato}>
                                                <div className="box" style={{"height":"95%"}}>
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
                                                                <h6>
                                                                 {plato.preciounidad}€
                                                                </h6>
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