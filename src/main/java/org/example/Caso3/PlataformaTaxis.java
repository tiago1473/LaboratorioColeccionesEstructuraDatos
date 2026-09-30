import java.util.LinkedHashMap;

public class PlataformaTaxis {
    private LinkedHashMap<String,Solicitud> solicitudes;

    public PlataformaTaxis(){
        this.solicitudes = new LinkedHashMap<>();
    }

    //  Registrar solicitud
    public boolean registrarSolicitud(Solicitud solicitud){
        if(solicitudes.containsKey(solicitud.getId())){
            return false;
        }
        solicitudes.put(solicitud.getId(),solicitud);
        return true;
    }

    // Cancelar solicitud
    public Solicitud cancelarSolicitud(String idSolicitud){
        return solicitudes.remove(idSolicitud);
    }

    // Atender solicitud desde la mas antigua
    public Solicitud cancelarSolicitud(Solicitud solicitud){
       if(solicitudes.isEmpty()){
           return null;
       }
       String primerClave = solicitudes.keySet().iterator().next();
       return solicitudes.remove(primerClave);
    }

    // Mostrar solicitudes pendientes
    public void mostrarSolicitudes(){
        for(Solicitud s: solicitudes.values()){
            System.out.println(s);
        }
    }

    // Para verificar la cantidad de solicitudes en las pruebas
    public int cantidadPendientes() {
        return solicitudes.size();
    }
}
