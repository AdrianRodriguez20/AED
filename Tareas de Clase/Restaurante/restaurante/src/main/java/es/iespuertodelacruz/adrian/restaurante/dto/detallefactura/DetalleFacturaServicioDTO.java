package es.iespuertodelacruz.adrian.restaurante.dto.detallefactura;

import es.iespuertodelacruz.adrian.restaurante.dto.platos.PlatoServicioDTO;
import es.iespuertodelacruz.adrian.restaurante.dto.servicios.ListadoServiciosDTO;
import es.iespuertodelacruz.adrian.restaurante.entity.Detallefactura;
import es.iespuertodelacruz.adrian.restaurante.entity.Plato;
import es.iespuertodelacruz.adrian.restaurante.entity.Servicio;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

public class DetalleFacturaServicioDTO {

    private int cantidad;

    private double preciounidad;

    private PlatoServicioDTO plato;

    public DetalleFacturaServicioDTO() {
    }

    public DetalleFacturaServicioDTO(Detallefactura d){
        this.cantidad = d.getCantidad();
        this.preciounidad = d.getPreciounidad();
        this.plato = new PlatoServicioDTO(d.getPlato());
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreciounidad() {
        return preciounidad;
    }

    public void setPreciounidad(double preciounidad) {
        this.preciounidad = preciounidad;
    }

    public PlatoServicioDTO getPlato() {
        return plato;
    }

    public void setPlato(PlatoServicioDTO plato) {
        this.plato = plato;
    }

    public Detallefactura toEntity(){
        Detallefactura d = new Detallefactura();
        d.setCantidad(this.cantidad);
        d.setPreciounidad(this.preciounidad);
        d.setPlato(this.plato.toEntity());
        return d;
    }

    public List<DetalleFacturaServicioDTO>toListadoServiciosDTO(List<Detallefactura> lista){
        List<DetalleFacturaServicioDTO> listado = new ArrayList<>();
        for(Detallefactura d: lista){
            listado.add(new DetalleFacturaServicioDTO(d));
        }
        return listado;
    }
}
