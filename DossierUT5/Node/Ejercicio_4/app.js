const { Console } = require('console');
const fs = require('fs');
const { boolean } = require('yargs');

function getTabla(tabla) {
    let limite = 10;
    let respuesta =
        `---------------------------
 TABLA DEL ${tabla}
---------------------------
`;
    for (let i = 1; i <= limite; i++) {
        respuesta += `${tabla} * ${i} = ${tabla * i} \n`;

    }
    return respuesta;
}



const grabarFichero = (nombre , datos ) =>{

    fs.writeFile(
        nombre, //nombre del fichero
         datos, //información a guardar
        (err) => { //callback respuesta al finalizar
            if (err)
                console.log("No se pudo grabar el archivo");
            else
                console.log("se ha grabado");
        }
    );
    
}

grabarFichero("tabla.txt", getTabla(5));

// ------------------------------------------------------------------//
//                          NÚMEROS PRIMOS
// ------------------------------------------------------------------//

const getPrimos = () => {
    let array =[];
  
    for (let i = 0; i <= 200; i++) {
        if (esPrimo(i)) {
            array[i]=i;
          
        };
    }
    return array;
}

const esPrimo = (numero) =>
{
    let esPrimoActual = true;
    if (numero < 2) {
        esPrimoActual = false;
    } else {
        for (let x = 2; x * x <= numero; x++) {
            if (numero % x == 0) {
                esPrimoActual = false;
                break;
            }
        }
    }
    return esPrimoActual;

}
grabarFichero("primos.txt", getPrimos().join(' ').replace(/\s+/g, ' '))


