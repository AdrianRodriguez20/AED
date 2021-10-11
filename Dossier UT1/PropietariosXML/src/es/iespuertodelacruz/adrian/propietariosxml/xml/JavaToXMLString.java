/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.propietariosxml.xml;

import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public interface JavaToXMLString<T> {

    String objToStringXML(T obj);

    T stringXMLToObj(String texto);
}
