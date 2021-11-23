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
import javax.persistence.CascadeType;
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

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
@Entity
@Table(name = "address", catalog = "sakila", schema = "")
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findByAddressId", query = "SELECT a FROM Address a WHERE a.addressId = :addressId")
    , @NamedQuery(name = "Address.findByAddress", query = "SELECT a FROM Address a WHERE a.address = :address")
    , @NamedQuery(name = "Address.findByAddress2", query = "SELECT a FROM Address a WHERE a.address2 = :address2")
    , @NamedQuery(name = "Address.findByDistrict", query = "SELECT a FROM Address a WHERE a.district = :district")
    , @NamedQuery(name = "Address.findByPostalCode", query = "SELECT a FROM Address a WHERE a.postalCode = :postalCode")
    , @NamedQuery(name = "Address.findByPhone", query = "SELECT a FROM Address a WHERE a.phone = :phone")
    , @NamedQuery(name = "Address.findByLastUpdate", query = "SELECT a FROM Address a WHERE a.lastUpdate = :lastUpdate")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "address_id", nullable = false)
    private Short addressId;
    @Basic(optional = false)
    @Column(name = "address", nullable = false, length = 50)
    private String address;
    @Column(name = "address2", length = 50)
    private String address2;
    @Basic(optional = false)
    @Column(name = "district", nullable = false, length = 20)
    private String district;
    @Column(name = "postal_code", length = 10)
    private String postalCode;
    @Basic(optional = false)
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;
    @Basic(optional = false)
    @Column(name = "last_update", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private City cityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId", fetch = FetchType.LAZY)
    private List<Staff> staffList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId", fetch = FetchType.LAZY)
    private List<Store> storeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId", fetch = FetchType.LAZY)
    private List<Customer> customerList;

    public Address() {
    }

    public Address(Short addressId) {
        this.addressId = addressId;
    }

    public Address(Short addressId, String address, String district, String phone, Date lastUpdate) {
        this.addressId = addressId;
        this.address = address;
        this.district = district;
        this.phone = phone;
        this.lastUpdate = lastUpdate;
    }

    public Short getAddressId() {
        return addressId;
    }

    public void setAddressId(Short addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.iespuertodelacruz.adrian.sakila.entities.Address[ addressId=" + addressId + " ]";
    }
    
}
