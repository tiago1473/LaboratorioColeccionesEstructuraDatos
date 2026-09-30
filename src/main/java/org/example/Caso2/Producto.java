package org.example.Caso2;

import java.util.Objects;

public class Producto implements Comparable<Producto>{
	
	private final String codigo;
    private final String nombre;
    private final float precio;
    private final String categoria;
    
    public Producto (String codigo, String nombre, float precio, String categoria) {
    	this.codigo=codigo;
    	this.nombre=nombre;
    	this.precio=precio;
    	this.categoria=categoria;
    }

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public String getCategoria() {
		return categoria;
	}
	
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria + "]";
	}

	@Override
	public int compareTo(Producto otro) {
		int resultado = Float.compare(this.precio, otro.precio);
		
		if (resultado !=0) {
			return resultado;
		}
		
		return this.codigo.compareTo(otro.codigo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(codigo, other.codigo);
	}
}
