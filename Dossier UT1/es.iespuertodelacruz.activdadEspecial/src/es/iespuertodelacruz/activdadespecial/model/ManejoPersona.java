/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.activdadespecial.model;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class ManejoPersona {

    public final int nombreSize;
    public final int apellidoSize;
    public final int edadSize;

    public ManejoPersona() {
        this.apellidoSize = 50;
        this.edadSize = 3;
        this.nombreSize = 50;

    }

    public String rellenarDatos(String atributo, int size) {

    
          return String.format("%-" + size + "s", atributo+'\0'); 
       

    }



}
