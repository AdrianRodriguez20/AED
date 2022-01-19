const fs = require('fs');

function escribir(nombreDelFichero, textoEscribir) {
    return new Promise((resolve, reject) => {
        fs.writeFile(nombreDelFichero, textoEscribir, (error) => {
            if (error) {
                reject("No se pudo grabar el archivo");
            } else {
                resolve("Grabado Correctamente");
            }

        });

    });
}

exports.escribir = escribir;