/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.activdadespecial.controller;

import es.iespuertodelacruz.activdadespecial.model.Persona;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class GestorFicheros {

    public final int nombreSize;
    public final int apellidoSize;
    public final int edadSize;
 

    public GestorFicheros() {
        this.apellidoSize = 50;
        this.edadSize = 3;
        this.nombreSize = 50;

    }

    public <T> String rellenarDatos(T atributo, int size) {

        return 'Ø' + String.format("%-" + size + "s", atributo);
    }

    public void guardarDatosFichero(Persona p) {
        RandomAccessFile rafFichero = null;

        try {
            rafFichero = new RandomAccessFile("‪prueba.txt", "rwd");

            if (rafFichero.length() > 1) {
                rafFichero.seek(rafFichero.length());
            }

            rafFichero.writeUTF(p.toString());

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } finally {
            try {
                if (rafFichero != null) {
                    rafFichero.close();
                }
            } catch (IOException ex) {
            }
        }

    }

    public void leerFichero() {

        String[] listaPersonas;
        String line = "";
        RandomAccessFile rafFichero = null;

        try {
            rafFichero = new RandomAccessFile("‪prueba.txt", "rwd");

            while ((line = rafFichero.readUTF()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("ERROR: " + e);
        } finally {
            try {
                if (rafFichero != null) {
                    rafFichero.close();
                }
            } catch (IOException ex) {
            }
        }
    }

}
