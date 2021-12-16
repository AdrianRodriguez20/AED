package es.iespuertodelacruz.adrian.instituto.dto;


import es.iespuertodelacruz.adrian.instituto.entity.Matricula;

import java.util.ArrayList;
import java.util.List;

public class ListadoMatriculasAlumnoDTO {

    private int id;
    private int year;


    public ListadoMatriculasAlumnoDTO() {

    }

    public ListadoMatriculasAlumnoDTO(Matricula m) {
        this.id = m.getIdmatricula();
        this.year = m.getYear();
    }

    public static List<ListadoMatriculasAlumnoDTO> toListadoMatriculasAlumnoDTO(List<Matricula> matriculas) {
        List<ListadoMatriculasAlumnoDTO> listadoMatriculasAlumnoDTO = new ArrayList<>();
        if (matriculas!=null) {
            for (Matricula m : matriculas) {
                listadoMatriculasAlumnoDTO.add(new ListadoMatriculasAlumnoDTO(m));
            }
        }
        return listadoMatriculasAlumnoDTO;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Matricula toMatricula() {
        return new Matricula (year, id);
    }


}

