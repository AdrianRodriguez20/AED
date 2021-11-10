package es.iespuertodelacruz.adrian.instituto.modelo;

public class Mensaje {

    public enum tipoMensaje {
        SUCCESS,
        ERROR,
        WARNING,
        INFO
    }
    private String mensaje;
    private tipoMensaje tipo;



    public Mensaje(String mensaje, tipoMensaje tipo) {
        this.mensaje = mensaje;
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public tipoMensaje getTipo() {
        return tipo;
    }

    public void setTipo(tipoMensaje tipo) {
        this.tipo = tipo;
    }



}
