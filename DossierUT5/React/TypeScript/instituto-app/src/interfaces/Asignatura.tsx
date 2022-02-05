import { Matricula } from "./Matricula";

export interface Asignatura {

    idasignatura : number;
    curso : string;
    nombre: string;
    matriculas : Matricula[];
}