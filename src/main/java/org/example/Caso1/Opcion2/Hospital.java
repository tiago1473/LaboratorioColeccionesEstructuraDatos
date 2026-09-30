package org.example.Caso1.Opcion2;

import java.util.LinkedHashSet;
import java.util.PriorityQueue;

public class Hospital {

    private LinkedHashSet<Paciente> pacientes;
    private PriorityQueue<Paciente> colaPrioridad;

    public Hospital() {
        this.pacientes = new LinkedHashSet<>();
        this.colaPrioridad = new PriorityQueue<>();
    }

    public boolean registrarPaciente(Paciente paciente) {
        if (!pacientes.add(paciente)) {
            return false;
        }
        colaPrioridad.add(paciente);
        return true;
    }

    public Paciente buscarPaciente(String id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId().equals(id)) {
                return paciente;
            }
        }
        return null;
    }

    public void mostrarPacientes() {
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }

    public Paciente siguientePaciente() {
        return colaPrioridad.peek();
    }

    public Paciente atenderPaciente() {
        Paciente paciente = colaPrioridad.poll();
        if (paciente != null) {
            pacientes.remove(paciente);
        }
        return paciente;
    }
}