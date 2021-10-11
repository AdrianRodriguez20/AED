/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.jc.monedasxml.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author carlos
 */
public class ManejoFichero {

    File file;

    public ManejoFichero(String nombre) {
        file = new File(nombre);
    }

    public boolean agregarTexto(String texto) throws IOException {
        boolean aniadido = false;
        try (BufferedWriter bw = Files.newBufferedWriter(this.file.toPath(), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            bw.write(texto);
            aniadido = true;
        } catch (IOException ex) {
            aniadido = false;
        }

        return aniadido;
    }

    public boolean borrarYAgregar(String texto) {
        boolean aniadido = false;
        try (BufferedWriter bw = Files.newBufferedWriter(this.file.toPath(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
            bw.write(texto);
            aniadido = true;
        } catch (IOException ex) {
            aniadido = false;
        }

        return aniadido;

    }

    public String leerTodo() {
        String line = "";
        String texto="";
        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {

            while ((line = reader.readLine()) != null) {
                texto += line + "\n";

            }
        } catch (IOException e) {
            System.err.println("ERROR: " + e);
        }
        return texto;
    }

}
