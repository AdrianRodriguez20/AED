import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import { Detallefactura } from '../../interfaces/DetalleFactura';
import { Mesa } from '../../interfaces/Mesa';
import { Plato } from '../../interfaces/Plato';
import { Link } from 'react-router-dom';
import '../../style/servicio/CrearDetalleFactura.css';
import {  toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


export interface Detalle {
    idplato: number;
    cantidad: number;
}

export default function CrearDetalleFactura() {
    let navigate = useNavigate();
    const { id } = useParams();

    const [stplatos, setStplatos] = useState<Plato[]>(new Array<Plato>());

    const [stdetallefactura, setStdetallefactura] = useState<Detalle[]>(new Array<Detalle>());

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
        []
    )

    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        event.preventDefault();
        const name = event.target.name;
        const value = event.target.value;
      
        let detalle: Detalle = {
            idplato: Number(name),
            cantidad: Number(value)
        }
        if (Number(value)===0) {
            let detallefactura: Detalle[] = stdetallefactura.filter(detalle => detalle.idplato !== Number(name));
            setStdetallefactura(detallefactura);
        } else {
            if (stdetallefactura.find(detalle => detalle.idplato === Number(name))) {
                let detallefactura: Detalle[] = stdetallefactura.map(detalle => {
                    if (detalle.idplato === Number(name)) {
                        detalle.cantidad = Number(value);
                    }
                    return detalle;
                })
                setStdetallefactura(detallefactura);
            } else {
                setStdetallefactura([...stdetallefactura, detalle]);
            }
        }

       
            

       
    }

    const agregarDetallesFacturaApi = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        let token: string = localStorage.getItem("token") as string;
        const headers = {
            headers: { Authorization: token }
        };
        let ruta = process.env.REACT_APP_API_URL + "/v2/servicios/"+id+"/platos";
        const axiospost = async (rutaDetalleFactura: string) => {
            /** 
            try {
                const { data } = await axios.post(rutaDetalleFactura, stdetallefactura, headers);
                console.log(data);
               navigate("/servicios/"+id);

            } catch (error) {
                console.log(error);

            }
            */
            await axios.post(rutaDetalleFactura, stdetallefactura, headers).then(
                (response) => {
                    toast.success("Se agrego correctamente");
                    navigate("/servicios/"+id);
                }
            ).catch(
                (error) => {
                    toast.error(error.data.message);
                }
            )

        }
        axiospost(ruta);




    }

    return (
        <>
            <section className="food_section layout_padding">
                <div className="container">
                    <div className="heading_container heading_center">
                        <h2>
                            Añadir Platos
                        </h2>
                    </div>
                    <form onSubmit={agregarDetallesFacturaApi} >
                    <div className="filters-content">
                        <div className="row grid">
                           
                            {

                                stplatos.filter(plato => plato.disponible).map(
                                    (plato: Plato) => {
                                        return (
                                            <div className="col-sm-6 col-lg-3  mb-3 " key={plato.idplato}>
                                                <div className="box" style={{ "height": "95%" }}>
                                                    <div>
                                                        <div className="img-box">
                                                            <img src="/imagenes/f1.png" alt="" />
                                                        </div>
                                                        <div className="detail-box"  >
                                                            <h5>
                                                                {plato.nombre}
                                                            </h5>
                                                            <input
                                                                id="cantidad" 
                                                                name={plato.idplato.toString()}
                                                                onChange={handleChange}
                                                                type="number"
                                                                className='inputcantidad'
                                                                min="0" max="10" defaultValue="0" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        )
                                    })
                            }
                           
                       
                     
                        </div>
                    </div>
                    <button  type="submit" className="botonF1">
                        <i className="fas fa-check"></i>
                        </button>
                    </form>
                 
                      
               
                          
                </div>
            </section>

        </>
    )

}