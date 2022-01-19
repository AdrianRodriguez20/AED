const { escribir } = require("./utils/manejarTabla");
const { crearTabla } = require("./modelo/tabla");

const yargs = require('yargs/yargs')
const { hideBin } = require('yargs/helpers')
const argv = yargs(hideBin(process.argv)).argv
let numero = argv.tabla;
if (argv.tabla != undefined) {

    if (!isNaN(numero)) {

        escribir("tabla.txt", crearTabla(numero))
            .then(respuesta => console.log(respuesta))
            .catch(error => console.log(error))

    } else {
        console.log("El valor introducido no es un número");

    }
} else {
    console.log("La forma de uso es: node app.js --tabla=numero");
}