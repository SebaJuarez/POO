package ar.edu.unlu.ejercicio7;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		Agencia agencia = new Agencia("");
		Proveedor hospedaje = new Hospedaje("Hotel 1",1000.0,10);
		Proveedor transporte = new Transporte("La isleña 1",100.0,10);
		Proveedor guiaTuristico = new GuiaTuristico("Jose",10.0,10);
		PaqueteDeTurismo p = new PaqueteDeTurismo("cancun", 20, ((Hospedaje)hospedaje), ((GuiaTuristico)guiaTuristico), ((Transporte)transporte));
		agencia.agregarProveedor(guiaTuristico);
		agencia.agregarProveedor(transporte);
		agencia.agregarProveedor(guiaTuristico);
		agencia.agregarPaqueteTurismo(p);
		
		
		Cliente c1 = new Cliente("Sebastian");
		Cliente c2 = new Cliente("Matias");
		Cliente c3 = new Cliente("Walter");
		Cliente c4 = new Cliente("Cherencio");
		
		agencia.realizarVenta(c1, p);
		agencia.realizarVenta(c2, p);
		agencia.realizarVenta(c3, p);

		System.out.println("Precio proveedor hospedaje "+ hospedaje.calcularImporteExtra(p.getCantPersonaMaxima()));
		System.out.println("Precio proveedor transporte "+transporte.calcularImporteExtra(p.getCantPersonaMaxima()));
		System.out.println("Precio proveedor guia turistico "+guiaTuristico.calcularImporteExtra(p.getCantPersonaMaxima()));
		
		System.out.println("precio fianl del paquete :" +p.calcularPrecioFinal());
		
		LinkedList<Venta> ventas = agencia.getVentas();
		
		for(Venta v: ventas) {
			System.out.println("Cliente: "+ v.getCliente().getNombre()+ " Fecha: "+ v.getFechaVenta()+ " Precio: "+ v.getPrecio());
		}
		
		Informe informe = new Informe(agencia);
		
		System.out.println("destino favorito: "+informe.realizarInformeDestinoFavorito());
		ventas = informe.realizarInformeVentas();
		
		for(Venta v: ventas) {
			System.out.println("Cliente: "+ v.getCliente().getNombre()+ " Fecha: "+ v.getFechaVenta()+ " Precio: "+ v.getPrecio());
		}
		
		LinkedList<Proveedor> proveedores = informe.realizarInformeProveedores();
		for(Proveedor pr: proveedores) {
			System.out.println("Nombre: "+ pr.getNombre() );
		}
		
		Proveedor hospedaje1 = new Hospedaje("Hotel 2",500.0,10);
		Proveedor transporte1 = new Transporte("El 57",150.0,10);
		Proveedor guiaTuristico1 = new GuiaTuristico("Pepe",15.0,10);
		agencia.agregarProveedor(guiaTuristico1);
		agencia.agregarProveedor(transporte1);
		agencia.agregarProveedor(guiaTuristico1);
		PaqueteDeTurismo p2 = new PaqueteDeTurismo("UNLu", 10, ((Hospedaje)hospedaje1), ((GuiaTuristico)guiaTuristico1), ((Transporte)transporte1));
		agencia.agregarPaqueteTurismo(p2);
		System.out.println("Precio proveedor hospedaje2 "+ hospedaje1.calcularImporteExtra(p2.getCantPersonaMaxima()));
		System.out.println("Precio proveedor transporte2 "+transporte1.calcularImporteExtra(p2.getCantPersonaMaxima()));
		System.out.println("Precio proveedor guia turistico2 "+guiaTuristico1.calcularImporteExtra(p2.getCantPersonaMaxima()));
		agencia.realizarVenta(c1, p2);
		agencia.realizarVenta(c2, p2);
		agencia.realizarVenta(c3, p2);
		agencia.realizarVenta(c4, p2);
		System.out.println("precio fianl del paquete2 :" +p2.calcularPrecioFinal());
		ventas = informe.realizarInformeVentas();
		for(Venta v: ventas) {
			System.out.println("Cliente: "+ v.getCliente().getNombre()+ " Fecha: "+ v.getFechaVenta()+ " Precio: "+ v.getPrecio());
		}
		
		System.out.println("destino favorito: "+informe.realizarInformeDestinoFavorito());
		ventas = informe.realizarInformeVentas();
		
		for(Venta v: ventas) {
			System.out.println("Cliente: "+ v.getCliente().getNombre()+ " Fecha: "+ v.getFechaVenta()+ " Precio: "+ v.getPrecio());
		}
	
		for(Proveedor pr: proveedores) {
			System.out.println("Nombre: "+ pr.getNombre() );
		}
	
	}

}
