import '../style/style.css';
import '../style/operario/Login.css';
import axios from 'axios';
import React from 'react'
import { useState } from 'react';
import { useEffect } from 'react';
import { Link, Route, BrowserRouter, Routes } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import {  toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

export default function Navbar() {
    let navigate = useNavigate();
    const [login, setLogin] = useState(false);


    useEffect(() => {
        let token: string = localStorage.getItem("token") as string;
        if (token) {
            setLogin(true);
        } else {
            setLogin(false);
        }
    }, [])

    const logout = () => {
        localStorage.removeItem("token");
        setLogin(false);
        navigate("/");
    }
    function handleform(event: React.FormEvent<HTMLFormElement>) {
        event.preventDefault();
        let formulario = event.currentTarget as HTMLFormElement;
        let inputName: HTMLInputElement = formulario.nombre;
        let inputPassword: HTMLInputElement = formulario.password;
        let name: string = inputName.value;
        let password: string = inputPassword.value;
        let login = {
            name: name,
            password: password
        }
        const axiospost = async (rutaLogin: string) => {

            await axios.post(rutaLogin, login).then (
                (response) => {
      
                    localStorage.clear();
                    localStorage.setItem("token",response.data);
                    setLogin(true);
                    navigate("/main");
                    document.getElementById("myModal")!.style.display = "none";
                    document.getElementById("myModal")!.classList.toggle("show");
                    document.getElementsByTagName("body")![0].classList.toggle("modal-open");
                    document.getElementsByClassName("modal-backdrop")![0].classList.toggle("show");
                    document.getElementsByClassName("modal-backdrop")![0].classList.toggle("show");
                    document.getElementsByClassName("modal-backdrop")![0].remove();
                    toast.success("Se logueo correctamente");
                }
            ).catch(
                (error) => {
                    if (name.trim() === "" || password.trim() === "") {
                        toast.error("No puede dejar campos vacios");
                    }else{
                        toast.error("Usuario o contraseña incorrectos");
                    }
                }
            )

        }

        axiospost(process.env.REACT_APP_API_URL + "/login")
    }

    return (
        <>
            <div className="sub_page">
                <div className="hero_area">
                    <div className="bg-box">
                        <img src="../imagenes/navbar.jpg" alt="" />
                    </div>
                    <header className="header_section">
                        <div className="container">
                            <nav className="navbar navbar-expand-lg custom_nav-container ">
                                <a className="navbar-brand" >
                                    <Link to={`/`} >
                                        <span>
                                            La Chubascada
                                        </span>
                                    </Link>
                                </a>

                                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                    <span className=""> </span>
                                </button>

                                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                                    <ul className="navbar-nav  mx-auto ">
                                        <li className="nav-item active">
                                            <Link to={`/`} >
                                                <a className="nav-link">Inicio<span className="sr-only">(current)</span> </a>
                                            </Link>
                                        </li>

                                        {login ?
                                            <>
                                                <li className="nav-item">
                                                    <Link to={`/platos`} >
                                                        <a className="nav-link" >Platos</a>
                                                    </Link>
                                                </li>
                                                <li className="nav-item">
                                                    <Link to={`/mesas`} >
                                                        <a className="nav-link">Mesas</a>
                                                    </Link>
                                                </li>
                                                <li className="nav-item">
                                                    <Link to={`/servicios`} >
                                                        <a className="nav-link">Servicios</a>
                                                    </Link>
                                                </li>
                                            </>
                                            :
                                            <>
                                                <li className="nav-item ">
                                                    <Link to={`/menu`} >
                                                        <a className="nav-link" >Menu  </a>
                                                    </Link>
                                                </li>
                                                <li className="nav-item">
                                                    <Link to={`/sobrenosotros`} >
                                                        <a className="nav-link" >Sobre Nosotros</a>
                                                    </Link>
                                                </li>
                                            </>

                                        }
                                    </ul>
                                    <div className="user_option">
                                        {login ?
                                            <>

                                                <i className="fas fa-sign-out-alt" aria-hidden="true" style={{ "color": "white", "fontSize": "1.5em" }} onClick={logout}></i>

                                            </>
                                            :
                                            <>
                                                <a href="#myModal" data-toggle="modal" className="user_link">
                                                    <i className="fa fa-user" aria-hidden="true"></i>
                                                </a>
                                            </>
                                        }

                                        <a href="" className="order_online ml-4" >
                                            <i className='fa fa-phone'>    Reservar </i>
                                        </a>
                                    </div>
                                </div>
                            </nav>
                        </div>
                    </header>
                </div>
            </div>

            <div id="myModal" className="modal fade">
                <div className="modal-dialog modal-login">
                    <div className="modal-content">
                        <div className="modal-header">
                            <div className="avatar">
                                <img src="../imagenes/login.png" alt="Avatar" />
                            </div>
                            <h4 className="modal-title">Iniciar Sesión</h4>
                            <button type="button" className="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div className="modal-body">
                            <form onSubmit={handleform}>
                                <div className="form-group">
                                    <input type="text" className="form-control" name="nombre" placeholder="Usuario" />
                                </div>
                                <div className="form-group">
                                    <input type="password" className="form-control" name="password" placeholder="Contraseña" />
                                </div>
                                <div className="form-group">

                                    <button type="submit" className="btn btn-primary btn-lg btn-block login-btn">Login</button>
                                </div>
                            </form>
                        </div>
                        <div className="modal-footer">
                            <a href="/registro">Registrarme</a>
                        </div>
                    </div>
                </div>
            </div>

        </>
    )
}
