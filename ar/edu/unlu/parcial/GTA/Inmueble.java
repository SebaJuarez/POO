package ar.edu.unlu.parcial.GTA;

import java.util.LinkedList;

public class Inmueble extends Propiedad {

	LinkedList<Auto> autos = new LinkedList<Auto>();
	private int capacidadGaraje;
	
	
	public Inmueble(double precio,int capacidadGarage) {
		super(precio);
		this.capacidadGaraje = capacidadGarage;
	}
	
	public LinkedList<Auto> getAutos(){
		return this.autos;
	}
	
	public boolean hayLugar(){
		return ((this.capacidadGaraje - this.autos.size()) > 0);
	}
	
	public Notificacion guardarAuto(Auto auto) {
		if(this.hayLugar()) {
			this.autos.add(auto);
			return Notificacion.GUARDADO;
		} else return Notificacion.NOHAYESPACIO;
	}

}
