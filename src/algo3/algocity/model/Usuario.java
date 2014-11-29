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

<<<<<<< HEAD
	public String getNombre() {
		return this.nombre;
	}

	public String getRutaJuegoAsociado() {
		return this.rutaJuegoAsociado;
	}

	// TODO
	// Metodo encargado de persistir a disco la partida del usuario
	public void persistir() {

=======
	public String nombre() {
		return nombre;
>>>>>>> 275e25272bfc21a3f80890c7ce3add1a02b67ca1
	}
	
	public void ruta(String ruta){
		this.ruta = ruta;
	}
	
	public String ruta(){
		return ruta;
	}

	/*
	 * ======= /*
	 * 
	 * public String getRutaJuegoAsociado(){ return rutaJuegoAsociado; }
	 * 
	 * 
	 * 
	 * 
	 * >>>>>>> dev-tomas public void jugar(String nombrePersonaje){
	 * Iterator<Personaje> it = personajes.iterator(); boolean encontrado =
	 * false; Personaje personajeEnJuego = null;
	 * 
	 * while(it.hasNext() && !encontrado){ Personaje unPersonaje = it.next();
	 * if(unPersonaje.getNombrePersonaje() == nombrePersonaje){ encontrado =
	 * true; personajeEnJuego = unPersonaje; } } personajeEnJuego.jugar(); }
	 */

}
