/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.practica3;

import es.iespuertodelacruz.adrian.practica3.modelo.RegistroPersona;
import es.iespuertodelacruz.adrian.practica3.modelo.Persona;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class EsIespuertodelacruzAdrianPractica3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        RegistroPersona registroPersona = new RegistroPersona();
        Persona persona = new Persona("Adrian", "Rodriguez", "43494877J", 20, 174, 80);
        Persona persona2 = new Persona("Sara", "Martin", "43494877X", 12, 170, 60);
        
        registroPersona.aniadirPersona(persona);
        registroPersona.aniadirPersona(persona2);
        ArrayList listaPersona = registroPersona.getAll();

        for (int i = 0; i < listaPersona.size(); i++) {

            System.out.println(listaPersona.get(i).toString());
        }
        
     
        System.out.println(registroPersona.getPersona("43494877J"));
    }

}
