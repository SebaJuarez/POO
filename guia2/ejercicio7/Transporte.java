package ar.edu.unlu.ejercicio7;

public class Transporte extends Proveedor {
	
	public Transporte(String nombre, double precioBase, int cantPersonaMinima) {
		super(nombre, precioBase, cantPersonaMinima);
	}

	@Override
	protected double calcularImporteExtra(int cantPersonaMaxima) {
		return this.getPrecioBase() + (this.getPrecioBase()*(cantPersonaMaxima * 0.003));
	}

}
