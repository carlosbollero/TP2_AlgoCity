package algo3.algocity.model;

import java.util.ArrayList;

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

}
