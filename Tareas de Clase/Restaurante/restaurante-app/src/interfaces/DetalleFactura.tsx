import { Plato } from "./Plato";
export interface Detallefactura {
    iddetallefactura?: number;
    cantidad?: number;
    preciounidad?:number;
    plato: Plato;
    idservicio?: number;
}
// Generated by https://quicktype.io