package es.iespuertodelacruz.adrian.acertarnumero.modelo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ManejoFichero {

Path path ;
    

    public ManejoFichero() {
    }

    public ManejoFichero(String archivo) {
        path = Paths.get(archivo);
    }

    public void aniadirSecreto(ArrayList<Secreto> secretos) {

        try (
                FileOutputStream fos = new FileOutputStream(path.toString());
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos);) {

            for (Secreto secreto1 : secretos) {
                oos.writeObject(secreto1);     
            }


        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }

    public List<Secreto> getAll() throws IOException, ClassNotFoundException {
       List<Secreto> secretos = new ArrayList<>();

        try (
                FileInputStream fis = new FileInputStream(path.toString());
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);) {
            boolean finDeFichero = false;
            Secreto c;
            do {
                try {
                    c = (Secreto) ois.readObject();

                    secretos.add(c);

                } catch (EOFException ex) {
                    finDeFichero = true;
                }
            } while (!finDeFichero);
        } catch (FileNotFoundException ex) {
        }
        return secretos;

    }
}
