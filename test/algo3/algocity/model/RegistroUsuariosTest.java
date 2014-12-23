package algo3.algocity.model;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import algo3.algocity.model.excepciones.ElUsuarioYaExisteException;
import algo3.algocity.model.excepciones.NoSeEncontroElFicheroException;
import algo3.algocity.model.excepciones.NombreDeUsuarioYaExisteException;

public class RegistroUsuariosTest {

	@Test
	public void testSePuedenLeerLosNombresDeUsuariosPreviamenteGuardados()
			throws NoSeEncontroElFicheroException, SAXException, IOException,
			ParserConfigurationException {

		RegistroUsuarios ru = new RegistroUsuarios();

		ArrayList<String> nombresUsers = ru.nombresUsuarios();

		assertFalse(nombresUsers.isEmpty());
	}

	// @Test(expected=ElUsuarioYaExisteException.class)
	@Test
	public void testSePuedeCrearUnNuevoUsuario()
			throws NoSeEncontroElFicheroException, SAXException, IOException,
			ParserConfigurationException, NombreDeUsuarioYaExisteException {

		RegistroUsuarios ru = new RegistroUsuarios();

		Usuario user = new Usuario("Marcelo");

		ru.addUsuario(user);

		// Estos metodos levantan excepcion, esta bien pero no se como
		// corroborarlo con junit
		try {
			ru.existeNombreUsuario("Marcelo");
		} catch (NombreDeUsuarioYaExisteException e) {

		}

		try {
			ru.existeUsuario(user);
		} catch (ElUsuarioYaExisteException e) {

		}

	}

//	@Test
//	public void testNoSePuedenCrearDosUsuariosConMismoNombre()
//			throws NoSeEncontroElFicheroException, SAXException, IOException,
//			ParserConfigurationException, NombreDeUsuarioYaExisteException,
//			ElUsuarioYaExisteException {
//
//		RegistroUsuarios ru = new RegistroUsuarios();
//
//		Usuario user1 = new Usuario("Enrique");
//
//		ru.addUsuario(user1);
//
//		try {
//			assertTrue(ru.existeUsuario(user1));
//		} catch (ElUsuarioYaExisteException e) {
//
//		}
//
//		Usuario user2 = new Usuario("Enrique");
//
//		ru.addUsuario(user2);
//
//	}


}
