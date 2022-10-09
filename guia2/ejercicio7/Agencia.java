package ar.edu.unlu.ejercicio7;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class Agencia {
	private String nombre;
	private LinkedList<Venta> ventas = new LinkedList<Venta>();
	private LinkedList<Cliente> clientes = new LinkedList<Cliente>();
	private LinkedList<Proveedor> proveedorHospedaje = new LinkedList<Proveedor>();
	private LinkedList<Proveedor> proveedorGuia = new LinkedList<Proveedor>();
	private LinkedList<Proveedor> proveedorTransporte = new LinkedList<Proveedor>();
	private LinkedList<PaqueteDeTurismo> paquetes = new LinkedList<PaqueteDeTurismo>();
	
	
	public Agencia(String nombre) {
		this.nombre = nombre;
	}
	
	public void realizarVenta(Cliente cliente, PaqueteDeTurismo paquete) {
		Venta venta = new Venta(paquete, cliente, LocalDate.now().format( DateTimeFormatter.ofPattern("dd-MM-yyyy")).toString());
		this.getVentas().add(venta);
		paquete.agregarPasajero(cliente);
		cliente.agregarCompra(venta);
		if(!this.getClientes().contains(cliente)) {
			this.getClientes().add(cliente);
		}
	}
	
	public void agregarPaqueteTurismo(PaqueteDeTurismo paquete) {
		if(!this.getPaquetes().contains(paquete)) {
			this.getPaquetes().add(paquete);
		}
	}
	
	public void agregarProveedor(Proveedor proveedor) {
		if(proveedor instanceof Hospedaje) {
			if(!this.getProveedorHospedaje().contains(proveedor)) this.getProveedorHospedaje().add(proveedor);
		} else if( proveedor instanceof GuiaTuristico) {
			if(!this.getProveedorGuia().contains(proveedor)) this.getProveedorGuia().add(proveedor);
		} else if( proveedor instanceof Transporte) {
			if(!this.getProveedorTransporte().contains(proveedor)) this.getProveedorTransporte().add(proveedor);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public LinkedList<Venta> getVentas() {
		return ventas;
	}

	public LinkedList<Cliente> getClientes() {
		return clientes;
	}


	public LinkedList<PaqueteDeTurismo> getPaquetes() {
		return paquetes;
	}

	public LinkedList<Proveedor> getProveedorHospedaje() {
		return proveedorHospedaje;
	}

	public LinkedList<Proveedor> getProveedorGuia() {
		return proveedorGuia;
	}

	public LinkedList<Proveedor> getProveedorTransporte() {
		return proveedorTransporte;
	}


}
