/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.editorficherostxt.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class GestorFicheros {

    private File archivo;

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public String abrir(File selectedFile) {
        archivo = selectedFile;
        Path pathFile = null;
        if (selectedFile != null) {
            pathFile = selectedFile.toPath();
            System.out.println("File selected: " + pathFile.toString());

        }

        try (BufferedReader reader = Files.newBufferedReader(pathFile)) {
            String texto="";
            String line;
            while ((line = reader.readLine()) != null) {
                texto+=line +"\n";
                
            }
            return texto;
        } catch (IOException e) {
            System.err.println("ERROR: " + e);
        }
        return null;
    }

    public void guardar(String txt) {

        
         try {
            File file = new File(archivo.getAbsolutePath());
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(txt);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarComo(String txt, File selectedFile) {

        archivo = selectedFile;

        Path pathFile = null;
        if (selectedFile != null) {
            pathFile = selectedFile.toPath();
            System.out.println("File selected: " + pathFile.toString());

        }
        FileWriter escribir;
        
        try {

            escribir = new FileWriter(archivo, true);
            escribir.write(txt);
            escribir.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Error al guardar, ponga nombre al archivo");
        } catch (IOException ex) {
            System.out.println("Error al guardar, en la salida");
        }

    }
}
