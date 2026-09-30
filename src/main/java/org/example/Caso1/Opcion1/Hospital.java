package org.example.Caso1.Opcion1;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class Hospital {

    private LinkedHashMap<String, Paciente> pacientes;
    private PriorityQueue<Paciente> colaPrioridad;

    public Hospital() {
        this.pacientes = new LinkedHashMap<>();
        this.colaPrioridad = new PriorityQueue<>();
    }

    public boolean registrarPaciente(Paciente paciente) {
        if (pacientes.containsKey(paciente.getId())) {
            return false;
        }
        pacientes.put(paciente.getId(), paciente);
        colaPrioridad.add(paciente);
        return true;
    }

    public Paciente buscarPaciente(String id) {
        return pacientes.get(id);
    }

    public void mostrarPacientes() {
        for (Paciente paciente : this.pacientes.values()) {
            System.out.println(paciente);
        }
    }

    public Paciente siguientePaciente() {
        return colaPrioridad.peek();
    }

    public Paciente atenderPaciente() {
        //Obtengo y elimino al paciente de la cola de prioridad
        Paciente paciente = colaPrioridad.poll();
        if (paciente != null) {
            //Si lo encuentro, lo elimino además del mapa de pacientes
            pacientes.remove(paciente.getId());
        }
        return paciente;
    }
}
