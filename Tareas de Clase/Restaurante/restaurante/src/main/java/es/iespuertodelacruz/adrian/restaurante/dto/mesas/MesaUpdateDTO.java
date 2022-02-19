package es.iespuertodelacruz.adrian.restaurante.dto.mesas;

import es.iespuertodelacruz.adrian.restaurante.entity.Mesa;

public class MesaUpdateDTO {

    private int nummesa;
    private int ocupantesmax;

    public MesaUpdateDTO(Mesa m) {
        this.ocupantesmax = m.getOcupantesmax();
        this.nummesa = m.getNummesa();
    }

    public int getOcupantesmax() {
        return ocupantesmax;
    }

    public void setOcupantesmax(int ocupantesmax) {
        this.ocupantesmax = ocupantesmax;
    }

    public void setNummesa(int nummesa) {
        this.nummesa = nummesa;
    }

    public Mesa toEntity() {
        Mesa m = new Mesa();
        m.setNummesa(this.nummesa);
        m.setOcupantesmax(this.ocupantesmax);
        return m;
    }
}
