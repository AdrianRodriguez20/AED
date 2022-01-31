import React, { useState } from "react";
import PropTypes from 'prop-types'
const PracticarTabla  = (props) => {
    const [contador, incrementar] = useState(1);
   const multiplicar = () => {
       if (contador>9){
        incrementar(1)
       }else{
        incrementar(contador+1)
       }
        
    }
    return (
        <>
            <p>Tabla del {props.tabla}</p>
            <p>{props.tabla} x {contador} = {props.tabla * contador} </p>
            <button onClick={multiplicar}>
                {props.tabla} x {contador}
            </button>
        </>
    );

}
PracticarTabla .propTypes = {
    tabla: PropTypes.number.isRequired
}
export default PracticarTabla ;