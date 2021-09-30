/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicicoficheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class EjercicicoFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] listaPersonas;
        String line = null;
        Path path = Paths.get("/home/dama/personas.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while ((line = reader.readLine()) != null) {
                listaPersonas = line.split(";");
                Persona persona = new Persona(listaPersonas[0], listaPersonas[1], listaPersonas[2]);
                System.out.println(persona.toString());
            }

        } catch (IOException e) {
            System.err.println("ERROR: " + e);
        }
    }

}
