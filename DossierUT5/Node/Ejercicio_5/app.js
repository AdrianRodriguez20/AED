const { escribir } = require("./utils/manejarTabla");
const { crearTabla } = require("./modelo/tabla");
escribir("tabla.txt", crearTabla(7))
    .then(respuesta => console.log(respuesta))
    .catch(error => console.log(error))