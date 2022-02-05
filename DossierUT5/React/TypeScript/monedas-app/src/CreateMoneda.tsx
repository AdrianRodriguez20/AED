import React from 'react'
import axios from 'axios';
import { Link, Route, BrowserRouter, Routes } from 'react-router-dom';

export default function CreateMoneda() {
    const agregarMonedaApi = (event: React.FormEvent<HTMLFormElement>) => {

        event.preventDefault();
        let formulario: HTMLFormElement = event.currentTarget;

        let inputnombremoneda: HTMLInputElement = formulario.nombremoneda;
        let inputpaismoneda: HTMLInputElement = formulario.paismoneda;

        let nombre: string = inputnombremoneda.value;
        let pais: string = inputpaismoneda.value;
        const newmoneda = {
            "nombre": nombre,
            "pais": pais,
            "historicos": []
        }
        let ruta = "http://localhost:8080/api/v1/monedas";
        const axiospost = async (rutaDeMoneda: string) => {
            try {
                const { data } = await axios.post(rutaDeMoneda, newmoneda)
                console.log(data);
                window.location.href = "/monedas/"+data.idmoneda;
            } catch (error) {
                console.log(error);
            }
        }
        axiospost(ruta);
    }
    return (
        <>
            <form onSubmit={agregarMonedaApi}>
                Nombre: <input type="text" name="nombremoneda" /><br />
                País: <input type="text" id="paismoneda" /> <br />
                <button type="submit">Crear </button>
            </form>
        </>
    )
}