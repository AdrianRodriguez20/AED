package es.iespuertodelacruz.adrian.instituto.dto;

import es.iespuertodelacruz.adrian.instituto.entity.Alumno;

import java.math.BigInteger;

public class ListadoAlumnosV1DTO {
    private String apellidos;
    private String nombre;

    public ListadoAlumnosV1DTO() {
    }

    public ListadoAlumnosV1DTO (Alumno a) {
        this.apellidos = a.getApellidos();
        this.nombre = a.getNombre();

    }



    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



}