/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.activdadespecial.view;

import es.iespuertodelacruz.activdadespecial.model.Persona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class PersonaView {

    Scanner sc = new Scanner(System.in);

    public PersonaView() {
    }

    public int menuPrincipal() {
        System.out.println("Menú Principal");
        System.out.println("************************");
        System.out.println("* 1) Registrar Persona *");
        System.out.println("* 2) Listar Personas   *");
        System.out.println("* 3) Buscar Persona    *");
        System.out.println("* 4) Sustituir Persona  *");
        System.out.println("* 5) Salir             *");
        System.out.println("************************");
        System.out.print("-> ");
        int opcion = sc.nextInt();sc.nextLine();
        return opcion;
    }

    public String[] crearPersona() {

        System.out.println("Introduce el nombre de la persona");
        String nombre = sc.nextLine();
        System.out.println("Introduce el apellido de la persona");
        String apellido = sc.nextLine();
        System.out.println("Introduce la edad de la persona");
        String edad = sc.nextLine();

        String[] datosPersona = {nombre, apellido, edad};

        return datosPersona;
    }

    public void listarPersonas(ArrayList<Persona> personas) {

        personas.forEach((p) -> System.out.println(p));

    }

    public Long buscarPersona() {
        System.out.println("Introduce la posición de la persona");
        Long pos = sc.nextLong();
        return pos;
    }

    public void mostrarPersona(Persona p) throws IOException {

        System.out.println(p.toString());
    }

    public String[] sustiturPersona() {

        System.out.println("Introduce la posición de la persona");
        Long pos = sc.nextLong();sc.nextLine();;
        System.out.println("Introduce el nombre de la persona");
        String nombre = sc.nextLine();
        System.out.println("Introduce el apellido de la persona");
        String apellido = sc.nextLine();
        System.out.println("Introduce la edad de la persona");
        String edad = sc.nextLine();
        System.out.println(pos);
        String[] datosPersona = {nombre, apellido, edad , pos.toString()};

        return  datosPersona;
    }

}
