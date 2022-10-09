package ar.edu.unlu.ejercicio7;
import java.util.Comparator;
import java.util.LinkedList;

public class Informe {
	private Agencia agencia;

	public Informe(Agencia agencia) {
		super();
		this.agencia = agencia;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	
	public LinkedList<Proveedor> realizarInformeProveedores(){
		LinkedList<Proveedor> proveedores = new LinkedList<Proveedor>();
		proveedores.addAll(this.getAgencia().getProveedorGuia());
		proveedores.addAll(this.getAgencia().getProveedorHospedaje());
		proveedores.addAll(this.getAgencia().getProveedorTransporte());
		return proveedores;
	}
	
	public LinkedList<Venta> realizarInformeVentas() {	
	 LinkedList<Venta> ventas =  this.getAgencia().getVentas();
	 ventas.sort(Comparator.comparing(Venta :: getDestino));
	 return ventas;
	}
	
	public String realizarInformeDestinoFavorito() {	
		LinkedList<String> destinos = new LinkedList<> ();
		destinos = crearLista(this.getAgencia().getVentas());
		return buscarDestinoFavorito(destinos);
	}

	private String buscarDestinoFavorito(LinkedList<String> destinos) {
		int[] vectorDestinos = new int[destinos.size()];
		int posicion = 0;
		for(Venta d : this.getAgencia().getVentas()) {
			posicion = destinos.indexOf(d.getDestino());
			vectorDestinos[posicion] ++;
		}
		int mayor = 0;
		for(int i = 0; i < vectorDestinos.length;i++) {
			if(vectorDestinos[i] > vectorDestinos[mayor]) {
				mayor = i;
			}
		}
		return destinos.get(mayor);
	}

	private LinkedList<String> crearLista(LinkedList<Venta> ventas) {
		LinkedList<String> destinos = new LinkedList<> ();
		for(Venta v : ventas) {
			if(!destinos.contains(v.getDestino())) {
				destinos.add(v.getDestino());				
			}
		}
		return destinos;
	}
	
}
