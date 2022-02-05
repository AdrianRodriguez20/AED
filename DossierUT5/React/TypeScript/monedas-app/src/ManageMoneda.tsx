import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Moneda } from './Monedas';
import { Link, Route, BrowserRouter, Routes } from 'react-router-dom';

interface IState { moneda?: Moneda }
export default function ManageMoneda() {
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
        },
        [idmoneda]
    )
    return (
        <div className='container-fluid'>
            <div className='row'>
                <div className="col-md-4">
                    <h3>Moneda</h3>

                    <div><b>Id: </b> {JSON.stringify(stmoneda.moneda?.idmoneda)}</div>
                    <div><b>Nombre: </b> {JSON.stringify(stmoneda.moneda?.nombre)}</div>
                    <div><b>Pais: </b> {JSON.stringify(stmoneda.moneda?.pais)}</div>
                    <h3>Historico</h3>
                    {
                        stmoneda.moneda?.historicos.map((historico: any) => {
                            return (
                                <div>
                                    <div><b>Id: </b> {JSON.stringify(historico.idhistoricocambioeuro)}</div>
                                    <div><b>Fecha: </b> {JSON.stringify(historico.fecha)}</div>
                                    <div><b>Equivalente en Euro: </b> {JSON.stringify(historico.equivalenteeuro)}</div>
                     
                                </div>
                            );
                        })
                    }
                  <Link to={`/monedas/${JSON.stringify(stmoneda.moneda?.idmoneda)}/createHistorico/`} > Añadir Historico </Link>  &nbsp;
                  <Link to={`/monedas/update/${JSON.stringify(stmoneda.moneda?.idmoneda)}`} > Editar </Link> &nbsp;
                  <Link to={`/monedas/delete/${JSON.stringify(stmoneda.moneda?.idmoneda)}`} > Eliminar </Link>  &nbsp;

                </div>
            </div>
        </div>
    )
}

