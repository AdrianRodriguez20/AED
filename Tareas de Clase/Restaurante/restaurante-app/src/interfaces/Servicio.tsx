import { Detallefactura } from "./DetalleFactura";
export interface Servicio {
    idservicio:      number;
    fechacomienzo:   number;
    fechafin:        number;
    pagada?:          boolean;
    reservada:       string;
    nummesa:         number;
    detallefacturas?: Detallefactura[];
}

// Generated by https://quicktype.io