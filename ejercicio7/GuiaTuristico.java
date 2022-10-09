package ar.edu.unlu.ejercicio7;

public class GuiaTuristico extends Proveedor {

	public GuiaTuristico(String nombre, double precioBase, int cantPersonaMinima) {
		super(nombre, precioBase, cantPersonaMinima);
	}

	@Override
	protected double calcularImporteExtra(int cantPersonaMaxima) {
		if(cantPersonaMaxima > 200) return this.getPrecioBase() + 90;
		return this.getPrecioBase();
	}

}
