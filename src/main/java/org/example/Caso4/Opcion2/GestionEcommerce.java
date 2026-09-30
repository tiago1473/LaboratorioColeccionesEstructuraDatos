package org.example.Caso4.Opcion2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class GestionEcommerce {

    private HashMap<String, Producto> productos;

    public GestionEcommerce() {
        this.productos = new HashMap<>();
    }

    public boolean agregarProducto(Producto producto) {
        if(this.productos.containsKey(producto.getNombre())) {
            return false;
        }
        productos.put(producto.getCodigo(), producto);
        return true;
    }

    public Producto buscarPorCodigo(String codigo) {
        return productos.get(codigo);
    }

    public void ordenarPorPrecio() {

        //Desde los mapas no puedo ordenar directamente, por lo que los paso a un ArrayList
        ArrayList<Producto> lista = new ArrayList<>(productos.values());

        lista.sort(new Comparator<Producto>() {

            @Override
            public int compare(Producto p1, Producto p2) {
                return Double.compare(p1.getPrecio(), p2.getPrecio());
            }
        });

    }

    public void mostrarProductos() {
        for (Producto producto : productos.values()) {
            System.out.println(producto);
        }
    }
}