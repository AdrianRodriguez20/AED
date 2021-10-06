/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.practica5.modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class GestorFichero {

    File file = new File("primosBinarios.txt");
    Primos primos;

    public GestorFichero() {
    }

    public GestorFichero(Primos primos) {
        this.primos = primos;
    }

    public void aniadirPrimos() throws IOException {

        try {
            FileOutputStream fis = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(fis);
            for (int i = 0; i < primos.listaPrimos.size(); i++) {
                dos.writeInt(primos.listaPrimos.get(i));
            }
            dos.close();
        } catch (FileNotFoundException e) {

        }
    }

    public ArrayList<Integer> mostrarPrimos() throws IOException {
        ArrayList<Integer> cienPrimos = new ArrayList();
        try {
            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);
            
            int listaPrimos;
            for (int i = 0; i < 100; i++) {
                 listaPrimos=dis.readInt();
                 cienPrimos.add(listaPrimos);
            }
           
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestorFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cienPrimos;
    }

}
