/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.propietariosxml.xml;

import es.iespuertodelacruz.adrian.propietariosxml.entities.Propietario;
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
public class PropietarioXML implements JavaToXMLString<Propietario> {

    @Override
    public String objToStringXML(Propietario propietario) {
        StringWriter sw = new StringWriter();
        try {

            JAXBContext contexto = JAXBContext.newInstance(propietario.getClass());
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(propietario, sw);
        } catch (JAXBException ex) {
            System.out.println(ex);
        } finally {
            return sw.toString();
        }
    }

    @Override
    public Propietario stringXMLToObj(String textoXML) {

        Propietario propietario = null;
        try {
            JAXBContext contexto = JAXBContext.newInstance(Propietario.class);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            StringReader sr = new StringReader(textoXML);
            propietario = (Propietario) unmarshaller.unmarshal(sr);
        } catch (JAXBException ex) {
            System.out.println(ex);
        } finally {
            return propietario;
        }

    }
    
}
