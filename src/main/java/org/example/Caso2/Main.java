package org.example.Caso2;

import java.util.List;
import java.util.Random;


public class Main {
	
	public static PlataformaVentas plataforma = new PlataformaVentas();

	public static void main(String[] args) {
		probarInsercion(100);
        probarInsercion(1000);
        probarInsercion(10000);
        probarInsercion(100000);

        probarBusqueda(100);
        probarBusqueda(1000);
        probarBusqueda(10000);
        probarBusqueda(100000);
        
        probarOrdenPorPrecio(100);
        probarOrdenPorPrecio(1000);
        probarOrdenPorPrecio(10000);
        probarOrdenPorPrecio(100000);

        probarFiltroPorCategoria(100);
        probarFiltroPorCategoria(1000);
        probarFiltroPorCategoria(10000);
        probarFiltroPorCategoria(100000);
    }

    public static void crearProductos(int cantidad) {
    	
        String[] categorias = {"Tecnología","Papelería","Hogar","Deportes"};

        Random random = new Random(123);

        for (int i = 0; i < cantidad; i++) {
            Producto producto = new Producto(
                    "P" + i,
                    "Producto " + i,
                    1000.0f + random.nextInt(999001),
                    categorias[i % categorias.length]
            );

            plataforma.insertarLinkedHashMap(producto);
        }
    }

    public static void probarInsercion(int cantidad) {

        plataforma = new PlataformaVentas();

        Runtime runtime = Runtime.getRuntime();

        System.gc();

        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long inicio = System.nanoTime();

        crearProductos(cantidad);

        long fin = System.nanoTime();

        System.gc();

        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();

        double memoriaMiB = (memoriaDespues - memoriaAntes)/ (1024.0 * 1024.0);

        System.out.println("\nINSERCIÓN - " + cantidad + " productos");

        System.out.println("Tiempo: " + (fin - inicio) + " ns");

        System.out.println("Memoria aproximada: " + memoriaMiB + " MiB");

        System.out.println("Productos registrados: " + plataforma.cantidadLinkedHashMap());
    }

    public static void probarBusqueda(int cantidad) {

        plataforma = new PlataformaVentas();

        crearProductos(cantidad);
        
        String codigoBuscado = "P10";

        long inicio = System.nanoTime();

        Producto encontrado = plataforma.buscarLinkedHashMap(codigoBuscado);

        long fin = System.nanoTime();

        System.out.println("\nBÚSQUEDA - " + cantidad + " productos");

        System.out.println("Código buscado: " + codigoBuscado);

        System.out.println("Tiempo: " + (fin - inicio) + " ns");

        System.out.println( "¿Se encontró? " + (encontrado != null));
    }
    
    public static void probarOrdenPorPrecio(int cantidad) {
        
    	plataforma = new PlataformaVentas();
        
    	crearProductos(cantidad);

        Runtime runtime = Runtime.getRuntime();
        System.gc();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long inicio = System.nanoTime();
        
        List<Producto> productosOrdenados = plataforma.mostrarPrecioConArrayList();
        
        long fin = System.nanoTime();
       
        System.gc();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();

        double memoriaMiB =
                (memoriaDespues - memoriaAntes) / (1024.0 * 1024.0);

        System.out.println("\nORDEN POR PRECIO - " + cantidad + " productos");
        System.out.println("Tiempo: " + (fin - inicio) + " ns");
        System.out.println("Memoria aproximada: " + memoriaMiB + " MiB");

    }

    public static void probarFiltroPorCategoria(int cantidad) {
        plataforma = new PlataformaVentas();
        crearProductos(cantidad);

        Runtime runtime = Runtime.getRuntime();
        System.gc();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long inicio = System.nanoTime();
        
        List<Producto> productosCategoria = plataforma.filtrarPorCategoria("Tecnología");
        
        long fin = System.nanoTime();
              
        System.gc();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();

        double memoriaMiB =
                (memoriaDespues - memoriaAntes) / (1024.0 * 1024.0);

        System.out.println("\nFILTRO POR CATEGORÍA - " + cantidad + " productos");
        System.out.println("Tiempo: " + (fin - inicio) + " ns");
        System.out.println("Memoria aproximada: " + memoriaMiB + " MiB");
    }
    
}
