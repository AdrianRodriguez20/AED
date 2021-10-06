/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.practica5.modelo;

import java.util.ArrayList;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class Primos {

    ArrayList<Integer> listaPrimos = new ArrayList();

    public Primos() {
    }

    public Boolean esPrimo(int numero) {
        Boolean esPrimoActual = true;
        if (numero < 2) {
            esPrimoActual = false;
        } else {
            for (int x = 2; x * x <= numero; x++) {
                if (numero % x == 0) {
                    esPrimoActual = false;
                    break;
                }
            }
        }
        return esPrimoActual;
    }

    public void listarPrimos() {

        for (int i = 0; i < 10000000; i++) {
            if (esPrimo(i)) {
                listaPrimos.add(i);
            };
        }
    }
}
