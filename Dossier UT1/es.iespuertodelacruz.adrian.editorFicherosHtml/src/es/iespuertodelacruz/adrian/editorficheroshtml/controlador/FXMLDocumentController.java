/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.adrian.editorficheroshtml.controlador;

import es.iespuertodelacruz.adrian.editorficheroshtml.modelo.GestorFicheros;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;

/**
 *
 * @author Adrián Rodríguez Fuentes
 */
public class FXMLDocumentController implements Initializable {

    GestorFicheros gestorFicheros;

    @FXML
    private HTMLEditor htmlEditor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestorFicheros = new GestorFicheros();
    }

    @FXML
    private void guardarComo(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar fichero");
        FileChooser.ExtensionFilter extFilterTXT = new FileChooser.ExtensionFilter("TEXT files (*.txt) ", "*.txt");
        FileChooser.ExtensionFilter extFilterHTML = new FileChooser.ExtensionFilter("HTML files (*.html) ", "*.html");
        fileChooser.getExtensionFilters().add(extFilterTXT);
        fileChooser.getExtensionFilters().add(extFilterHTML);
        File selectedFile = fileChooser.showSaveDialog(null);
        gestorFicheros.guardarComo(htmlEditor.getHtmlText(), selectedFile);

    }

    @FXML
    private void crear(ActionEvent event) {
         htmlEditor.setHtmlText("");
    }

    @FXML
    private void abrir(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir fichero");
        File selectedFile = fileChooser.showOpenDialog(null);

        htmlEditor.setHtmlText(gestorFicheros.abrir(selectedFile));

    }

    @FXML
    private void guardar(ActionEvent event) {
        if (gestorFicheros.getArchivo() == null) {
            guardarComo(event);
        } else {

            gestorFicheros.guardar(htmlEditor.getHtmlText());
        }
    }

    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }

}
