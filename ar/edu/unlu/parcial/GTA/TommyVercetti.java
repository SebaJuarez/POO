package ar.edu.unlu.parcial.GTA;

import java.util.LinkedList;

public class TommyVercetti extends Ciudadano {
	
	public TommyVercetti(Ciudad ciudad) {
		super(ciudad);
	}

	private Handy handyPolicial ;

	public void setHandy(Handy handy) {
		this.handyPolicial = handy;
	}

	/*public Notificacion solicitarAuto(Carl carl) {
		Auto auto = (Auto)carl.buscarAuto();
		Inmueble inmueble = this.existeEspacio();
		if(inmueble == null) return Notificacion.NOHAYESPACIO;
		if(auto == null) return Notificacion.NOEXISTEELAUTO;
		if(auto.getPrecio() <= this.getEfectivo()) {
			carl.cobrarDinero(this.pagar(auto.getPrecio()),auto);
			inmueble.guardarAuto(auto);
			return Notificacion.COMPRASATISFECHA;
		} else return Notificacion.DINERONODISPONIBLE;
	}*/
	
	/*public Notificacion solicitarAuto(Carl carl, int asientos, String color, String marca) {
		Auto auto = (Auto)carl.buscarAuto(asientos, color, marca);
		//Inmueble inmueble = this.existeEspacio();
		//if(inmueble == null) return Notificacion.NOHAYESPACIO;
		if(auto == null) return Notificacion.NOEXISTEELAUTO;
		if (auto.getPrecio() <= this.getEfectivo()+200) {
			carl.cobrarDinero(this.pagar(auto.getPrecio()+200), auto);
			inmueble.guardarAuto(auto);
			return Notificacion.COMPRASATISFECHA;
		} else return Notificacion.NOEXISTEELAUTO;
	}*/
	
	
	public Notificacion comprarInmueble(Propiedad inmueble) {
		if ( ! (inmueble instanceof Inmueble)) return Notificacion.ERROR;
		if(inmueble.getPrecio() <= this.getEfectivo()) {
			this.agregarPropiedad(inmueble);
			this.pagar(inmueble.getPrecio());
			return Notificacion.COMPRASATISFECHA;
		} else return Notificacion.DINERONODISPONIBLE;
	}
	
	public boolean existeEspacio() {
		for(Inmueble inmueble : this.getInmuebles()) {
			if (inmueble.hayLugar()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	protected double calcularCapital() {
		double capital = this.getEfectivo();
		LinkedList<Auto> autos;
		for(Propiedad propiedad : this.getPropiedades()) {
			capital += propiedad.getPrecio()*0.95;
			autos = ((Inmueble)propiedad).getAutos();
			for(Auto auto : autos) {
				if(this.handyPolicial.estaRobado(auto.getPatente())) {
					capital += auto.getPrecio()* 0.1;
				} else capital += auto.getPrecio()*0.8;
			}
		}
		return capital;
	}

}
