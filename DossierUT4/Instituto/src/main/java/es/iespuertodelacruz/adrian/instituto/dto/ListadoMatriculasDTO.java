package es.iespuertodelacruz.adrian.instituto.dto;

import es.iespuertodelacruz.adrian.instituto.entity.Asignatura;
import es.iespuertodelacruz.adrian.instituto.entity.Matricula;

import java.util.ArrayList;
import java.util.List;

public class ListadoMatriculasDTO {

    private int year;
    private List<AsignaturaDTO> asignaturas;
    AsignaturaDTO asignaturaDTO = new AsignaturaDTO();
    private AlumnoDTO alumnoDTO;

    public ListadoMatriculasDTO () {

    }

    public ListadoMatriculasDTO (Matricula m) {
        this.year = m.getYear();
        this.asignaturas = asignaturaDTO.toAsignaturaDTO(m.getAsignaturas());
        this.alumnoDTO=new AlumnoDTO(m.getAlumno());

    }

    public static List<MatriculaDTO> toMatriculaDTO(List<Matricula> matriculas) {
        List<MatriculaDTO> matriculasDTO = new ArrayList<>();
        for (Matricula m : matriculas) {
            matriculasDTO.add(new MatriculaDTO(m));
        }
        return matriculasDTO;
    }



    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public List<AsignaturaDTO> getAsignaturas() {
        return asignaturas;
    }
    public void setAsignaturas(List<AsignaturaDTO> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public AlumnoDTO getAlumno() {
        return alumnoDTO;
    }

    public void setAlumno(AlumnoDTO alumnoDTO) {
        this.alumnoDTO = alumnoDTO;
    }


    public List<Asignatura> toAsignaturas(){
        List<Asignatura>asignaturasModel = new ArrayList<Asignatura>();
        for(AsignaturaDTO a : asignaturas) {
            asignaturasModel.add(new Asignatura (a.getIdasignatura(),a.getCurso(),a.getNombre()));
        }
        return asignaturasModel ;
    }

    public Matricula toMatricula() {
        return new Matricula (year,alumnoDTO.toAlumno(),toAsignaturas());
    }


}
