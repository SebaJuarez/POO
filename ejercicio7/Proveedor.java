package ar.edu.unlu.ejercicio7;

public abstract class Proveedor {
	
	private String nombre;
	private double precioBase;
	private int cantPersonaMinima;
	
	public Proveedor(String nombre, double precioBase, int cantPersonaMinima) {
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.cantPersonaMinima = cantPersonaMinima;
	}
	
	protected abstract double calcularImporteExtra(int cantPersonaMaxima);

	public String getNombre() {
		return nombre;
	}

	public double getPrecioBase() {
		return precioBase;
	}


	public int getCantPersonaMinima() {
		return cantPersonaMinima;
	}
	
}
