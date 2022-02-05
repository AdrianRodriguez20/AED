import { Asignatura } from "./Asignatura";
import { Alumno } from "./Alumno";

export interface Matricula {
    idmatricula: number;
    year: number;
    alumno: Alumno;
    asignatura: Asignatura[];
}
