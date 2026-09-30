package org.example.Caso4.Opcion2;

public class Main {

    public static GestionEcommerce gestion = new GestionEcommerce();

    public static void main(String[] args) {

        probarInsercion(100);
        probarInsercion(1000);
        probarInsercion(10000);
        probarInsercion(100000);

        probarBusqueda(100);
        probarBusqueda(1000);
        probarBusqueda(10000);
        probarBusqueda(100000);

        probarOrdenamiento(100);
        probarOrdenamiento(1000);
        probarOrdenamiento(10000);
        probarOrdenamiento(100000);
    }

    public static void crearProductos(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            String codigo = String.valueOf(i);
            Producto producto = new Producto(codigo, "Producto " + i, 1000 + i);
            gestion.agregarProducto(producto);
        }
    }

    public static void probarInsercion(int cantidad) {

        gestion = new GestionEcommerce();
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        long inicio = System.nanoTime();

        crearProductos(cantidad);

        long fin = System.nanoTime();
        runtime.gc();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDespues - memoriaAntes;
        double memoriaMB = memoriaUsada / (1024.0 * 1024.0);
        System.out.println(cantidad + " productos tardan: " + (fin - inicio) + " ns en registrarse");
        System.out.println("En " + cantidad + " productos se usan: " + memoriaMB + " MB de memoria para registrarse");
    }

    public static void probarBusqueda(int cantidad) {

        gestion = new GestionEcommerce();
        // Primero creamos todos los productos.Este tiempo NO se mide.
        crearProductos(cantidad);
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        long inicio = System.nanoTime();

        // Buscamos el último producto
        Producto producto = gestion.buscarPorCodigo(String.valueOf(cantidad - 1));

        long fin = System.nanoTime();
        runtime.gc();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDespues - memoriaAntes;
        double memoriaMB = memoriaUsada / (1024.0 * 1024.0);
        System.out.println(cantidad + " productos tardan: " + (fin - inicio) + " ns en buscar el producto");
        System.out.println("En " + cantidad + " productos se usan: " + memoriaMB + " MB de memoria para buscar un producto");
    }

    public static void probarOrdenamiento(int cantidad) {
        gestion = new GestionEcommerce();
        // Primero creamos todos los productos. Este tiempo NO se mide.
        crearProductos(cantidad);
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        long inicio = System.nanoTime();
        gestion.ordenarPorPrecio();
        long fin = System.nanoTime();
        runtime.gc();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDespues - memoriaAntes;
        double memoriaMB = memoriaUsada / (1024.0 * 1024.0);
        System.out.println(cantidad + " productos tardan: " + (fin - inicio) + " ns en ordenarse por precio");
        System.out.println("En " + cantidad + " productos se usan: " + memoriaMB + " MB de memoria para ordenar");
    }
}