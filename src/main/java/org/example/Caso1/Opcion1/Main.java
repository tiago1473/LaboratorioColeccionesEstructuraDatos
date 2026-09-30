package org.example.Caso1.Opcion1;
import java.util.Random;

public class Main {
    public static Hospital hospital = new Hospital();

    public static void main(String[] args) {
        probarInsercion(100);
        probarInsercion(1000);
        probarInsercion(10000);
        probarInsercion(100000);
        probarBusqueda(100);
        probarBusqueda(1000);
        probarBusqueda(10000);
        probarBusqueda(100000);
    }

    public static void crearPacientes(int cantidad){
        Random random = new Random();
        //Creación de Pacientes
        for (int i = 0; i < cantidad; i++) {
            String id = String.valueOf(i);
            int numero = random.nextInt(4) + 1;
            hospital.registrarPaciente(new Paciente(id,"Paciente " + i, numero));
        }

    }

    public static void probarInsercion(int cantidad) {
        hospital = new Hospital();
        //Información sobre el entorno en el que se ejecuta mi programa
        Runtime runtime = Runtime.getRuntime();
        //Liberar memoria que ya no se esté utilizando
        runtime.gc();
        //Obtenemos cantidad de memoria antes de la ejecución
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        //Variable para medir tiempo de ejecución (Inicio)
        long inicio = System.nanoTime();
        crearPacientes(cantidad);
        //Variable para medir tiempo de ejecución (Fin)
        long fin = System.nanoTime();
        runtime.gc();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDespues - memoriaAntes;
        double memoriaMB = memoriaUsada / (1024.0 * 1024.0);
        System.out.println(cantidad + " pacientes tardan: " + (fin-inicio) + " ns en registrarse");
        System.out.println("En" + cantidad + " pacientes se usan: " + (memoriaMB) + " MB de memoria para registrarse");
    }

    public static void probarBusqueda(int cantidad) {
        hospital = new Hospital();
        //Primero creamos a todos los pacientes, ese tiempo no se mide porque se supone que ya están
        crearPacientes(cantidad);
        //Información sobre el entorno en el que se ejecuta mi programa
        Runtime runtime = Runtime.getRuntime();
        //Liberar memoria que ya no se esté utilizando
        runtime.gc();
        //Obtenemos cantidad de memoria antes de la ejecución
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        //Variable para medir tiempo de ejecución (Inicio)
        long inicio = System.nanoTime();
        Paciente paciente = hospital.buscarPaciente(String.valueOf(cantidad - 1)); //El último
        //Variable para medir tiempo de ejecución (Fin)
        long fin = System.nanoTime();
        runtime.gc();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDespues - memoriaAntes;
        double memoriaMB = memoriaUsada / (1024.0 * 1024.0);
        System.out.println(cantidad + " pacientes tardan: " + (fin-inicio) + " ns en buscar al paciente");
        System.out.println("En" + cantidad + " pacientes se usan: " + (memoriaMB) + " MB de memoria para buscar a un paciente");
    }
}