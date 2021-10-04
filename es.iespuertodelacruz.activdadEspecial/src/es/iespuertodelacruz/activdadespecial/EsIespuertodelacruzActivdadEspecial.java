/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.activdadespecial;

import es.iespuertodelacruz.activdadespecial.controller.GestorFicheros;
import es.iespuertodelacruz.activdadespecial.model.Persona;
import java.io.IOException;

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

        String nombre = gf.rellenarDatos("Andresito", gf.nombreSize);
        String apellido = gf.rellenarDatos("Rodriguez", gf.apellidoSize);
        String edad = gf.rellenarDatos(19, gf.edadSize);
        
        Persona p = new Persona(nombre,apellido,edad);
    
        //gf.guardarDatosFichero(p);
        gf.leerFichero();
    }

}
