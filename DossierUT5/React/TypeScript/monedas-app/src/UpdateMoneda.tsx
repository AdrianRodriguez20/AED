import React from 'react'
import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Moneda } from './Monedas';


interface IState { moneda?: Moneda }
export default function UpdateMoneda() {
    const [stmoneda, setStmoneda] = useState<IState>({});
    const { idmoneda } = useParams();
    useEffect(
        () => {
            const getMoneda = async (monedaid: string | undefined) => {
                let rutaDeMoneda = "http://localhost:8080/api/v1/monedas/";
                let { data } = await axios.get(rutaDeMoneda + monedaid);
                let moneda: Moneda = data;
                console.log(moneda);
                setStmoneda({ moneda });
            } 
            getMoneda(idmoneda);
        },  [] 
        );
 
    function actualizarMonedaApi(event: React.FormEvent<HTMLFormElement>) {
            event.preventDefault();
            let formulario: HTMLFormElement = event.currentTarget;

            let inputnombremoneda: HTMLInputElement = formulario.nombremoneda;
            let inputpaismoneda: HTMLInputElement = formulario.paismoneda;

            let nombre: string = inputnombremoneda.value;
            let pais: string = inputpaismoneda.value;
            const newmoneda = {
                "nombre": nombre,
                "pais": pais,
                "historicos": stmoneda.moneda?.historicos
            };
            let ruta = "http://localhost:8080/api/v1/monedas/"+idmoneda;
            const axiosput = async (rutaDeMoneda: string ) => {
                try {
                    const { data } = await axios.put(rutaDeMoneda, newmoneda);
                    console.log(data);
                    window.location.href = "/monedas/"+idmoneda;
                } catch (error) {
                    console.log(error);
                }
            };
            axiosput(ruta);
        }
    return (
        <>
            <form onSubmit={actualizarMonedaApi}>
                Nombre: <input type="text" name="nombremoneda" defaultValue={stmoneda.moneda?.nombre} /><br />
                País: <input type="text" id="paismoneda" defaultValue={stmoneda.moneda?.pais} /> <br />
                <button type="submit">Actualizar </button>
            </form>
        </>
    )
}