/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.practica7.vista;

import es.iespuertodelacruz.adrian.practica7.modelo.NumIdentidad;
import es.iespuertodelacruz.adrian.practica7.modelo.Persona;
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
        System.out.println("* 3) Salir             *");
        System.out.println("************************");
        System.out.print("-> ");
        int opcion = sc.nextInt();
        return opcion;
    }

    public String[] crearPersona() {

        System.out.println("Introduce el nombre de la persona");
        String nombre = sc.nextLine();
        sc.nextLine();
        System.out.println("Introduce la edad de la persona");
        int edad = sc.nextInt();
        System.out.println("Introduce la altura de la persona");
        int altura = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce el número de indentidad");
        String numIdenStr = sc.nextLine();
        NumIdentidad numIden = new NumIdentidad(numIdenStr);

        String[] datosPersona = {nombre, Integer.toString(edad), Integer.toString(altura), numIden.toString()};

        return datosPersona;
    }

    public void listarPersonas(ArrayList<Persona> listaPersonas) {

        listaPersonas.forEach((p) -> System.out.println(p));

    }
}
