package org.example.Caso1.Opcion1;
import java.time.LocalDateTime;

public class Paciente implements Comparable<Paciente> {

    private String id;
    private String nombre;
    private int prioridad;
    private LocalDateTime horaIngreso;

    public Paciente(String id, String nombre, int prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.horaIngreso = LocalDateTime.now();
    }

    //Prioridad significa: 1 = crítico. 2 = grave. 3 = moderado. 4 = leve
    //También se pudo manejar un ENUM

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDateTime getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(LocalDateTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    @Override
    public String toString() {
        return "-------- Paciente -------- " + "\n" +
                "Id: " + this.id + "\n" +
                "Nombre: " + this.nombre + "\n" +
                "Hora Ingreso: " + this.horaIngreso + "\n" +
                "Prioridad: " + this.prioridad;
    }

    //Si da negativo, "this" es menor (crítico) y tiene mayor prioridad que es lo que busco
    @Override
    public int compareTo(Paciente o) {
        return this.prioridad - o.prioridad;
    }
}
