package algo3.algocity.model;

public class Usuario {

	private String nombre;
	private String rutaDeJuego;

	public Usuario(String unNombre) {

		this.nombre = unNombre;
		this.rutaDeJuego = "JuegoDe" + this.nombre;
	}

<<<<<<< HEAD
	public void setNombre(String nuevoNombre) {
		nombre = nuevoNombre;
=======
<<<<<<< HEAD
	public void setNombre(String nuevoNombre) {
		nombre = nuevoNombre;		
=======
	public void setNombre(String nuevoNombre) {
		nombre = nuevoNombre;
>>>>>>> 917b3213c37505003cd54fea865827e02bc80497
>>>>>>> dev-tomas
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
=======
	
<<<<<<< HEAD
	
	public String getRutaJuegoAsociado(){
		return rutaJuegoAsociado;
	}
	
=======
	public void ruta(String ruta){
		this.rutaDeJuego = ruta;
	}
	
	public String ruta(){
		return rutaDeJuego;
	}
>>>>>>> dev-tomas

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

<<<<<<< HEAD
=======
>>>>>>> 917b3213c37505003cd54fea865827e02bc80497
>>>>>>> dev-tomas
}
