/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.activdadespecial.model;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class GestorFicheros {

    final int SIZECHAR = 2;

    Path path = Paths.get("prueba.txt");

    public GestorFicheros() {
    }

    public GestorFicheros(String archivo) {
        path = Paths.get(archivo);
    }

    public void guardarDatosFichero(Persona p) {
        RandomAccessFile rafFichero = null;

        try {
            rafFichero = new RandomAccessFile(path.toString(), "rwd");

            if (rafFichero.length() > 1) {
                rafFichero.seek(rafFichero.length());
            }

            rafFichero.writeUTF(p.getNombre() + p.getApellido() + p.getEdad());

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

    public ArrayList<Persona> leerFichero() {

        String line = "";
        ArrayList<Persona> personas = new ArrayList();
        RandomAccessFile rafFichero = null;
        boolean finArchivo = false;
        try {
            rafFichero = new RandomAccessFile("‪ficheroPersonas.txt", "rwd");

            while (!finArchivo) {
                line = rafFichero.readUTF();
                System.out.println(line);
                //cambiar
                String[] listaPersonas = line.split("\0");
                Persona persona = new Persona(listaPersonas[0].replace(" ", ""),
                        listaPersonas[1].replace(" ", ""),
                        listaPersonas[2].replace(" ", ""));

                personas.add(persona);

            }

        } catch (EOFException e) {
            finArchivo = true;
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
        return personas;
    }

    private String readString(RandomAccessFile raf, long comienzo, int cantidad) throws IOException {
        raf.seek(comienzo);
        char campo[] = new char[cantidad];
        for (int i = 0; i < cantidad; i++) {

            campo[i] = raf.readChar();
        }
        return new String(campo);
    }

    private boolean guardarRegistro(long pos) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rwd");
        boolean guardadoOK = false;
        if (raf.length() >= pos) {
            raf.seek(pos);
            raf.writeChars(rp.nombre);
            raf.writeChars(rp.apellido);
            raf.writeChars(rp.edad);
            raf.close();
            guardadoOK = true;
        }
        return guardadoOK;
    }

}
