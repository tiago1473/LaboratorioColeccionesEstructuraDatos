//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Random;

public class Main {

    public static PlataformaTaxis plataforma = new PlataformaTaxis();

    public static void main(String[] args) {
        probarInsercion(100);
        probarInsercion(1000);
        probarInsercion(10000);
        probarInsercion(100000);

        probarCancelacion(100);
        probarCancelacion(1000);
        probarCancelacion(10000);
        probarCancelacion(100000);
    }

    // Crea "cantidad" solicitudes con ids del 0 al cantidad-1
    public static void crearSolicitudes(int cantidad) {
        String[] lugares = {"Centro", "Norte", "Sur", "Aeropuerto", "Terminal"};
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            String id = String.valueOf(i);
            String origen = lugares[random.nextInt(lugares.length)];
            String destino = lugares[random.nextInt(lugares.length)];
            plataforma.registrarSolicitud(new Solicitud(id, "Usuario" + i, origen, destino));
        }
    }

    public static void probarInsercion(int cantidad) {
        plataforma = new PlataformaTaxis();

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long inicio = System.nanoTime();
        crearSolicitudes(cantidad);
        long fin = System.nanoTime();

        runtime.gc();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDespues - memoriaAntes;
        double memoriaMB = memoriaUsada / (1024.0 * 1024.0);

        System.out.println(cantidad + " solicitudes tardan: " + (fin - inicio) + " ns en registrarse");
        System.out.println("En " + cantidad + " solicitudes se usan: " + memoriaMB + " MB de memoria para registrarse");
    }

    // Mide cancelar (buscar + eliminar) una solicitud específica por id
    public static void probarCancelacion(int cantidad) {
        plataforma = new PlataformaTaxis();
        // Primero se crean todas las solicitudes; ese tiempo no se mide, se asume que ya existen
        crearSolicitudes(cantidad);

        // Se elige un id aleatorio dentro del rango, no siempre el último ni el primero
        Random random = new Random();
        String idBuscado = String.valueOf(random.nextInt(cantidad));

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long inicio = System.nanoTime();
        Solicitud cancelada = plataforma.cancelarSolicitud(idBuscado);
        long fin = System.nanoTime();

        runtime.gc();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDespues - memoriaAntes;
        double memoriaMB = memoriaUsada / (1024.0 * 1024.0);

        System.out.println(cantidad + " solicitudes tardan: " + (fin - inicio) + " ns en cancelar una solicitud");
        System.out.println("En " + cantidad + " solicitudes se usan: " + memoriaMB + " MB de memoria para cancelar una solicitud");
    }
}
