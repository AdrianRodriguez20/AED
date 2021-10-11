/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.propietariosxml.xml;

import es.iespuertodelacruz.adrian.propietariosxml.entities.Casa;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class CasaXML implements JavaToXMLString<Casa> {

    @Override
    public String objToStringXML(Casa casa) {
        StringWriter sw = new StringWriter();
        try {

            JAXBContext contexto = JAXBContext.newInstance(casa.getClass());
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(casa, sw);
        } catch (JAXBException ex) {
            System.out.println(ex);
        } finally {
            return sw.toString();
        }
    }

    @Override
    public Casa stringXMLToObj(String textoXML) {

        Casa casa = null;
        try {
            JAXBContext contexto = JAXBContext.newInstance(Casa.class);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            StringReader sr = new StringReader(textoXML);
            casa = (Casa) unmarshaller.unmarshal(sr);
        } catch (JAXBException ex) {
            System.out.println(ex);
        } finally {
            return casa;
        }

    }
}
