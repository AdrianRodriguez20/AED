import '../style/Navbar.css';
import { Link, Route, BrowserRouter, Routes } from 'react-router-dom';
export default function Navbar() {

    return (
        <>

            <div className="l-navbar" id="nav-bar">
                <nav className="nav">
                    <div> 
                       
                        <div className="nav_list">
                            <Link to="/" className="nav_link ">
                                <i className='bx bx-grid-alt nav_icon'></i>

                            </Link>
                            <Link to="/alumnos" className="nav_link ">
                                <i className='bx bx-user nav_icon'></i>
                            </Link>
                            <Link to="/matriculas" className="nav_link ">
                                <i className='bx bx-message-square-detail nav_icon'></i>
                            </Link>
                            <Link to="/asignaturas" className="nav_link ">
                                <i className='bx bx-book nav_icon'></i>
                            </Link>

                        </div>
                    </div>
                </nav>

            </div>
        </>
    );

}