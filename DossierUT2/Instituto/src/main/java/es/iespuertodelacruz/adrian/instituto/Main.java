package es.iespuertodelacruz.adrian.instituto;

import es.iespuertodelacruz.adrian.instituto.dao.GestorConexionDDBB;
import es.iespuertodelacruz.adrian.instituto.dao.MatriculaDAO;
import es.iespuertodelacruz.adrian.instituto.modelo.Matricula;

public class Main {
    public static void main(String[] args) {
        GestorConexionDDBB gc = new GestorConexionDDBB("instituto", "root", "");
        MatriculaDAO matriculaDAO = new MatriculaDAO(gc);

        System.out.println("Método findBy()");
        Matricula m = matriculaDAO.findById("87654321X",2021);
        System.out.println(m);

        System.out.println("Método findAll()");

        for(Matricula matricula :matriculaDAO.findAll()) {
            System.out.println(matricula);
        }

    }
}
