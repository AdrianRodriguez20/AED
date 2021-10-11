/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.propietariosxml.entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
@XmlRootElement(name = "propietario")
public class Propietario implements Serializable {

    String nombre;
    String apellido;
    Casa casa;

    public Propietario() {
    }

    public Propietario(String nombre, String apellido, Casa casa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.casa = casa;
    }

  
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Casa getCasa() {
        return casa;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

      @XmlTransient
    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    @Override
    public String toString() {
        return nombre +" " + apellido+ " ";
    }
    
    

}
