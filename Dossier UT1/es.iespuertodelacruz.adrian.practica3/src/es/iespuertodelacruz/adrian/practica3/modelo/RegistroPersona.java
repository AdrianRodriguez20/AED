/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.practica3.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class RegistroPersona {

    Path path = Paths.get("personas.txt");

    public RegistroPersona() {
    }

    public RegistroPersona(String archivo) {
        path = Paths.get(archivo);
    }

    public void aniadirPersona(Persona p) throws IOException {

        boolean ok = true;
        Persona paux = getPersona(p.getDni());

        ok = paux == null;
        if (ok) {
            try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path.toFile(), true)));) {

                String registro
                        = p.getNombre() + ";"
                        + p.getApellido() + ";"
                        + p.getDni() + ";"
                        + p.getEdad() + ";"
                        + p.getAltura() + ";"
                        + p.getPeso() + ";";
                pw.println(registro);
            }
        }

    }

    public ArrayList<Persona> getAll() throws IOException {

        ArrayList<Persona> personas = new ArrayList();
        String line = null;

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while ((line = reader.readLine()) != null) {
                String[] listaPersonas = line.split(";");
                Persona persona = new Persona(listaPersonas[0], listaPersonas[1], listaPersonas[2], parseInt(listaPersonas[3]), parseInt(listaPersonas[4]), parseDouble(listaPersonas[5]));
                personas.add(persona);
            }

        }
        return personas;
    }

    public Persona getPersona(String dni) throws IOException {
        Persona personaEncontrada=null;
        String listaPersonas[] = null;
        ArrayList<Persona> personas = new ArrayList();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                listaPersonas = line.split(";");
                Persona persona = new Persona(listaPersonas[0], listaPersonas[1], listaPersonas[2], parseInt(listaPersonas[3]), parseInt(listaPersonas[4]), parseDouble(listaPersonas[5]));
                personas.add(persona);
            }
        }
        
        for (int i = 0; i < personas.size(); i++) {
            if (dni.equals(personas.get(i).getDni())) {
                personaEncontrada = personas.get(i);
            }
        }
        return personaEncontrada;
    }
}
