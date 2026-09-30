package org.example.Caso4.Opcion1;
import java.util.ArrayList;
import java.util.Comparator;

public class GestionEcommerce {

    private ArrayList<Producto> productos;

    public GestionEcommerce() {
        this.productos = new ArrayList<>();
    }

    public boolean agregarProducto(Producto producto) {
        Producto productoHallado = buscarPorCodigo(producto.getCodigo());
        if (productoHallado == null) {
            productos.add(producto);
            return true;
        }
        return false;
    }

    public Producto buscarPorCodigo(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public void ordenarPorPrecio() {
        productos.sort(new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return Double.compare(p1.getPrecio(), p2.getPrecio()
                );
            }
        });
    }

    public void mostrarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}