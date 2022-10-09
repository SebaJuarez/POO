package ar.edu.unlu.ejercicio7;

import java.util.LinkedList;

import ar.edu.unlu.ejercicio7.Venta;

public class Cliente {
	private String nombre;
	private LinkedList<Venta> compras = new LinkedList<Venta>();
	
	
	public Cliente(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarCompra(Venta compra) {
		this.getCompras().add(compra);
	}

	public String getNombre() {
		return nombre;
	}

	public LinkedList<Venta> getCompras() {
		return compras;
	}
		
}
