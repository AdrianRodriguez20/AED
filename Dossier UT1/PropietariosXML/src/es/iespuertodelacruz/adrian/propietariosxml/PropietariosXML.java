/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.propietariosxml;

import es.iespuertodelacruz.adrian.propietariosxml.entities.Casa;
import es.iespuertodelacruz.adrian.propietariosxml.entities.Propietario;
import es.iespuertodelacruz.adrian.propietariosxml.utils.ManejoFichero;
import es.iespuertodelacruz.adrian.propietariosxml.xml.CasaXML;
import es.iespuertodelacruz.adrian.propietariosxml.xml.PropietarioXML;
import java.io.IOException;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class PropietariosXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Casa c = new Casa(24, "La Isleta");

        CasaXML casaXML = new CasaXML();

        String strXMLcasa = casaXML.objToStringXML(c);

        System.out.println(strXMLcasa
        );

        Casa c2 = casaXML.stringXMLToObj(strXMLcasa);

        System.out.println(c2);

        Propietario h = new Propietario();
        h.setCasa(c2);
        h.setNombre("Adrian");
        h.setApellido("Rodríguez");


        Propietario h2 = new Propietario();
        h2.setCasa(c2);
        h2.setNombre("Nicolás");
        h2.setApellido("González");


        PropietarioXML hXML = new PropietarioXML();

        System.out.println(
                hXML.objToStringXML(h)
        );

        c2.getPropietarios().add(h);
        c2.getPropietarios().add(h2);

        System.out.println(casaXML.objToStringXML(c2));

        ManejoFichero mf = new ManejoFichero("m.txt");

        mf.borrarYAgregar(casaXML.objToStringXML(c2));
        System.out.println("---- lectura ----");
        System.out.println(
                mf.leerTodo()
        );

        Casa m3 = casaXML.stringXMLToObj(mf.leerTodo());
        System.out.println(m3);
    }

}
