package es.iespuertodelacruz.adrian.restaurante.dto.detallefactura;

import es.iespuertodelacruz.adrian.restaurante.entity.Detallefactura;
import es.iespuertodelacruz.adrian.restaurante.entity.Plato;
import es.iespuertodelacruz.adrian.restaurante.entity.Servicio;

public class DetalleFacturaPostDTO {

    private int cantidad;
    private int idplato;
    private int idservicio;
    private double preciounidad;


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdplato() {
        return idplato;
    }

    public void setIdplato(int idplato) {
        this.idplato = idplato;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public void setPreciounidad(double preciounidad) {
        this.preciounidad = preciounidad;
    }

    public Detallefactura toEntity() {
        Detallefactura detallefactura = new Detallefactura();
        detallefactura.setCantidad(cantidad);
        Plato plato = new Plato();
        plato.setIdplato(idplato);
        detallefactura.setPlato(plato);
        Servicio servicio = new Servicio();
        servicio.setIdservicio(idservicio);
        detallefactura.setServicio(servicio);
        detallefactura.setPreciounidad(preciounidad);
        return detallefactura;
    }
}
