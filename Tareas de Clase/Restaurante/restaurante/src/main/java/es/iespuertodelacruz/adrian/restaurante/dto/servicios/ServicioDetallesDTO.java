package es.iespuertodelacruz.adrian.restaurante.dto.servicios;

import com.fasterxml.jackson.annotation.JsonFormat;
import es.iespuertodelacruz.adrian.restaurante.dto.detallefactura.DetalleFacturaServicioDTO;
import es.iespuertodelacruz.adrian.restaurante.entity.Detallefactura;
import es.iespuertodelacruz.adrian.restaurante.entity.Servicio;

import java.util.Date;
import java.util.List;

public class ServicioDetallesDTO {

    private int idservicio;
    private Long fechacomienzo;
    private Long fechafin;
    private boolean pagada;
    private String reservada;
    private int nummesa;
    private List<DetalleFacturaServicioDTO> detallefacturas;


    public ServicioDetallesDTO(Servicio s){
        this.idservicio = s.getIdservicio();
        this.fechacomienzo = s.getFechacomienzo();
        this.fechafin = s.getFechafin();
        this.pagada = s.getPagada();
        this.reservada = s.getReservada();
        this.nummesa = s.getMesa().getNummesa();
        this.detallefacturas = new DetalleFacturaServicioDTO().toListadoServiciosDTO(s.getDetallefacturas());
    }

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public Long getFechacomienzo() {
        return fechacomienzo;
    }

    public void setFechacomienzo(Long fechacomienzo) {
        this.fechacomienzo = fechacomienzo;
    }

    public Long getFechafin() {
        return fechafin;
    }

    public void setFechafin(Long fechafin) {
        this.fechafin = fechafin;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public String getReservada() {
        return reservada;
    }

    public void setReservada(String reservada) {
        this.reservada = reservada;
    }

    public int getNummesa() {
        return nummesa;
    }

    public void setNummesa(int nummesa) {
        this.nummesa = nummesa;
    }

    public List<DetalleFacturaServicioDTO> getDetallefacturas() {
        return detallefacturas;
    }

    public void setDetallefacturas(List<DetalleFacturaServicioDTO> detallefacturas) {
        this.detallefacturas = detallefacturas;
    }


}
