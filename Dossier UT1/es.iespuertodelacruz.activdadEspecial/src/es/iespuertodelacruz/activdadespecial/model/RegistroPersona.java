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
public class RegistroPersona {

    static int nombreSize = 50;
    static int apellidoSize = 50;
    static int edadSize = 3;

    String nombre;
    String apellido;
    String edad;

    /**
     * Constructor vacio por defecto
     */
    public RegistroPersona() {
    }

    /**
     * Constructor RegistroPersona
     *
     * @param nombre
     * @param apellido
     * @param edad
     */
    public RegistroPersona(String nombre, String apellido, String edad) {
        this.nombre = stringToStringFixedSize(nombre, nombreSize);
        this.apellido = stringToStringFixedSize(apellido, apellidoSize);
        this.edad = stringToStringFixedSize(edad, edadSize);
    }
    /**
     * Metodo que convierte el String  de atributo en un String de tamaño fijo
     * @param atributo
     * @param size
     * @return string de tamaño fijo
     */

    public String stringToStringFixedSize(String atributo, int size) {

        return String.format("%-" + size + "s", atributo + '\0');

    }
    /**
     * Método inverso al anterior pasa el String de fichero fijo a un String sin
     * espacios.
     * @param atributo
     * @return  String Parseado
     */

    public String stringFixedSizeToString(String atributo) {

        String[] parse = null;

        if (atributo.contains("\0")) {
            parse = atributo.split("\0");

        }
        return parse[0];
    }
    /**
     *  Método para convertir un registro persona en una persona
     * @param mp
     * @return persona
     */

    public Persona toPersona(RegistroPersona mp) {

        Persona p = new Persona();

        p.setNombre(mp.stringFixedSizeToString(mp.nombre));
        p.setEdad(mp.stringFixedSizeToString(mp.edad));
        p.setApellido(mp.stringFixedSizeToString(mp.apellido));

        return p;
    }

}
