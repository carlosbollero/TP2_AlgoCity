package algo3.algocity.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Usuario {
	
	private String nombre;
	private String rutaJuegoAsociado;

	
	public Usuario(String unNombre){
		this.nombre = unNombre;
		this.rutaJuegoAsociado = "JuegoDe"+this.nombre;
	}
	
	
	public void setNombre(String nuevoNombre) {
		nombre = nuevoNombre;		
	}

	
	public String getNombre() {
		return nombre;
	}
	
	
	public String getRutaJuegoAsociado(){
		return rutaJuegoAsociado;
	}
	
	
	
	
	public void jugar(String nombrePersonaje){
		Iterator<Personaje> it = personajes.iterator();
		boolean encontrado = false;
		Personaje personajeEnJuego = null;
		
		while(it.hasNext() && !encontrado){
			Personaje unPersonaje = it.next();
			if(unPersonaje.getNombrePersonaje() == nombrePersonaje){
				encontrado = true;
				personajeEnJuego = unPersonaje;
			}			
		}
		personajeEnJuego.jugar();
	}
	
	

}
