package es.iespuertodelacruz.adrian.restaurante.dto.servicios;


import es.iespuertodelacruz.adrian.restaurante.entity.Mesa;
import es.iespuertodelacruz.adrian.restaurante.entity.Servicio;

public class ServicioDTO {

    private int idservicio;
    private Long fechacomienzo;
    private Long fechafin;
    private Boolean pagada;
    private String reservada;
    private int nummesa;

    public ServicioDTO (Servicio s) {
        this.idservicio = s.getIdservicio();
        this.fechacomienzo = s.getFechacomienzo();
        this.fechafin = s.getFechafin();
        this.pagada = s.getPagada();
        this.reservada = s.getReservada();
        this.nummesa = s.getMesa().getNummesa();
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

    public Boolean getPagada() {
        return pagada == null ? false : pagada;
    }

    public void setPagada(Boolean pagada) {
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

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public Servicio toEntity() {
        Servicio s = new Servicio();
        s.setIdservicio(this.idservicio);
        s.setFechacomienzo(this.fechacomienzo);
        s.setFechafin(this.fechafin);
        s.setPagada(this.pagada == null ? false : this.pagada);
        s.setReservada(this.reservada );
        Mesa m = new Mesa();
        m.setNummesa(this.nummesa);
        s.setMesa(m);
        return s;
    }
}
