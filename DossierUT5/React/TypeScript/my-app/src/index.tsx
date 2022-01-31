import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

import MostrarInput from './MostrarInput';
import OperarBotones from './OperarBotones';
import App from './App';
import reportWebVitals from './reportWebVitals';

//ReactDOM.render(<OperarBotones/>,document.getElementById('root'));

//ReactDOM.render(<MostrarInput/>,document.getElementById('root'));

ReactDOM.render(<App/>,document.getElementById('root'));

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
