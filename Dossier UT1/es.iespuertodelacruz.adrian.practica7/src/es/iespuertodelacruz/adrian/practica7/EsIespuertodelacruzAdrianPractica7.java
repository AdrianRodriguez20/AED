/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.practica7;

import es.iespuertodelacruz.adrian.practica7.modelo.GestorPersona;
import es.iespuertodelacruz.adrian.practica7.modelo.NumIdentidad;
import es.iespuertodelacruz.adrian.practica7.modelo.Persona;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class EsIespuertodelacruzAdrianPractica7 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        GestorPersona gp = new GestorPersona();

        Persona p1 = new Persona();
        try {
            p1.setAll(gp.getAll());
        } catch (IOException | ClassNotFoundException ex) {

        }

        for (Persona p : p1.getAll()) {
            System.out.println(p);
        }

        NumIdentidad numIden = new NumIdentidad("43353860x");
        if (numIden.validarNumIdentidad()) {
            Persona p = new Persona("Adrian", 20, 178, numIden);

            gp.aniadirPersona(p);
        }

        ArrayList listaPersona = gp.getAll();
        for (int i = 0; i < listaPersona.size(); i++) {
             System.out.println("Hola");
            System.out.println(listaPersona.get(i).toString());
           
        }

    }

}
