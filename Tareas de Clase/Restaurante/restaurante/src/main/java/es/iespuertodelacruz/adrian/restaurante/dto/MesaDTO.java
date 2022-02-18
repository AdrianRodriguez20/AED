package es.iespuertodelacruz.adrian.restaurante.dto;

import es.iespuertodelacruz.adrian.restaurante.entity.Mesa;

public class MesaDTO {

    private int nummesa;
    private int ocupantesmax;

    public MesaDTO() {
    }

    public MesaDTO(Mesa m) {
        this.nummesa = m.getNummesa();
        this.ocupantesmax = m.getOcupantesmax();
    }


    public int getNummesa() {
        return nummesa;
    }

    public void setNummesa(int nummesa) {
        this.nummesa = nummesa;
    }

    public int getOcupantesmax() {
        return ocupantesmax;
    }

    public void setOcupantesmax(int ocupantesmax) {
        this.ocupantesmax = ocupantesmax;
    }

    public Mesa toMesa() {
        Mesa m = new Mesa();
        m.setNummesa(this.nummesa);
        m.setOcupantesmax(this.ocupantesmax);
        return m;
    }



}
