/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.practica7.controlador;

import es.iespuertodelacruz.adrian.practica7.modelo.GestorPersona;
import es.iespuertodelacruz.adrian.practica7.modelo.NumIdentidad;
import es.iespuertodelacruz.adrian.practica7.modelo.Persona;
import es.iespuertodelacruz.adrian.practica7.vista.PersonaView;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class PersonaController {

    private PersonaView vista;
    private Persona modelo;
    GestorPersona gp = new GestorPersona();
    Persona p1 = new Persona();

    public PersonaController() {
    }

    public PersonaController(PersonaView vista, Persona modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void iniciar() {
        while (true) {
            switch (vista.menuPrincipal()) {
                case 1:
                    crearPersona(vista.crearPersona());
                    break;
                case 2:

                    vista.listarPersonas(listarPersonas());
                    break;
                case 3:
                    System.exit(0);
                default:

            }
        }

    }

    public void crearPersona(String[] datosPersona) {

        try {
            p1.setAll(gp.getAll());
        } catch (IOException | ClassNotFoundException ex) {

        }

        NumIdentidad numIden = new NumIdentidad(datosPersona[3]);
        if (numIden.validarNumIdentidad()) {
            Persona p = new Persona(datosPersona[0], parseInt(datosPersona[1]),
                    parseInt(datosPersona[2]), numIden);
            p1.aniadirListaPersonas(p);
            gp.aniadirPersona(p1.getAll());
        }

    }

    public ArrayList<Persona> listarPersonas() {

        try {
            p1.setAll(gp.getAll());
        } catch (IOException | ClassNotFoundException ex) {

        }
        return p1.getAll();
    }

}
