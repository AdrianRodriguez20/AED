/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.practica5;

import es.iespuertodelacruz.adrian.practica5.modelo.GestorFichero;
import es.iespuertodelacruz.adrian.practica5.modelo.Primos;
import java.io.IOException;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class EsIespuertodelacruzAdrianPractica5 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        Primos primos = new Primos();
        primos.listarPrimos();
        GestorFichero gf = new GestorFichero(primos);
        gf.aniadirPrimos();
        for (int i = 0; i < gf.mostrarPrimos().size(); i++) {
            System.out.println(gf.mostrarPrimos().get(i));
        }
        

    }
}
