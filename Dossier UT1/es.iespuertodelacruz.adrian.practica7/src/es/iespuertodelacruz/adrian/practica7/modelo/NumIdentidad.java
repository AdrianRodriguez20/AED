/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.practica7.modelo;

import java.io.Serializable;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class NumIdentidad implements Serializable {

    private String dni;

    public NumIdentidad() {
    }

    public NumIdentidad(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean validarNumIdentidad() {

        if (dni.length() != 9) {
            return false;
        }
        String letrasNIF = "TRWAGMYFPDXBNJZSQVHLCKE";
        dni = dni.toUpperCase();
        String numeroNIF = dni.substring(0, dni.length() - 1);
        numeroNIF = numeroNIF.replace("X", "0").replace("Y", "1").replace("Z", "2");
        char letraNIF = dni.charAt(8);
        int i = Integer.parseInt(numeroNIF) % 23;
        return letraNIF == letrasNIF.charAt(i);

    }

    @Override
    public String toString() {
        return  dni ;
    }
    
    

}
