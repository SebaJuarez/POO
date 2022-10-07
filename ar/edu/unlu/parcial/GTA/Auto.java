package ar.edu.unlu.parcial.GTA;

public class Auto extends Propiedad{
	private String marca;
	private String patente;
	private String color;
	private int cantAsientos;
	
	public Auto(double precio, String marca, String color, int cantAsientos, String patente) {
		super(precio);
		this.cantAsientos = cantAsientos;
		this.marca = marca;
		this.color = color;
		this.patente = patente;
	}

	public String getMarca() {
		return marca;
	}
	
	public String getPatente() {
		return patente;
	}

	public String getColor() {
		return color;
	}

	public int getCantAsientos() {
		return cantAsientos;
	}
	
}
