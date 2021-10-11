/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.jc.monedasxml.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
@XmlRootElement(name = "monedas")
public class Almacen implements Serializable {

    private ArrayList<Moneda> almacen;

    public Almacen() {
    }

    public Almacen(ArrayList<Moneda> almacen) {
        this.almacen = almacen;
    }

    @XmlElementWrapper(name = "monedas")
    @XmlElement(name = "moneda")
    public ArrayList<Moneda> getAlmacen() {
        return almacen;
    }

    public void setAlmacen(ArrayList<Moneda> almacen) {
        this.almacen = almacen;
    }
    
  

}
