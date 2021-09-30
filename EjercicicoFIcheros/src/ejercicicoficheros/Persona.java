/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicicoficheros;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class Persona {
    private String nombre;
    private String dni;
    private String apellido;

    public Persona() {
    }

    public Persona(String nombre, String dni, String apellido) {
        this.nombre = nombre;
        this.dni = dni;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", dni=" + dni + ", apellido=" + apellido + '}';
    }
    
    
}
