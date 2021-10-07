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

    static int nombreSize = 50;
    static int apellidoSize = 50;
    static int edadSize = 3;

    private String nombre;
    private String apellido;
    private String edad;

    public ManejoPersona() {
    }

    public ManejoPersona(String nombre, String apellido, String edad) {
        this.nombre = stringToStringFixedSize(nombre, nombreSize);
        this.apellido = stringToStringFixedSize(apellido, apellidoSize);
        this.edad = stringToStringFixedSize(edad, edadSize);
    }

    public String stringToStringFixedSize(String atributo, int size) {

        return String.format("%-" + size + "s", atributo + '\0');

    }

    public String stringFixedSizeToString(String atributo) {

        String[] parse = null;

        if (atributo.contains("\0")) {
            parse = atributo.split("\0");

        }
        return parse[0];
    }

    public Persona toPersona(ManejoPersona mp) {
        
        Persona p = new Persona();

        p.setNombre(mp.stringFixedSizeToString(mp.nombre));
        p.setEdad(mp.stringFixedSizeToString(mp.edad));
        p.setApellido(mp.stringFixedSizeToString(mp.nombre));
        
        return p;
    }
}
