package algo3.algocity.main;

import java.util.ArrayList;
import java.util.Iterator;

import algo3.algocity.model.Juego;
import algo3.algocity.model.Usuario;



public class Main {
	private ArrayList<Usuario> usuarios;
	private Juego juego;
	
	
	
	
	
	
	public boolean crearUsuario(String nombreUsuario){
		
		if(!this.existeNombreUsuario(nombreUsuario) ){
			usuarios.add(new Usuario(nombreUsuario));
			return true;
		}
		return false;
	}
	
	
	private boolean existeNombreUsuario(String unNombreUsuario){
		Iterator<Usuario> it = usuarios.iterator();
		while(it.hasNext()){
			Usuario unUsuario = it.next();
			if(unUsuario.equals(unNombreUsuario)){
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
}
