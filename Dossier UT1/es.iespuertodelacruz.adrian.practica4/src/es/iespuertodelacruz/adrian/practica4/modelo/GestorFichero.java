/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.practica4.modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class GestorFichero {

    Path path = Paths.get("primos.txt");
    Primos primos;

    public GestorFichero() {
    }

    public GestorFichero(Primos primos) {
        this.primos = primos;
    }

    public void aniadirPrimosAll() throws IOException {

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (int i = 0; i < primos.listaPrimos.size(); i++) {
                bw.write(Integer.toString(primos.listaPrimos.get(i)));
                bw.newLine();

            }
            bw.close();
        }
    }

    public void aniadirPrimosDeUnoEnUno() throws IOException {

        for (int i = 0; i < primos.listaPrimos.size(); i++) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.toString(), true))) {
                bw.write(Integer.toString(primos.listaPrimos.get(i)));
                bw.newLine();
                bw.close();
            }

        }
    }

}
