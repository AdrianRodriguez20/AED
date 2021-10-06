/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.practica7.modelo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class GestorPersona {

    Path path = Paths.get("personasSerializable.txt");

    public GestorPersona() {
    }

    public GestorPersona(String archivo) {
        path = Paths.get(archivo);
    }

    public void aniadirPersona(Persona persona) {

        try (
                FileOutputStream fos = new FileOutputStream(path.toString());
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos);) {

            oos.writeObject(persona);

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }

    public ArrayList<Persona> getAll() throws IOException, ClassNotFoundException {
        ArrayList<Persona> personas = new ArrayList<>();

        try (
                FileInputStream fis = new FileInputStream(path.toString());
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);) {
            boolean finDeFichero = false;
            Persona p;
            do {
                try {
                    p = (Persona) ois.readObject();

                    personas.add(p);

                } catch (EOFException ex) {
                    finDeFichero = true;
                }
            } while (!finDeFichero);
        } catch (FileNotFoundException ex) {
        }
        return personas;

    }

}
