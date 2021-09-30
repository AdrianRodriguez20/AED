/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioPrimos;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class PrimoBeta {

    static public boolean esPrimo(int candidato) {

        boolean prim = true;

        int divisor = 2;

        while ((prim) && (divisor != candidato)) {
            if ((candidato % divisor == 0)) {
                prim = false;
            } else {
                divisor++;
            }
        }
        return prim;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            if (true) {
                System.out.println(esPrimo(i));
            }

        }
    }
}
