package es.iespuertodelacruz.adrian.instituto;

import es.iespuertodelacruz.adrian.instituto.dao.AsignaturaDAO;
import es.iespuertodelacruz.adrian.instituto.dao.GestorConexionDDBB;
import es.iespuertodelacruz.adrian.instituto.dao.MatriculaDAO;
import es.iespuertodelacruz.adrian.instituto.modelo.Asignatura;
import es.iespuertodelacruz.adrian.instituto.modelo.Matricula;
import es.iespuertodelacruz.adrian.instituto.modelo.Mensaje;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        GestorConexionDDBB gc = new GestorConexionDDBB("instituto", "root", "");
        MatriculaDAO matriculaDAO = new MatriculaDAO(gc);

        System.out.println("Método findBy()");
        Matricula m = matriculaDAO.findById("87654321X",2021);
        System.out.println(m);

        System.out.println("Método findAll()");

        for(Matricula matricula :matriculaDAO.findByAnio(2021)) {
            System.out.println(matricula);
        }

      //  AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gc);
      //  Asignatura asignatura = asignaturaDAO.save(new Asignatura("SSG", "2 DAM"));


            Mensaje mensaje = new Mensaje("hola", Mensaje.tipoMensaje.ERROR);
            System.out.println(mensaje.getMensaje());
            System.out.println(mensaje.getTipo());



    }
}
