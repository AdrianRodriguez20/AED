import axios from 'axios';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom'
;

export interface Moneda {
  idmoneda: number;
  nombre: string;
  pais: string;
  historicos: Historico[];
}
export interface Historico {
  idhistoricocambioeuro: number;
  fecha: string;
  equivalenteeuro: number;
  idmoneda: number;
}
interface IState {monedas?: Array<Moneda>;}
export default function Monedas() {

  const [monedas, setStmonedas] = useState<IState>({});

  useEffect(
      () => {
          const getMoneda = async () => {
              let rutaDeMoneda = "http://localhost:8080/api/v1/monedas/";
              let { data } = await axios.get(rutaDeMoneda);
              let monedas: Array<Moneda> = data;
              console.log(monedas);
              setStmonedas({ monedas });
          }
         getMoneda();

      },
      []
  )
    let arrayMonedas = monedas.monedas;
    return (
      <>
        <h3>Monedas</h3>
        <div className='container-fluid'>
          <div className='row'>
         
              {
                arrayMonedas?.map((moneda: Moneda) => {
                  return (
                    <div className="col-md-4 border" >
                      <div><b>Id: </b> {JSON.stringify(moneda.idmoneda)}</div>
                      <div><b>Nombre: </b> {JSON.stringify(moneda.nombre)}</div>
                      <div><b>Pais: </b> {JSON.stringify(moneda.pais)}</div>
                      <Link to={`/monedas/${JSON.stringify(moneda.idmoneda)}`} > Ver mas </Link> &nbsp;
                    </div>
                  );
                })
              }
            </div>
          </div>
     

      </>
    );
 
    

}
