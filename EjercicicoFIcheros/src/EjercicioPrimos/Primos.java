/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioPrimos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class Primos {

    /*
    Práctica 4:  Crear una aplicación que calcule los números primos menores a diez millones: 
10000000
haremos dos versiones, en ambos casos usaremos ficheros de texto. Escribiendo en cada 
línea el número obtenido
a) Obtenemos todos los números primero ( en un arraylist por ejemplo ) Una vez obtenidos 
los números abrimos un fichero y guardamos todos los números antes de cerrar el fichero
b) Por cada número nuevo que vayamos obteniendo, abrimos el fichero y lo agregamos al 
final del fichero, cerrando después el fichero ( observar que para comparar las velocidades 
es positivo mantener en lo posible la estructura del anterior algoritmo. Únicamente 
cambiando lo imprescindible )
Al finalizar tendremos más clara la importancia de los múltiples aperturas/cierres
     */
    public static void main(String[] args) {

        ArrayList<Integer> numeroPrimo = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            int contador = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    contador++;
                }
            }
            if (contador == 2) {
                numeroPrimo.add(i);
                numeroPrimo.size();
                System.out.println(i);
            }
        }

        Path path = Paths.get("C:\\Users\\Maria luisa\\Desktop\\fichero.txt");
    
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (int i = 0; i < numeroPrimo.size(); i++) {
                bw.write(Integer.toString(numeroPrimo.get(i)));
                bw.newLine();
            }
                bw.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        

    }

}
