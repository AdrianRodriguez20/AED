import { Link, Route, BrowserRouter, Routes } from 'react-router-dom';
function Inicio() {

    return (

        <div className="container-fluid">

            <div className="row">
                <div className="col-md-2">
                </div>
                <div className="col-md-4">
                    <div className="col text-center">
                        <img src="https://i.ibb.co/bmfKQ73/Learning-bro.png" width="75%" height="75%"/><br></br>
                        <Link to="/alumnos">
                        <button type="button" className="btn " style={{color:"white", background:"#6610F2"}} >Alumnos</button>
                        </Link>
                    </div>
                </div>
                <div className="col-md-4">
                    <div className="col text-center">
                    <Link to="/asignaturas">
                        <img src="https://i.ibb.co/KNdKRTk/Mathematics-bro.png" width="75%" height="75%"/><br></br>
                        <button type="button" className="btn "style={{color:"white", background:"#6610F2"}}>Asignaturas</button>
                        </Link>
                    </div>
                </div>
                <div className="col-md-2">

                </div>
            </div>
        </div>


    );

}
export default Inicio;
