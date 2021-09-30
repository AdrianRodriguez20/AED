/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioPrimos;

import java.util.ArrayList;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class primos2 {

    private static boolean numeroPrimo(long num, int divisor) {
        if (num / 2 < divisor) {
            return true;
        } else {
            if (num % divisor == 0) {
                return false;
            } else {
                return numeroPrimo(num, divisor + 1);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Long> numeroPrimo = new ArrayList<>();
        for (long i = 2; i < 10000000; i++) {
            if (numeroPrimo(i, 2)) {
                System.out.println(i);
                numeroPrimo.add(i);
               
            }

        }
         System.out.println("Tamaño: "+numeroPrimo.size());
    }
}
