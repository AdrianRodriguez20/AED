package es.iespuertodelacruz.adrian.instituto.utils;

public abstract class Mensajes {
    /**
     *  MENSAJES ALUMNO
     */

    public static final String STUDENT_SAVE_SUCCESS = "El Alumno se ha guardado en la base de datos correctamente.";
    public static final String STUDENT_SAVE_ERROR = "El Alumno no se ha podido guardar en la base de datos.";
    public static final String STUDENT_SAVE_ERROR_DUPLICATE = "El Alumno ya existe en la base de datos.";
    public static final String STUDENT_SAVE_INCOMPLETE = "El Alumno no se ha podido guardar en la base de datos. Faltan datos.";

    public static final String STUDENT_DELETE_SUCCESS = "El Alumno se ha eliminado correctamente.";
    public static final String STUDENT_DELETE_ERROR = "El Alumno no se ha podido eliminar.";
    public static final String STUDENT_DELETE_ERROR_NOT_FOUND = "El Alumno no se ha podido eliminar. No existe en la base de datos.";
    public static final String STUDENT_DELETE_ERROR_TUITION = "El Alumno no se ha podido eliminar. Tiene una matricula.";

    public static final String STUDENT_UPDATE_SUCCESS = "El Alumno se ha actualizado correctamente.";
    public static final String STUDENT_UPDATE_ERROR = "El Alumno no se ha podido actualizar.";
    public static final String STUDENT_UPDATE_ERROR_NOT_FOUND = "El Alumno no se ha podido actualizar. No existe en la base de datos.";
    public static final String STUDENT_UPDATE_INCOMPLETE = "El Alumno no se ha podido actualizar. Faltan datos.";

    public static final String STUDENT_FIND_SUCCESS = "El Alumno se ha encontrado correctamente.";
    public static final String STUDENT_FIND_ERROR_NOT_FOUND = "El Alumno no se ha podido encontrar. No existe en la base de datos.";


    /**
     *  MENSAJES ASIGNATURA
     */
    public static final String SUBJECT_SAVE_SUCCESS = "La Asignatura se ha guardado en la base de datos correctamente.";
    public static final String SUBJECT_SAVE_ERROR = "La Asignatura no se ha guardado en la base de datos correctamente.";
    public static final String SUBJECT_SAVE_INCOMPLETE= "La Asingatura no se ha podido guardar en la base de datos. Faltan datos.";
    public static final String SUBJECT_SAVE_ERROR_DUPLICATE = "La Asignatura ya existe en la base de datos.";

    public static final String SUBJECT_DELETE_SUCCESS = "La Asignatura se ha eliminado correctamente.";
    public static final String SUBJECT_DELETE_ERROR = "La Asignatura no se ha podido eliminar.";
    public static final String SUBJECT_DELETE_ERROR_NOT_FOUND = "La Asignatura no se ha podido eliminar. No existe en la base de datos.";
    public static final String SUBJECT_DELETE_INCOMPLETE = "La Asignatura no se ha podido eliminar. Faltan datos.";

    public static final String SUBJECT_UPDATE_SUCCESS = "La Asignatura se ha actualizado correctamente.";
    public static final String SUBJECT_UPDATE_ERROR = "La Asignatura no se ha podido actualizar.";
    public static final String SUBJECT_UPDATE_ERROR_NOT_FOUND = "La Asignatura no se ha podido actualizar. No existe en la base de datos.";
    public static final String SUBJECT_UPDATE_INCOMPLETE = "La Asignatura no se ha podido actualizar. Faltan datos.";
    public static final String SUBJECT_UPDATE_ERROR_DUPLICATE = "La Asignatura no se ha podido actualizar. Ya existe en la base de datos.";

    public static final String SUBJECT_FIND_SUCCESS = "La Asignatura se ha encontrado correctamente.";
    public static final String SUBJECT_FIND_NOT_FOUND = "La Asignatura no se ha podido encontrar. No existe en la base de datos.";

    /**
     *  MENSAJES MATRICULA
     */

    public static final String TUITION_SAVE_SUCCESS = "La Matricula se ha guardado en la base de datos correctamente.";
    public static final String TUITION_SAVE_INCOMPLETE= "La Matricula no se ha podido guardar en la base de datos. Faltan datos.";
    public static final String TUITION_SAVE_ERROR_DUPLICATE = "La Matricula ya existe en la base de datos.";
    public static final String TUITION_SAVE_ERROR_NOT_FOUND_STUDENT = "La Matricula no se ha podido guardar en la base de datos. No existe el alumno.";
    public static final String TUITION_SAVE_ERROR_NOT_FOUND_SUBJECT = "La Matricula no se ha podido guardar en la base de datos. No existe la asignatura asosiadas.";
    public static final String TUITION_SAVE_ERROR_FORMAT_SUBJECT = "La Matrícula no se podido guardar en la base de datos. Revisa el campo de las asignaturas , es incorrecto.";

    public static final String TUITION_UPDATE_SUCCESS = "La Matricula se ha actualizado correctamente.";
    public static final String TUITION_UPDATE_INCOMPLETE = "La Matricula no se ha podido actualizar. Faltan datos.";
    public static final String TUITION_UPDATE_ERROR_DUPLICATE = "La Matricula no se ha podido actualizar. Ya existe en la base de datos.";
    public static final String TUITION_UPDATE_ERROR_NOT_FOUND_STUDENT = "La Matricula no se ha podido actualizar. No existe el alumno.";
    public static final String TUITION_UPDATE_ERROR_NOT_FOUND_SUBJECT = "La Matricula no se ha podido actualizar. No existe la asignatura asosiadas.";
    public static final String TUITION_UPDATE_ERROR_NOT_FOUND_TUITION = "La Matricula no se ha podido actualizar. No existe en la base de datos.";
    public static final String TUITION_UPDATE_ERROR = "La Matricula no se ha podido actualizar.";
    public static final String TUITION_UPDATE_ERROR_FORMAT_SUBJECT = "La Matrícula no se podido guardar en la base de datos. Revisa el campo de las asignaturas , es incorrecto.";

    public static final String TUITION_DELETE_SUCCESS = "La Matricula se ha eliminado correctamente.";
    public static final String TUITION_DELETE_ERROR = "La Matricula no se ha podido eliminar.";
    public static final String TUITION_DELETE_ERROR_NOT_FOUND = "La Matricula no se ha podido eliminar. No existe en la base de datos.";
    public static final String TUITION_DELETE_INCOMPLETE = "La Matricula no se ha podido eliminar. Faltan datos.";


    public static final String TUITION_FIND_SUCCESS = "La Matricula se ha encontrado correctamente.";
    public static final String TUITION_FIND_NOT_FOUND = "La Matricula no se ha podido encontrar. No existe en la base de datos.";



}
