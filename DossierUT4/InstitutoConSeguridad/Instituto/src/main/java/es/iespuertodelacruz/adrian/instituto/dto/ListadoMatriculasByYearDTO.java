package es.iespuertodelacruz.adrian.instituto.dto;

import es.iespuertodelacruz.adrian.instituto.entity.Asignatura;
import es.iespuertodelacruz.adrian.instituto.entity.Matricula;

import java.util.ArrayList;
import java.util.List;

public class ListadoMatriculasByYearDTO {


    private List<AsignaturaDTO> asignaturas;
    AsignaturaDTO asignaturaDTO = new AsignaturaDTO();
    private ListadoAlumnosDTO alumnoDTO;
    private int idmatricula ;

    public ListadoMatriculasByYearDTO() {

    }

    public ListadoMatriculasByYearDTO(Matricula m) {
        this.idmatricula = m.getIdmatricula();
        this.alumnoDTO=new ListadoAlumnosDTO(m.getAlumno());
        this.asignaturas = asignaturaDTO.toAsignaturaDTO(m.getAsignaturas());



    }

    public static List<MatriculaDTO> toMatriculaDTO(List<Matricula> matriculas) {
        List<MatriculaDTO> matriculasDTO = new ArrayList<>();
        for (Matricula m : matriculas) {
            matriculasDTO.add(new MatriculaDTO(m));
        }
        return matriculasDTO;
    }


    public int getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(int idmatricula) {
        this.idmatricula = idmatricula;
    }

    public ListadoAlumnosDTO getAlumno() {
        return alumnoDTO;
    }

    public void setAlumno(ListadoAlumnosDTO alumnoDTO) {
        this.alumnoDTO = alumnoDTO;
    }


    public List<AsignaturaDTO> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<AsignaturaDTO> asignaturas) {
        this.asignaturas = asignaturas;
    }




    public List<Asignatura> toAsignaturas() {
        List<Asignatura> asignaturasModel = new ArrayList<Asignatura>();
        for (AsignaturaDTO a : asignaturas) {
            asignaturasModel.add(new Asignatura(a.getIdasignatura(), a.getCurso(), a.getNombre()));
        }
        return asignaturasModel;
    }

    public Matricula toMatricula() {
        return new Matricula (alumnoDTO.toAlumno(),idmatricula,toAsignaturas());
    }

}
