/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.activdadespecial.model;

import static es.iespuertodelacruz.activdadespecial.model.RegistroPersona.apellidoSize;
import static es.iespuertodelacruz.activdadespecial.model.RegistroPersona.edadSize;
import static es.iespuertodelacruz.activdadespecial.model.RegistroPersona.nombreSize;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class GestorFicheros {

    final int SIZECHAR = 2;

    final int SIZEREGISTER = (nombreSize + apellidoSize + edadSize) * SIZECHAR;
    File file = new File("ficheroPersonas.txt");

    public GestorFicheros() {
    }

    public GestorFicheros(File file) {
        this.file = file;
    }

    /**
     * Método para mostrar todas las personas
     *
     * @return ArrayList de personas
     * @throws FileNotFoundException
     * @throws IOException
     *
     */

    public ArrayList<Persona> getAll() throws FileNotFoundException, IOException {
        RegistroPersona rp = new RegistroPersona();

        ArrayList<Persona> personas = new ArrayList();

        try (RandomAccessFile raf = new RandomAccessFile(file, "rwd")) {
            long size = raf.length() / SIZEREGISTER;
            for (int i = 0; i <= size - 1; i++) {
                personas.add(obtenerPersona(i));

            }
        }

        return personas;
    }

    /**
     * Método para leer String
     *
     * @param raf
     * @param comienzo
     * @param cantidad
     * @return el campo convertido en String
     * @throws IOException
     */
    private String readString(RandomAccessFile raf, long comienzo, int cantidad) throws IOException {
        raf.seek(comienzo);
        char campo[] = new char[cantidad];
        for (int i = 0; i < cantidad; i++) {

            campo[i] = raf.readChar();
        }
        return new String(campo);
    }

    /**
     * Método para obtener una persona mediante su posición
     *
     * @param posicion
     * @return persona
     * @throws IOException
     */
    public Persona obtenerPersona(long posicion) throws IOException {
        RegistroPersona p = new RegistroPersona();
        RandomAccessFile raf = new RandomAccessFile(file, "rwd");

        p.nombre = readString(raf, posicion * SIZEREGISTER, RegistroPersona.nombreSize);
        p.apellido = readString(raf, posicion * SIZEREGISTER + SIZECHAR * RegistroPersona.nombreSize, RegistroPersona.apellidoSize);
        p.edad = readString(raf, posicion * SIZEREGISTER + SIZECHAR * RegistroPersona.nombreSize + SIZECHAR * RegistroPersona.apellidoSize, p.edadSize);

        return p.toPersona(p);

    }

    /**
     * Método para guardar un registro en el fichero
     *
     * @param pos
     * @param rp
     * @return Boolean que verifica si se ha guardado
     * @throws IOException
     */
    public boolean guardarRegistro(long pos, RegistroPersona rp) throws IOException {

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

    /**
     * Método para agregar una persona al fichero
     *
     * @param rp
     * @throws IOException
     */
    public void aniadirPersona(RegistroPersona rp) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file, "rwd")) {
            guardarRegistro(raf.length(), rp);
        };

    }

    /**
     * Método para sustituir una persona al fichero
     *
     * @param rp
     * @throws IOException
     */
    public void sustituirPersona(long pos, RegistroPersona rp) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file, "rwd")) {
            guardarRegistro(pos * SIZEREGISTER, rp);
        }

    }
}
