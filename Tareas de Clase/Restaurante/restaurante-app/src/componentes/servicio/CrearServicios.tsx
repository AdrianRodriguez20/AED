import axios from 'axios';
import { useEffect, useState } from 'react';

export default function CrearServicio() {

    const [stfechacomienzo, setStfechacomienzo] = useState<Date>(new Date());
    const [stcomensales, setStcomensales] = useState<number>(1);
    const [stnummesas, setStnummesas] = useState<number[]>([]);

    const agregarServicioApi = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
		let formulario: HTMLFormElement = event.currentTarget;
        let inputfechacomienzo: HTMLInputElement = formulario.fechacomienzo;
        let inputnummesa: HTMLInputElement = formulario.nummesa;
        let inputreservada: HTMLInputElement = formulario.reservada;


        let fechacomienzo = new Date(inputfechacomienzo.value).getTime();
        let nummesa = inputnummesa.value;
        let reservada = inputreservada.value;
        let fechafin = new Date(inputfechacomienzo.value).getTime() +7200000;

        let reserva = {
            fechacomienzo: fechacomienzo,
            fechafin: fechafin,
            nummesa: nummesa,
            reservada: reservada
        }

		let ruta = process.env.REACT_APP_API_URL + "/v2/servicios";

		const axiospost = async (rutaServicio: string) => {
            let token: string = localStorage.getItem("token") as string;
            const headers = {
                headers: { Authorization: token }
            };
			try {
				const { data } = await axios.post(rutaServicio, reserva ,headers);
				console.log(data);

			} catch (error) {
				console.log(error);

			}

		}

		axiospost(ruta);
	}


    


    const getDisponibilidad = async (fecha: number, comensales: number) => {
        let token: string = localStorage.getItem("token") as string;
        const headers = {
            headers: { Authorization: token }
        };


        let rutaServicio = process.env.REACT_APP_API_URL + "/v2/mesas?disponible=true&fecha=" + fecha + "&comensales=" + comensales;
        let { data } = await axios.get(rutaServicio ,headers);
        console.log(data);
        let nummesas = data.map((mesa: any) => mesa.nummesa);
        setStnummesas(nummesas);
     
    }
    const onclick = (event: React.MouseEvent<HTMLElement>) => {
        event.preventDefault();
        getDisponibilidad(stfechacomienzo.getTime(), stcomensales);

    }

    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        event.preventDefault();
        const name = event.target.id;
        const value = event.target.value;

        if (name === "ocupantesmax") {
            setStcomensales(parseInt(value));
        }
    }
    const updateDate = (event: React.ChangeEvent<HTMLInputElement>) => {
        event.preventDefault();
        let fecha = new Date(event.target.value);
        setStfechacomienzo(fecha);

    }

    return (
        <>

            <section className="book_section layout_padding">
                <div className="container">
                    <div className="heading_container heading_center">
                        <h2>
                            Reservar
                        </h2>
                    </div>
                    <div className="row">
                        <div className="offset-md-3 col-md-6">
                            <div className="form_container">
                                <form onSubmit={agregarServicioApi}>
                                    <div>
                                        <input type="text" className="form-control" placeholder="Concepto" id="reservada" />
                                    </div>
                                    <div>
                                        <select 
                                        className="form-control  form-select-lg nice-select wide" 
                                        id="nummesa" 
                                        onClick={onclick}>
                                            <option disabled selected value="0">Seleccione una mesa</option>
                                            {stnummesas.map((nummesa: number) => {
                                                return <option  value={nummesa}>{nummesa}</option>
                                            })}
                                        </select>
                                    </div>
                                    <div>
                                        <div>
                                            <input
                                                type="number"
                                                className="form-control"
                                                placeholder="comensales"
                                                id="ocupantesmax"
                                                value={stcomensales}
                                                onChange={handleChange} />
                                        </div>
                                    </div>
                                    <div>
                                        <input
                                            type="datetime-local"
                                            className="form-control"
                                            id="fechacomienzo"
                                            placeholder="yyyy-mm-dd"
                                            value={stfechacomienzo.toISOString().substring(0, 16)}
                                            onChange={updateDate} />
                                    </div>

                                    <div className="btn_box text-center">
                                        <button >
                                            Reservar
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