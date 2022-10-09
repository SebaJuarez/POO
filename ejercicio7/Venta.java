package ar.edu.unlu.ejercicio7;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Venta {
	
	private PaqueteDeTurismo  paquete;
	private Cliente cliente;
	private LocalDate fechaVenta;
	private double precio;
	private String destino;
	
	public Venta(PaqueteDeTurismo paquete, Cliente cliente, String fechaVenta) {
		this.paquete = paquete;
		this.cliente = cliente;
		this.fechaVenta = (LocalDate.parse(fechaVenta, DateTimeFormatter.ofPattern("dd-MM-yyyy") ));
		this.precio = paquete.calcularPrecioFinal();
		this.destino = paquete.getDestino();
	}

	public PaqueteDeTurismo getPaquete() {
		return paquete;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public double getPrecio() {
		return precio;
	}

	public String getDestino() {
		return destino;
	}
	
}
