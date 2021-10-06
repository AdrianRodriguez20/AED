/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.practica7.modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class Persona implements Serializable {

    private String nombre;
    private int edad;
    private int altura;
    private NumIdentidad dni;
    static ArrayList<Persona> listaPersonas = new ArrayList();

    public Persona() {
    }

    public Persona(String nombre, int edad, int altura, NumIdentidad dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getAltura() {
        return altura;
    }

    public NumIdentidad getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setDni(NumIdentidad dni) {
        this.dni = dni;
    }

    public void setAll(ArrayList<Persona> persona) {
        listaPersonas = persona;
    }

    public ArrayList<Persona> getAll() {
        return listaPersonas;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", altura=" + altura + ", dni=" + dni.toString() + '}';
    }

}
