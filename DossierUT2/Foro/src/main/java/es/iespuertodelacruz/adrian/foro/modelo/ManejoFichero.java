package es.iespuertodelacruz.adrian.foro.modelo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Vector;

public class ManejoFichero {

Path path = Paths.get("mensajesSerializable.txt");
    

    public ManejoFichero() {
    }

    public ManejoFichero(String archivo) {
        path = Paths.get(archivo);
    }

    public void aniadirMensaje(Vector<Mensaje> mensaje) {

        try (
                FileOutputStream fos = new FileOutputStream(path.toString());
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos);) {

            for (Mensaje mensaje1 : mensaje) {
                oos.writeObject(mensaje1);     
            }


        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }

    public Vector<Mensaje> getAll() throws IOException, ClassNotFoundException {
       Vector<Mensaje> mensajes = new Vector<>();

        try (
                FileInputStream fis = new FileInputStream(path.toString());
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);) {
            boolean finDeFichero = false;
            Mensaje p;
            do {
                try {
                    p = (Mensaje) ois.readObject();

                    mensajes.add(p);

                } catch (EOFException ex) {
                    finDeFichero = true;
                }
            } while (!finDeFichero);
        } catch (FileNotFoundException ex) {
        }
        return mensajes;

    }
}
