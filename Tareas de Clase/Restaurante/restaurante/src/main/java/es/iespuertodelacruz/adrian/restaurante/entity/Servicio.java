package es.iespuertodelacruz.adrian.restaurante.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the servicios database table.
 * 
 */
@Entity
@Table(name="servicios")
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idservicio;

	private Long fechacomienzo;

	private Long fechafin;

	private Boolean pagada;

	private String reservada;

	//bi-directional many-to-one association to Detallefactura
	@OneToMany(mappedBy="servicio")
	private List<Detallefactura> detallefacturas;

	//bi-directional many-to-one association to Mesa
	@ManyToOne
	@JoinColumn(name="fk_nummesa")
	private Mesa mesa;

	public Servicio() {
	}

	public int getIdservicio() {
		return this.idservicio;
	}

	public void setIdservicio(int idservicio) {
		this.idservicio = idservicio;
	}

	public Long getFechacomienzo() {
		return this.fechacomienzo;
	}

	public void setFechacomienzo(Long fechacomienzo) {
		this.fechacomienzo = fechacomienzo;
	}

	public Long getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Long fechafin) {
		this.fechafin = fechafin;
	}

	public Boolean getPagada() {
		return this.pagada;
	}

	public void setPagada(Boolean pagada) {
		this.pagada = pagada;
	}

	public String getReservada() {
		return this.reservada;
	}

	public void setReservada(String reservada) {
		this.reservada = reservada;
	}

	public List<Detallefactura> getDetallefacturas() {
		return this.detallefacturas;
	}

	public void setDetallefacturas(List<Detallefactura> detallefacturas) {
		this.detallefacturas = detallefacturas;
	}

	public Detallefactura addDetallefactura(Detallefactura detallefactura) {
		getDetallefacturas().add(detallefactura);
		detallefactura.setServicio(this);

		return detallefactura;
	}

	public Detallefactura removeDetallefactura(Detallefactura detallefactura) {
		getDetallefacturas().remove(detallefactura);
		detallefactura.setServicio(null);

		return detallefactura;
	}

	public Mesa getMesa() {
		return this.mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

}