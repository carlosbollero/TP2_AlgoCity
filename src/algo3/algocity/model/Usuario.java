package algo3.algocity.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Usuario {
	
	private String nombre;
	ArrayList<Personaje> personajes;


	public Usuario(String unNombre){
		this.nombre = unNombre;
	}
	
	
	public void setNombre(String nuevoNombre) {
		nombre = nuevoNombre;		
	}

	
	public String getNombre() {
		return nombre;
	}
	
	
	public void crearPersonaje(String nombrePersonaje){
		personajes.add(new Personaje(nombrePersonaje));
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
