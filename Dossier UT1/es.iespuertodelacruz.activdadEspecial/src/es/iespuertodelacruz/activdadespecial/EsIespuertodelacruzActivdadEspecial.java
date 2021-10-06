/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.activdadespecial;

import es.iespuertodelacruz.activdadespecial.model.GestorFicheros;
import es.iespuertodelacruz.activdadespecial.model.ManejoPersona;
import es.iespuertodelacruz.activdadespecial.model.Persona;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class EsIespuertodelacruzActivdadEspecial {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        GestorFicheros gf = new GestorFicheros();
        ManejoPersona mp = new ManejoPersona();
        String nombre = mp.rellenarDatos("Juan", mp.nombreSize);
        String apellido = mp.rellenarDatos("Chubasco", mp.apellidoSize);
        String edad = mp.rellenarDatos("19", mp.edadSize);

        Persona p = new Persona(nombre, apellido, edad);

        //gf.guardarDatosFichero(p);
        ArrayList<Persona> personas = gf.leerFichero();
        for (Persona persona : personas) {
            System.out.println(persona);
        }

    }

}
