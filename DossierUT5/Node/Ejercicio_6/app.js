const { escribir } = require("./utils/manejarTabla");
const { crearTabla } = require("./modelo/tabla");
let numero = process.argv[2];
if (!isNaN(numero)) {

    escribir("tabla.txt", crearTabla(numero))
        .then(respuesta => console.log(respuesta))
        .catch(error => console.log(error))

} else {
    console.log("El valor introducido no es un número");
}