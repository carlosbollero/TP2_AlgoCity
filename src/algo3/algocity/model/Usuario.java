package algo3.algocity.model;

public class Usuario {

	private String nombre;
	private String rutaDeJuego;

	public Usuario(String unNombre) {

		this.nombre = unNombre;
		this.rutaDeJuego = "JuegoDe" + this.nombre;
	}

	public void setNombre(String nuevoNombre) {
		nombre = nuevoNombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void ruta(String ruta){
		this.rutaDeJuego = ruta;
	}
	
	public String ruta(){
		return rutaDeJuego;
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
