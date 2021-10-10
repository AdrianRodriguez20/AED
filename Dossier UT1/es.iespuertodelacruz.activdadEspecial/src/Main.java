
import es.iespuertodelacruz.activdadespecial.controller.PersonaController;
import es.iespuertodelacruz.activdadespecial.model.Persona;
import es.iespuertodelacruz.activdadespecial.view.PersonaView;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class Main {

    public static void main(String[] args) throws IOException {

        PersonaView vista = new PersonaView();
        Persona modelo = new Persona();

        PersonaController pc = new PersonaController(vista, modelo);

        pc.iniciar();

    }
}
