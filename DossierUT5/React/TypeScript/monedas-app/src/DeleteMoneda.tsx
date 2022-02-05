import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Moneda } from './Monedas';
import { Link, Route, BrowserRouter, Routes } from 'react-router-dom';

export default function DeleteMoneda() {

    const { idmoneda } = useParams();
    const borrarMonedaApi = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        let ruta = "http://localhost:8080/api/v1/monedas/" + idmoneda;
        const axiospost = async (rutaDeMoneda: string) => {
            try {
                const { data } = await axios.delete(rutaDeMoneda)
                console.log(data);
                window.location.href = "/monedas";
            } catch (error) {
                console.log(error);
            }
        }
        axiospost(ruta);
    }


    return (

        <form onSubmit={borrarMonedaApi}>
            <h3>
                ¿Esta seguro de eliminar la moneda?
            </h3>
            <button type="submit"> Si </button>
        </form>
    )



}