package ar.edu.unlu.parcial.GTA;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Ciudadano {
	
	private double efectivo = 0;
	LinkedList<Propiedad> propiedades = new LinkedList<Propiedad>();
	Ciudad ciudad;

	public Ciudadano(Ciudad ciudad) {
		this.ciudad = ciudad ;
	}

	protected double pagar(double monto){
		this.efectivo -= monto;
		return monto;
	}
	
	protected void cobrarDinero(double monto) {
		this.efectivo += monto;
	}
	
	public double getEfectivo() {
		return this.efectivo;
	}
	
	protected LinkedList<Propiedad> getPropiedades(){
		return this.propiedades;
	}
	
	protected void agregarPropiedad(Propiedad propiedad) {
		propiedades.add(propiedad);
	}

	public boolean existeEspacio() {
		return true;
	}

	public boolean esTuya(Propiedad unaPropiedad) {
		return this.propiedades.contains(unaPropiedad);
	}

	public boolean puedeComprar(Propiedad unaPropiedad, double comision) {
		return this.efectivo >= unaPropiedad.getPrecio() + comision;
	}

	public double vender(Propiedad unaPropiedad, double comision) {
		this.agregarPropiedad(unaPropiedad);
		return this.pagar(unaPropiedad.getPrecio() + comision);
	}

	public ArrayList<Inmueble> getInmuebles() {
		ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();
		for (Propiedad propiedad : this.propiedades ) {
			if (propiedad instanceof Inmueble) {
				inmuebles.add((Inmueble) propiedad);
			}
		}
		return inmuebles;
	}
	
	protected  abstract double calcularCapital();
	
	
	
}
