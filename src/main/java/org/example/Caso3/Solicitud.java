import java.time.LocalDateTime;

public class Solicitud {
    private String usuario;
    private String id;
    private String origen;
    private String destino;
    private LocalDateTime horaSolicitud;

    public Solicitud(String usuario, String id, String origen, String destino) {
        this.usuario = usuario;
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.horaSolicitud = LocalDateTime.now();

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime getHoraSolicitud() {
        return horaSolicitud;
    }

    public void setHoraSolicitud(LocalDateTime horaSolicitud) {
        this.horaSolicitud = horaSolicitud;
    }

    @Override
    public String toString() {
        return "Solicitud" + "\n" +
                "Id: " + this.id + "\n" +
                "Usuario: " + this.usuario + "\n" +
                "Origen: " + this.origen + "\n" +
                "Destino: " + this.destino + "\n" +
                "Hora Solicitud: " + this.horaSolicitud;

    }
}
