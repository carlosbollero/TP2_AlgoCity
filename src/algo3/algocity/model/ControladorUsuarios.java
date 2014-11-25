package algo3.algocity.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase controladora del login y registro de usuarios
 **/

public class ControladorUsuarios {

	private ArrayList<Usuario> usuarios;

	public ControladorUsuarios() {

		this.usuarios = new ArrayList<Usuario>();
	}

	public boolean addUsuario(String nombreUsuario) {

		Usuario unUsuario = new Usuario(nombreUsuario);
		if (!existeNombreUsuario(unUsuario.getNombre())) {
			this.usuarios.add(unUsuario);
			return true;
		}

		return false;
	}

	public Usuario buscarUsuario(String nombreUsuario) {

		boolean encontrado = false;
		Iterator<Usuario> it = this.usuarios.iterator();
		while (it.hasNext() && !encontrado) {
			Usuario unUsuario = it.next();
			if (unUsuario.getNombre() == nombreUsuario) {
				encontrado = true;
				return unUsuario;
			}
		}
		return null;
	}

	public Usuario getUsuario(String nombreUsuario) {

		Usuario usuarioSolicitado = buscarUsuario(nombreUsuario);
		return usuarioSolicitado;
	}

	public boolean existeNombreUsuario(String nombreUsuarioAChequear) {

		boolean encontrado = false;
		Iterator<Usuario> iteradorUsuarios = this.usuarios.iterator();
		while (iteradorUsuarios.hasNext() && !encontrado) {
			Usuario unUsuario = iteradorUsuarios.next();

			if (unUsuario.getNombre() == nombreUsuarioAChequear) {

				encontrado = true;
			}
		}
		return encontrado;
	}

	public boolean existeUsuario(Usuario usuarioAChequear) {

		boolean encontrado = false;
		Iterator<Usuario> iteradorUsuarios = this.usuarios.iterator();
		while (iteradorUsuarios.hasNext() && (!encontrado)) {
			Usuario unUsuario = iteradorUsuarios.next();

			if (unUsuario == usuarioAChequear) {

				encontrado = true;
			}
		}
		return encontrado;
	}

}
