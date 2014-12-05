package algo3.algocity.model;

import java.util.ArrayList;
import java.util.Iterator;

import algo3.algocity.model.excepciones.ElUsuarioYaExisteException;
import algo3.algocity.model.excepciones.NombreDeUsuarioYaExisteException;

/**
 * Clase controladora del login y registro de usuarios
 **/

public class RegistroUsuarios {

	private ArrayList<Usuario> usuarios;

	public RegistroUsuarios() {

		usuarios = new ArrayList<Usuario>();
	}

	public void addUsuario(Usuario unUsuario) throws NombreDeUsuarioYaExisteException {

		if (usuarios.isEmpty()) {

			usuarios.add(unUsuario);

		} else if (!existeNombreUsuario(unUsuario.nombre())) {
			usuarios.add(unUsuario);			
		}
	}

	public boolean existeNombreUsuario(String nombreUsuarioAChequear) throws NombreDeUsuarioYaExisteException {
		boolean encontrado = false;
		Iterator<Usuario> iteradorUsuarios = usuarios.iterator();
		while (iteradorUsuarios.hasNext() && (!encontrado)) {
			Usuario unUsuario = iteradorUsuarios.next();

			if (unUsuario.nombre() == nombreUsuarioAChequear) {

				encontrado = true;
			}
		}
		if (encontrado){
			throw new NombreDeUsuarioYaExisteException();
		}
		return encontrado;
	}

	public boolean existeUsuario(Usuario usuarioAChequear) throws ElUsuarioYaExisteException {
		boolean encontrado = false;
		Iterator<Usuario> iteradorUsuarios = usuarios.iterator();
		while (iteradorUsuarios.hasNext() && (!encontrado)) {
			Usuario unUsuario = iteradorUsuarios.next();

			if (unUsuario == usuarioAChequear) {

				encontrado = true;
			}
		}
		if (encontrado){
			throw new ElUsuarioYaExisteException();
		}
		return encontrado;
	}

}
