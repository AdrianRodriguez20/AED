import React from "react";

function MisDatos() {
    
    const datos ={
        nombre: "adrian",
        apellidos: "rodriguez",
        edad: 20
      };
    return (
    <>
    <h1>Mis datos</h1>
    <h4>{JSON.stringify(datos)}</h4>
    </>
    );
    
}


export default MisDatos;