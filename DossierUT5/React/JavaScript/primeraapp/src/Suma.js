import React from "react";
import PropTypes from 'prop-types'

const Suma = (props) => {
    const { num1, num2 } = props;
    const resultado = num1 + num2;
    return (
        <>
            <h1>Suma</h1>
            <h3>{num1} + {num2} = {resultado}</h3>
        </>
    );

}
Suma.propTypes = {
    num1: PropTypes.number.isRequired,
    num2: PropTypes.number.isRequired
}


export default Suma;