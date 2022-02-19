package es.iespuertodelacruz.adrian.restaurante.dto.platos;

import es.iespuertodelacruz.adrian.restaurante.entity.Plato;

public class PlatoServicioDTO {


    private String descripcion;
    private String nombre;
    private double preciounidad;
    private int idplato;


    public PlatoServicioDTO() { }

    public PlatoServicioDTO(Plato p){
        this.descripcion = p.getDescripcion();
        this.nombre = p.getNombre();
        this.preciounidad = p.getPreciounidad();
        this.idplato = p.getIdplato();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPreciounidad() {
        return preciounidad;
    }

    public void setPreciounidad(double preciounidad) {
        this.preciounidad = preciounidad;
    }


    public int getIdplato() {
        return idplato;
    }

    public void setIdplato(int idplato) {
        this.idplato = idplato;
    }


    public Plato toEntity(){
        Plato p = new Plato();
        p.setDescripcion(this.descripcion);
        p.setNombre(this.nombre);
        p.setPreciounidad(this.preciounidad);
        p.setIdplato(this.idplato);
        return p;
    }

}
