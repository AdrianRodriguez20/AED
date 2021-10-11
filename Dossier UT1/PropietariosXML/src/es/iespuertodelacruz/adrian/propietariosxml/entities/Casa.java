/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.propietariosxml.entities;

import com.sun.xml.internal.ws.util.StringUtils;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
@XmlRootElement(name = "casa")
public class Casa implements Serializable {

    Integer idCasa;
    String ciudad;
    ArrayList<Propietario> propietarios = new ArrayList<>();

    public Casa() {
    }

    
    public Casa(Integer idCasa, String ciudad) {
        this.idCasa = idCasa;
        this.ciudad = ciudad;
    }

    public Integer getIdCasa() {
        return idCasa;
    }

    public String getCiudad() {
        return ciudad;
    }
    @XmlElementWrapper(name = "propietarios")
    @XmlElement(name = "propietario")
    public ArrayList<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setIdCasa(Integer idCasa) {
        this.idCasa = idCasa;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPropietarios(ArrayList<Propietario> propietarios) {
        this.propietarios = propietarios;
    }

    @Override
    public String toString() {
        String listaPropietarios="";
        for (Propietario propietario : propietarios) {
            listaPropietarios+=propietario.toString()+",";
        }
     
        return "Casa{" + "idCasa=" + idCasa + ", ciudad=" + ciudad + ", propietarios=" + listaPropietarios + '}';
    }
    


}
