package ar.edu.unlu.ejercicio7;

import java.util.LinkedList;

public class PaqueteDeTurismo {
	private String destino;
	private static String idPaquete;
	private int cantPersonaMaxima;
	private LinkedList<Proveedor> proovedores = new LinkedList<Proveedor>();
	private LinkedList<Cliente> clientes = new LinkedList<Cliente>();
	
	public PaqueteDeTurismo(String destino, int cantPersonaMaxima, Hospedaje hospedaje,GuiaTuristico guia,Transporte transporte) {
		this.destino = destino;
		this.cantPersonaMaxima = cantPersonaMaxima;
		this.proovedores.add(hospedaje);
		this.proovedores.add(guia);
		this.proovedores.add(transporte);
	}
	
	public void agregarPasajero(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public double calcularPrecioFinal() {
		double precio = 0.0;
		for(Proveedor p : this.getProovedores()) {
			precio += p.calcularImporteExtra(this.getCantPersonaMaxima());
		}
		return precio;
	}
	
	public String getDestino() {
		return destino;
	}

	public static String getIdPaquete() {
		return idPaquete;
	}

	public int getCantPersonaMaxima() {
		return cantPersonaMaxima;
	}

	public LinkedList<Proveedor> getProovedores() {
		return proovedores;
	}

	public LinkedList<Cliente> getClientes() {
		return clientes;
	}
	
}
