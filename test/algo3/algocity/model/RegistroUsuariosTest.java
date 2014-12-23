package algo3.algocity.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import algo3.algocity.model.excepciones.NoSeEncontroElFicheroException;

public class RegistroUsuariosTest {

	@Test
	public void testSePuedenLeerLosNombresDeUsuariosPreviamenteGuardados()
			throws NoSeEncontroElFicheroException {

		RegistroUsuarios ru = new RegistroUsuarios();

		ArrayList<String> nombresUsers = ru.nombresUsuarios();

		assertFalse(nombresUsers.isEmpty());
	}

	// COMENTADO POR EL MOMENTO
	/*
	 * @Test public void testSePuedeCrearUnNuevoUsuario() {
	 * 
	 * ControladorUsuarios controlador = new ControladorUsuarios();
	 * controlador.addUsuario("Pedro");
	 * 
	 * assertTrue(controlador.existeNombreUsuario("Pedro"));
	 * assertTrue(controlador.existeUsuario(controlador.getUsuario("Pedro"))); }
	 * 
	 * @Test public void testNoSePuedenCrearDosUsuariosConMismoNombre() {
	 * 
	 * ControladorUsuarios controlador = new ControladorUsuarios();
	 * controlador.addUsuario("Juan");
	 * 
	 * assertTrue(controlador.existeUsuario(controlador.getUsuario("Juan")));
	 * 
	 * assertTrue(controlador.existeNombreUsuario("Juan"));
	 * assertFalse(controlador.addUsuario("Juan"));
	 * 
	 * }
	 * 
	 * @Test public void testObtenerUsuariosYaExistentes() {
	 * 
	 * ControladorUsuarios controlador = new ControladorUsuarios();
	 * controlador.addUsuario("Jose"); controlador.addUsuario("Martin");
	 * controlador.addUsuario("Fernando");
	 * 
	 * assertTrue(controlador.getUsuario("Jose") == controlador
	 * .buscarUsuario("Jose")); assertTrue(controlador.getUsuario("Martin") ==
	 * controlador .buscarUsuario("Martin"));
	 * assertTrue(controlador.getUsuario("Fernando") == controlador
	 * .buscarUsuario("Fernando"));
	 * 
	 * }
	 */

}
