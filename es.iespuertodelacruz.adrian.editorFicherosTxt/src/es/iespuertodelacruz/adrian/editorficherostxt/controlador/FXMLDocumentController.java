/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.editorficherostxt.controlador;

import es.iespuertodelacruz.adrian.editorficherostxt.modelo.GestorFicheros;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class FXMLDocumentController implements Initializable {

    GestorFicheros gestorFicheros = new GestorFicheros();

    @FXML
    private TextArea editorTxt;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void crear(ActionEvent event) {
        editorTxt.clear();
    }

    @FXML
    private void abrir(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir fichero");
        File selectedFile = fileChooser.showOpenDialog(null);

        editorTxt.setText(gestorFicheros.abrir(selectedFile));

    }

    @FXML
    private void guardar(ActionEvent event) {
        if(gestorFicheros.getArchivo()==null){
            guardarComo(event);
        }else{
           
            gestorFicheros.guardar(editorTxt.getText());
        }
    }

    @FXML
    private void guardarComo(ActionEvent event) {
     
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar fichero");
        File selectedFile = fileChooser.showSaveDialog(null);
        gestorFicheros.guardarComo(editorTxt.getText(),selectedFile);
        

    }

    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }

}
