import { Matricula } from "./Matricula";

export interface Alumno {
    dni: string;
    nombre: string;
    apellidos: string;
    fechanacimiento: string;
    matriculas?: Matricula[];
}

