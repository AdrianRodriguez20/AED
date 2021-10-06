/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.practica7;

import es.iespuertodelacruz.adrian.practica7.controlador.PersonaController;
import es.iespuertodelacruz.adrian.practica7.modelo.Persona;
import es.iespuertodelacruz.adrian.practica7.vista.PersonaView;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class Main {

    public static void main(String[] args)   {

        PersonaView vista = new PersonaView();
        Persona modelo = new Persona();

        PersonaController pc = new PersonaController(vista, modelo);

        pc.iniciar();

    }
}
