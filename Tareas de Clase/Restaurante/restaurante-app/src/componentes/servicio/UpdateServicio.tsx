import axios from 'axios';
import { useEffect, useState } from 'react';
import { Navigate, useParams } from 'react-router-dom';
import { Servicio } from '../../interfaces/Servicio';
import { Mesa } from '../../interfaces/Mesa';
import { useNavigate } from 'react-router-dom';

export default function UpdateServicio() {
    let navigate = useNavigate();
    const [stnummesas, setStnummesas] = useState<Mesa[]>(new Array<Mesa>());
    const [stservicio, setStservicio] = useState<Servicio>({} as Servicio);
    const [stcomensales, setStcomensales] = useState<number>(0);

    const { id } = useParams();

    useEffect(
        () => {
            const getMesas = async () => {
                let token: string = localStorage.getItem("token") as string;
                const headers = {
                    headers: { Authorization: token }
                };
                let rutaMesas = process.env.REACT_APP_API_URL + "/v2/mesas/";
                let { data } = await axios.get(rutaMesas, headers);
                setStnummesas(data)


            }
            getMesas();

            const getServicio = async (id: string | undefined) => {
                let rutaServicio = process.env.REACT_APP_API_URL + "/v2/servicios/" + id;
                let token: string = localStorage.getItem("token") as string;
                const headers = {
                    headers: { Authorization: token }
                };
                let { data } = await axios.get(rutaServicio, headers);
                setStservicio(data);
            }
            getServicio(id);
        }, []);

    const actualizarServicioApi = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        let formulario: HTMLFormElement = event.currentTarget;
        let inputfechacomienzo: HTMLInputElement = formulario.fechacomienzo;
        let inputnummesa: HTMLInputElement = formulario.nummesa;
        let inputreservada: HTMLInputElement = formulario.reservada;
        let selectpagada: HTMLSelectElement = formulario.pagada;


        let fechacomienzo = new Date(inputfechacomienzo.value).getTime();
        let nummesa = inputnummesa.value;
        let reservada = inputreservada.value;
        let fechafin = new Date(inputfechacomienzo.value).getTime() + 7200000;
        let pagada = selectpagada.value;

        let reserva = {
            fechacomienzo: fechacomienzo,
            fechafin: fechafin,
            nummesa: nummesa,
            reservada: reservada,
            pagada: pagada
        }

        let ruta = process.env.REACT_APP_API_URL + "/v2/servicios/" + id;

        const axiosput = async (rutaServicio: string) => {
            let token: string = localStorage.getItem("token") as string;
            const headers = {
                headers: { Authorization: token }
            };
            try {
                const { data } = await axios.put(rutaServicio, reserva, headers);
                console.log(data);
                navigate("/servicios/"+id);

            } catch (error) {
                console.log(error);

            }

        }

        axiosput(ruta);
    }





    const getDisponibilidad = async (fecha: number, comensales: number) => {
        let token: string = localStorage.getItem("token") as string;
        const headers = {
            headers: { Authorization: token }
        };


        let rutaServicio = process.env.REACT_APP_API_URL + "/v2/mesas?disponible=true&fecha=" + fecha + "&comensales=" + comensales;
        let { data } = await axios.get(rutaServicio, headers);
        console.log(data);
        let mesas = data; 
        setStnummesas(data);

    }
    const onclick = (event: React.MouseEvent<HTMLElement>) => {
        event.preventDefault();
        getDisponibilidad(stservicio.fechacomienzo, stcomensales);

    }

    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        event.preventDefault();
        const name = event.target.id;
        const value = event.target.value;

        if (name === "ocupantesmax") {
            setStcomensales(parseInt(value));
        } else if (name === "reservada") {
            setStservicio({
                ...stservicio,
                [name]: value
            });
        }
    }
    const updateDate = (event: React.ChangeEvent<HTMLInputElement>) => {
        event.preventDefault();
        let fecha = new Date(event.target.value);
        let fechaFormateada = fecha.getTime();

        setStservicio({
            ...stservicio,
            fechacomienzo: fechaFormateada
        });

    }
    const handleChangeSelect = (event: React.ChangeEvent<HTMLSelectElement>) => {
        event.preventDefault();
        const name = event.target.id;
        const value = event.target.value;

        setStservicio({
            ...stservicio,
            [name]: value
        });

    }
    return (
        <>

            <section className="book_section layout_padding">
                <div className="container">
                    <div className="heading_container heading_center">
                        <h2>
                         Actualizar Reservar
                        </h2>
                    </div>
                    <div className="row">
                        <div className="offset-md-3 col-md-6">
                            <div className="form_container">
                                <form onSubmit={actualizarServicioApi}>
                                    <div>
                                        <input
                                            type="text"
                                            className="form-control"
                                            placeholder="Concepto"
                                            id="reservada"
                                            onChange={handleChange}
                                            value={stservicio.reservada}
                                        />
                                    </div>
                                    <div>
                                        <select
                                            className="form-control  form-select-lg nice-select wide"
                                            id="nummesa"
                                            onClick={onclick}>
                                            <option disabled value="0">Seleccione una mesa</option>
                                            {stnummesas.map((mesa: any) => (
                                                <option value={mesa.nummesa}>{mesa.nummesa} ({mesa.ocupantesmax}) </option>
                                            ))}


                                        </select>
                                    </div>
                                    <div>
                                        <div>
                                            <input
                                                type="number"
                                                className="form-control"
                                                placeholder="comensales"
                                                id="ocupantesmax"

                                                onChange={handleChange} />
                                        </div>
                                    </div>
                                    <div>
                                        <input
                                            type="datetime-local"
                                            className="form-control"
                                            id="fechacomienzo"
                                            placeholder="yyyy-mm-dd"
                                            value={new Date(parseInt(JSON.stringify(stservicio.fechacomienzo)) || 0)?.toISOString().substring(0, 16)}
                                            onChange={updateDate} />
                                    </div>
                                    <select
                                        className="form-control
                                        nice-select wide"
                                        id="pagada"
                                        onChange={handleChangeSelect}
                                    >
                                        <option value="" disabled >
                                            Estado
                                        </option>
                                        <option
                                            value="true"
                                            selected={stservicio.pagada === true}
                                        >
                                            Pagado
                                        </option>
                                        <option
                                            value="false"
                                            selected={stservicio.pagada === false}
                                        >

                                            Sin pagar
                                        </option>
                                    </select>
                                    <div className="btn_box text-center">
                                        <button >
                                            Actualizar
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
            </section>


        </>
    )

}
