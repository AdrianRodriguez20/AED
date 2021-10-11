/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.jc.monedasxml;

import es.iespuertodelacruz.jc.monedasxml.entities.Almacen;
import es.iespuertodelacruz.jc.monedasxml.entities.Historico;
import es.iespuertodelacruz.jc.monedasxml.entities.Moneda;
import es.iespuertodelacruz.jc.monedasxml.utils.ManejoFichero;
import es.iespuertodelacruz.jc.monedasxml.xml.HistoricoXML;
import es.iespuertodelacruz.jc.monedasxml.xml.MonedaXML;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author carlos
 */
public class MonedasXML {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        Moneda m = new Moneda(1, "libra", "uk");

        MonedaXML monedaXML = new MonedaXML();

    

        String strXMLmoneda = monedaXML.objToStringXML(m);

        System.out.println(
                strXMLmoneda
        );

        Moneda m2 = monedaXML.stringXMLToObj(strXMLmoneda);

        System.out.println(m2);

        Historico h = new Historico();
        h.setMoneda(m2);
        h.setEquivalenteEuro(2.3);
        h.setFecha(new Date());
        h.setIdHistorico(1);

        Historico h2 = new Historico();
        h2.setMoneda(m2);
        h2.setEquivalenteEuro(2.5);
        h2.setFecha(new Date());
        h2.setIdHistorico(2);

        HistoricoXML hXML = new HistoricoXML();

        System.out.println(
                hXML.objToStringXML(h)
        );

        m2.getHistoricos().add(h);
        m2.getHistoricos().add(h2);

        System.out.println(monedaXML.objToStringXML(m2)
        );

        ManejoFichero mf = new ManejoFichero("mixml.txt");

      //  mf.borrarYAgregar(monedaXML.objToStringXML(m2));
        System.out.println("---- lectura ----");
        System.out.println(
                mf.leerTodo()
        );

        Moneda m3 = monedaXML.stringXMLToObj(mf.leerTodo());
        System.out.println(m3);

    }

}
