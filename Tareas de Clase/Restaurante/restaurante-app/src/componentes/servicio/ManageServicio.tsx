import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Servicio } from '../../interfaces/Servicio';
import { useNavigate } from 'react-router-dom';
import { Detallefactura } from '../../interfaces/DetalleFactura';

export default function ManageServicio() {

    let navigate = useNavigate();
    const [stservicio, setStservicio] = useState<Servicio>({} as Servicio);
    //state total
    const [sttotal, setSttotal] = useState<number>(0);
    const { id } = useParams();

    useEffect(() => {
        const getServicio = async (id: string | undefined) => {
            let rutaServicio = process.env.REACT_APP_API_URL + "/v1/servicios/";
            let { data } = await axios.get(rutaServicio + id);


            setStservicio(data);

        }
        getServicio(id);


    }, []);

    //sumar total
    useEffect(() => {
        let total = 0;
        stservicio.detallefacturas?.forEach(detallefactura => {
            total += parseFloat(JSON.stringify(detallefactura.plato.preciounidad)) * parseFloat(JSON.stringify(detallefactura.cantidad))
        });
        setSttotal(total);
    }, [stservicio.detallefacturas]);


    return (
        <>
            <div className="container mt-5 mb-5">
                <div className="row d-flex justify-content-center">
                    <div className="col-md-8">

                        <div className="card">

                            <div className="invoice p-5">
                                <h1>Reserva nº : {stservicio.idservicio}</h1>
                                <span className="font-weight-bold d-block mt-4">Concepto</span>
                                <span>{stservicio.reservada}</span>
                                <div className="payment border-top mt-3 mb-3 border-bottom table-responsive">
                                    <table className="table table-borderless">
                                        <tbody>
                                            <tr>
                                            <td>
                                                    <div className="py-2"> <span className="d-block text-muted">Fecha</span>
                                                        <span>
                                                            {new Date(stservicio.fechacomienzo).toLocaleDateString()}
                                                             </span> </div>
                                                </td>
                                                <td>
                                                    <div className="py-2"> <span className="d-block text-muted">Hora: </span>
                                                    {new Date(stservicio.fechacomienzo).toLocaleTimeString()}
                                                        <span> </span> </div>
                                                </td>
                                                <td>
                                                    <div className="py-2"> <span className="d-block text-muted">Pagado</span>
                                                        <span>{stservicio.pagada ? "Si" : "No"}</span> </div>
                                                </td>
                                                <td>
                                                    <div className="py-2"> <span className="d-block text-muted">Num Mesa:</span>
                                                        <span> {stservicio.nummesa}</span> </div>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div className="product border-bottom table-responsive">
                                    <table className="table table-borderless">
                                        <tbody>
                                            {stservicio.detallefacturas?.map((detallefactura: Detallefactura) => {
                                                return (
                                                    <tr key={detallefactura.iddetallefactura} >
                                                        <td width="20%"> <img src="/imagenes/plato-servicio.png" width="90" /> </td>
                                                        <td width="60%"> <span className="font-weight-bold">{detallefactura.plato.nombre}</span>
                                                            <div className="product-qty"> <span className="d-block">{detallefactura.cantidad} ud. * {detallefactura.preciounidad}€/ud.</span> <span></span> </div>
                                                        </td>
                                                        <td width="20%">
                                                            <div className="text-right"> <span className="font-weight-bold">

                                                                {
                                                                    parseFloat(JSON.stringify(detallefactura.plato.preciounidad)) * parseFloat(JSON.stringify(detallefactura.cantidad))
                                                                }
                                                                €


                                                            </span> </div>
                                                        </td>
                                                    </tr>

                                                )
                                            })}


                                        </tbody>
                                    </table>
                                </div>
                                <div className="row d-flex justify-content-end">
                                    <div className="col-md-5">
                                        <table className="table table-borderless">
                                            <tbody className="totals">

                                                <tr className="border-top border-bottom">
                                                    <td>
                                                        <div className="text-left"> <span className="font-weight-bold">Subtotal</span> </div>
                                                    </td>
                                                    <td>
                                                        <div className="text-right"> <span className="font-weight-bold">
                                         
                                                        {sttotal}€
                                                    
                                                        </span> </div>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )



}