package ar.edu.unlu.parcial.GTA;

import java.util.LinkedList;

public class Handy {
	private static LinkedList<String> patentesAutosRobados = new LinkedList<String>();
	public void declararRobado(String patente) {
		this.getPatentesAutosRobados().add(patente);
	}
	public LinkedList<String> getPatentesAutosRobados() {
		return patentesAutosRobados;
	}
	public boolean estaRobado(String patente){
		return this.getPatentesAutosRobados().contains(patente);
	}
	
}
