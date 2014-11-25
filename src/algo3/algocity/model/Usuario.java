package algo3.algocity.model;

public class Usuario {

	private String nombre;
	private String rutaJuegoAsociado;

	public Usuario(String unNombre) {

		this.nombre = unNombre;
		this.rutaJuegoAsociado = "JuegoDe" + this.nombre;
	}

	public void setNombre(String nuevoNombre) {
		nombre = nuevoNombre;
	}

	public String getNombre() {
		return this.nombre;
	}

<<<<<<< HEAD
	public String getRutaJuegoAsociado() {
		return this.rutaJuegoAsociado;
	}

	// TODO
	// Metodo encargado de persistir a disco la partida del usuario
	public void persistir() {

	}

	/*
=======
	/*
	 * 
	 * public String getRutaJuegoAsociado(){ return rutaJuegoAsociado; }
	 * 
	 * 
	 * 
	 * 
>>>>>>> dev-tomas
	 * public void jugar(String nombrePersonaje){ Iterator<Personaje> it =
	 * personajes.iterator(); boolean encontrado = false; Personaje
	 * personajeEnJuego = null;
	 * 
	 * while(it.hasNext() && !encontrado){ Personaje unPersonaje = it.next();
	 * if(unPersonaje.getNombrePersonaje() == nombrePersonaje){ encontrado =
	 * true; personajeEnJuego = unPersonaje; } } personajeEnJuego.jugar(); }
	 */

}
