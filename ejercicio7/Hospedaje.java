package ar.edu.unlu.ejercicio7;

public class Hospedaje extends Proveedor {

	public Hospedaje(String nombre, double precioBase, int cantPersonaMinima) {
		super(nombre, precioBase, cantPersonaMinima);
	}

	@Override
    protected double calcularImporteExtra(int cantPersonaMaxima) {
        if (cantPersonaMaxima > this.getCantPersonaMinima()) {
            return this.getPrecioBase() - (this.getPrecioBase() * ((cantPersonaMaxima - this.getCantPersonaMinima()) * 0.005));
        } else {
            return this.getPrecioBase();
        }
    }

}
