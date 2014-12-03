package algo3.algocity.model;

public class Usuario {

	private String nombre;
	private String ruta;

	public Usuario(String unNombre) {

		this.nombre = unNombre;
		this.ruta = "";
	}

	public void nombre(String nuevoNombre) {
		nombre = nuevoNombre;
	}

	public String nombre() {
		return nombre;
	}

	public void ruta(String ruta) {
		this.ruta = ruta;
	}

	public String ruta() {
		return ruta;
	}

	/*
	 * 
	 * public String getRutaJuegoAsociado(){ return rutaJuegoAsociado; }
	 * 
	 * 
	 * 
	 * 
	 * public void jugar(String nombrePersonaje){ Iterator<Personaje> it =
	 * personajes.iterator(); boolean encontrado = false; Personaje
	 * personajeEnJuego = null;
	 * 
	 * while(it.hasNext() && !encontrado){ Personaje unPersonaje = it.next();
	 * if(unPersonaje.getNombrePersonaje() == nombrePersonaje){ encontrado =
	 * true; personajeEnJuego = unPersonaje; } } personajeEnJuego.jugar(); }
	 */

}
