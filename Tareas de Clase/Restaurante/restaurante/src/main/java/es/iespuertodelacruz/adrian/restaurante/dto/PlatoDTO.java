package es.iespuertodelacruz.adrian.restaurante.dto;

import es.iespuertodelacruz.adrian.restaurante.entity.Plato;

public class PlatoDTO {

    private int idplato;
    private String descripcion;
    private boolean disponible;
    private String nombre;
    private double preciounidad;


   public PlatoDTO() { }

    public PlatoDTO(Plato p){
       this.idplato = p.getIdplato();
       this.descripcion = p.getDescripcion();
       this.disponible = p.getDisponible();
       this.nombre = p.getNombre();
       this.preciounidad = p.getPreciounidad();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
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


    public Plato toPlato(){
        Plato p = new Plato();
        p.setIdplato(this.idplato);
        p.setDescripcion(this.descripcion);
        p.setDisponible(this.disponible);
        p.setNombre(this.nombre);
        p.setPreciounidad(this.preciounidad);
        return p;
    }
}
