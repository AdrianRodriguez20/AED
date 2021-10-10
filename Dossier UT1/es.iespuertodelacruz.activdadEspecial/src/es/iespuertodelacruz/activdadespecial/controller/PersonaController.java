/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.activdadespecial.controller;

import es.iespuertodelacruz.activdadespecial.model.GestorFicheros;
import es.iespuertodelacruz.activdadespecial.model.Persona;
import es.iespuertodelacruz.activdadespecial.model.RegistroPersona;
import es.iespuertodelacruz.activdadespecial.view.PersonaView;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class PersonaController {

    private PersonaView vista;
    private Persona modelo;

    GestorFicheros gf = new GestorFicheros();
    Persona p1 = new Persona();

    public PersonaController() {
    }

    public PersonaController(PersonaView vista, Persona modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void iniciar() throws IOException {
        while (true) {
            switch (vista.menuPrincipal()) {
                case 1:
                    crearPersona(vista.crearPersona());
                    break;
                case 2:
                    vista.listarPersonas(listarPersonas());
                    break;
                case 3:

                    vista.mostrarPersona(obtenerPersona(vista.buscarPersona()));
                    break;
                case 4:
                      sustituirPersona(vista.sustiturPersona());
                    break;
                case 5:
                    System.exit(0);
                    break;

                default:

            }
        }

    }

    public void crearPersona(String[] datosPersona) throws IOException {
        Persona p = new Persona(datosPersona[0], datosPersona[1], datosPersona[2]);
        RegistroPersona rp = new RegistroPersona(p.getNombre(), p.getApellido(), p.getEdad());
        gf.aniadirPersona(rp);
    }

    public ArrayList<Persona> listarPersonas() throws IOException {
        return gf.getAll();
    }

    public Persona obtenerPersona(long pos) throws IOException {
        return gf.obtenerPersona(pos);
    }

    public void sustituirPersona(String[] datosPersona) throws IOException {
        Persona p = new Persona(datosPersona[0], datosPersona[1], datosPersona[2]);
        RegistroPersona rp = new RegistroPersona(p.getNombre(), p.getApellido(), p.getEdad());
        gf.sustituirPersona(Long.parseLong(datosPersona[3]), rp);
    }

}
