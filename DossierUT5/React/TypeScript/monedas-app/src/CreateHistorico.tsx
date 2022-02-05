import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Historico } from './Monedas';
import { Link, Route, BrowserRouter, Routes } from 'react-router-dom';


export default function CreateHistorico() {
    const { idmoneda } = useParams();
    const agregarHistoricoApi = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        let formulario: HTMLFormElement = event.currentTarget;

        let inputnombrefecha: HTMLInputElement = formulario.fecha;
        let inputequivalenteeuro: HTMLInputElement = formulario.equivalenteeuro;

        let fecha: string = inputnombrefecha.value;
        let equivalenteeuro: number = parseFloat(inputequivalenteeuro.value);
        const newhistorico = {
            "fecha": fecha,
            "equivalenteeuro": equivalenteeuro,
            "idmoneda": idmoneda  
        }
        let ruta = "http://localhost:8080/api/v1/historicos/"+idmoneda;
        const axiospost = async (rutaDeMoneda: string) => {
            try {
                const { data } = await axios.post(rutaDeMoneda, newhistorico)
                console.log(data);
           
            } catch (error) {
                console.log(error);
            }
        }
        axiospost(ruta);
    }
    return (
        <>
            <form onSubmit={agregarHistoricoApi}>
                Fecha: <input type="text" name="fecha" /><br />
                Equivalencia en Euros: <input type="text" id="equivalenteeuro" /> <br />
                <button type="submit">Crear </button>
            </form>
        </>
    )


}