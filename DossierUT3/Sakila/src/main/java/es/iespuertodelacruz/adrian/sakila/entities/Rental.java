/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.sakila.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
@Entity
@Table(name = "rental", catalog = "sakila", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"rental_date", "inventory_id", "customer_id"})})
@NamedQueries({
    @NamedQuery(name = "Rental.findAll", query = "SELECT r FROM Rental r")
    , @NamedQuery(name = "Rental.findByRentalId", query = "SELECT r FROM Rental r WHERE r.rentalId = :rentalId")
    , @NamedQuery(name = "Rental.findByRentalDate", query = "SELECT r FROM Rental r WHERE r.rentalDate = :rentalDate")
    , @NamedQuery(name = "Rental.findByReturnDate", query = "SELECT r FROM Rental r WHERE r.returnDate = :returnDate")
    , @NamedQuery(name = "Rental.findByLastUpdate", query = "SELECT r FROM Rental r WHERE r.lastUpdate = :lastUpdate")})
public class Rental implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rental_id", nullable = false)
    private Integer rentalId;
    @Basic(optional = false)
    @Column(name = "rental_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalDate;
    @Column(name = "return_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;
    @Basic(optional = false)
    @Column(name = "last_update", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer customerId;
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Inventory inventoryId;
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Staff staffId;
    @OneToMany(mappedBy = "rentalId", fetch = FetchType.LAZY)
    private List<Payment> paymentList;

    public Rental() {
    }

    public Rental(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Rental(Integer rentalId, Date rentalDate, Date lastUpdate) {
        this.rentalId = rentalId;
        this.rentalDate = rentalDate;
        this.lastUpdate = lastUpdate;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Inventory getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Inventory inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rentalId != null ? rentalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rental)) {
            return false;
        }
        Rental other = (Rental) object;
        if ((this.rentalId == null && other.rentalId != null) || (this.rentalId != null && !this.rentalId.equals(other.rentalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.iespuertodelacruz.adrian.sakila.entities.Rental[ rentalId=" + rentalId + " ]";
    }
    
}
