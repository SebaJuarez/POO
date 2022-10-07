package ar.edu.unlu.parcial.GTA;

public class Carl extends Ciudadano {

	public Carl(Ciudad ciudad) {
		super(ciudad);
	}

	@Override
	protected double calcularCapital() {
		double capital = 0;
		for(Propiedad propiedades : this.getPropiedades()) {
			capital += propiedades.getPrecio()*0.8;
		}
		return capital;
	}

	public Propiedad buscarAuto() {
		return this.getPropiedades().get((int)(Math.random()*this.getPropiedades().size()));
	}

	public Notificacion buscarAuto(Ciudadano unCiudadano) throws Exception {
		if (! unCiudadano.existeEspacio()) {
			return Notificacion.NOHAYESPACIO;
		}
		try {
			Auto auto = this.autoDisponible(unCiudadano);
			if (unCiudadano.puedeComprar(auto, 0)) {
				unCiudadano.vender(auto, 0);
				return Notificacion.COMPRASATISFECHA;
			}
		} catch (Exception e) {
			return Notificacion.NOEXISTEELAUTO;
		}
		
		return Notificacion.DINERONODISPONIBLE;
	}
	
	public Auto autoDisponible(Ciudadano ciudadanoSolicitante) throws Exception {
		// No le robemos el auto al que nos pide el auto!!!
		for ( Propiedad propiedad : this.ciudad.propiedades ) {
			if (propiedad instanceof Auto && !ciudadanoSolicitante.esTuya(propiedad)) {
				return (Auto) propiedad;
			}
		}
		throw new Exception("Auto No Disponible");
	}

	public void cobrarDinero(double monto, Auto auto) {
		this.getPropiedades().remove(auto);
	}
	
	protected void agregarPropiedad(Auto propiedad) {
		super.agregarPropiedad(propiedad);
	}
	
	public Propiedad buscarAuto(int asientos, String color, String marca) {
		for(Propiedad propiedad : this.getPropiedades()) {
			if(((Auto)propiedad).getCantAsientos() == asientos && ((Auto)propiedad).getColor().equals(color) && ((Auto)propiedad).getMarca().equals(marca)) {
				return propiedad;
			}
		}
		return null;
	}
}
