package org.example.Caso2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class PlataformaVentas {

    private final LinkedList<Producto> productosLinkedList;
    private final LinkedHashMap<String, Producto> productosLinkedHashMap;

    private final HashMap<String, ArrayList<Producto>> productosPorCategoria;

    public PlataformaVentas() {
    	
    	//PARA REGISTRO Y BUSQUEDA
        productosLinkedList = new LinkedList<>();
        productosLinkedHashMap = new LinkedHashMap<>();
        
        //AGRUPACIÓN POR CATEGORÍA
        productosPorCategoria = new HashMap<>();
    }
    
    //INSERTAR PRODUCTO

    public void insertarLinkedList(Producto producto) {
        productosLinkedList.addFirst(producto);
        agregarPorCategoria(producto);
    }

    public void insertarLinkedHashMap(Producto producto) {
        productosLinkedHashMap.putFirst(producto.getCodigo(), producto);
        agregarPorCategoria(producto);
    }
    
    
    //BUSCAR PRODUCTO

    public Producto buscarLinkedList(String codigo) {
        for (Producto producto : productosLinkedList) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public Producto buscarLinkedHashMap(String codigo) {
        return productosLinkedHashMap.get(codigo);
    }

    
    //MOSTRAR ORDENADO POR PRECIO

    public List<Producto> mostrarPrecioConArrayList() {

        List<Producto> ordenados = new ArrayList<>(productosLinkedHashMap.values());

        Collections.sort(ordenados);
        
        return ordenados;
        
    }

    public TreeSet<Producto> mostrarPrecioConTreeSet() {

        TreeSet<Producto> ordenados =
                new TreeSet<>(productosLinkedList);
        
        return ordenados;
    }
    
    
    // AGRUPAR Y MOSTRAR POR CATEGORIA
    
    public void agregarPorCategoria(Producto producto) {

        String categoria = producto.getCategoria();

        if (!productosPorCategoria.containsKey(categoria)) {
            productosPorCategoria.put(categoria, new ArrayList<>());
        }
        productosPorCategoria.get(categoria).add(producto);
    }

    public List<Producto> filtrarPorCategoria(String categoria) {
    	return productosPorCategoria.getOrDefault(categoria, new ArrayList<>());
    }
    
    public int cantidadLinkedHashMap() {
        return productosLinkedHashMap.size();
    }
    
    public int cantidadLinkedList() {
        return productosLinkedList.size();
    }
}