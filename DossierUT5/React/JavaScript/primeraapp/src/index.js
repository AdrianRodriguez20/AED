import React from 'react';
import ReactDOM from 'react-dom';
import Contador from './Contador';
import MisDatos from './MisDatos';
import Practica5 from './Practica5';
import Suma from './Suma';
import TodasLasTablas from './TodasLasTablas';
import PracticarTabla from './PracticarTabla';

const mensaje = <h1>Vamos a renderizar este mensaje en nuestra web</h1>;

const divRoot = document.getElementById("root");

//ReactDOM.render( mensaje, divRoot);

//ReactDOM.render(<MisDatos/>, document.getElementById('root'));

//ReactDOM.render(<Suma num1={2} num2={4}/>, document.getElementById('root'));

//ReactDOM.render(<Practica5/>, document.getElementById('root'));

//ReactDOM.render(<Contador/>, document.getElementById('root'));

//ReactDOM.render(<PracticarTabla tabla={3} />, document.getElementById('root'));

ReactDOM.render(<TodasLasTablas />, document.getElementById('root'));



// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals

