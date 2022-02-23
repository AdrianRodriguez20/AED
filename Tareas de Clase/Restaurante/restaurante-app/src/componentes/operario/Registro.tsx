import '../../style/operario/Login.css';
import '../../style/operario/Registro.css';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import {  toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import axios from 'axios';

export default function Registro() {
    let navigate = useNavigate();
    const registroApi = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        let formulario = event.currentTarget as HTMLFormElement;
        let inputName: HTMLInputElement = formulario.nombre;
        let inputPassword: HTMLInputElement = formulario.password;

        let name: string = inputName.value;
        let password: string = inputPassword.value;
        let registro = {
            name: name,
            password: password
        }
        let ruta = process.env.REACT_APP_API_URL + "/registro";
        const axiospost = async (rutaRegistro: string) => {
            await axios.post(rutaRegistro, registro).then(
                (response) => {
                    navigate("/");
                    toast.success("Se registro correctamente");
                }
            ).catch(
                (error) => {
                     
                    toast.error(error.response.data.message);
                }
            )
        }
        axiospost(ruta);
    }

    return (
        <>
            <section className="food_section layout_padding">
                <div className="container">
                    <div className="row justify-content-center">
                        <div className="modal-login">
                            <div className="modal-content">
                                <div className="modal-header">
                                    <div className="avatar">
                                        <img src="../imagenes/login.png" alt="Avatar" />
                                    </div>
                                    <h4 className="modal-title">Registrarme</h4>

                                </div>
                                <div className="modal-body">
                                    <form onSubmit={registroApi}>
                                        <div className="form-group">
                                            <input type="text" className="form-control" name="nombre" placeholder="Usuario" />
                                        </div>
                                        <div className="form-group">
                                            <input type="password" className="form-control" name="password" placeholder="Contraseña" />
                                        </div>
                                        <div className="form-group">
                                            <button type="submit" className="btn btn-primary btn-lg btn-block login-btn">Registrarme</button>
                                        </div>
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </>
    )
}