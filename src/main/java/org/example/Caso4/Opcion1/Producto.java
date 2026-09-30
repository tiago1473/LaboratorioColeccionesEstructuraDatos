package org.example.Caso4.Opcion1;

public class Producto {

    private String codigo;
    private String nombre;
    private double precio;

    public Producto(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Código: " + this.codigo + "\n" +
                "Nombre: " + this.nombre + "\n" +
                "Precio: $" + this.precio;
    }
}