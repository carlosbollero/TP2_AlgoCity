package algo3.algocity.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.ElUsuarioYaExisteException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.NoSeEncontroElFicheroException;
import algo3.algocity.model.excepciones.NombreDeUsuarioYaExisteException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;

/**
 * Clase controladora del login y registro de usuarios
 **/

public class RegistroUsuarios {

	private ArrayList<Usuario> usuarios;
	private ArrayList<String> nombresUsuarios;
	private HashMap<String, Integer> listaPuntajes;

	public RegistroUsuarios() throws SAXException, IOException,
			ParserConfigurationException {
		usuarios = new ArrayList<Usuario>();
		nombresUsuarios = new ArrayList<String>();
		listaPuntajes = new HashMap<String, Integer>();
		leerNombresUsuarios();
	}

	private void leerNombresUsuarios() {
		String sDirectorio = "saved";
		File fDirectorio = new File(sDirectorio);
		try {
			if(!fDirectorio.exists()){
				throw new NoSeEncontroElFicheroException();
			}
		} catch (NoSeEncontroElFicheroException e) {
			crearDirectorio();
			leerNombresUsuarios();
		}
		
		File[] ficheros = fDirectorio.listFiles();
		for (int i = 0; i < ficheros.length; i++) {
			String nombreUser = ficheros[i].getName();
			String[] arrayUser = nombreUser.split("\\.");

			nombresUsuarios.add(arrayUser[0]);
		}
	}

	public void leerUsuario(String nombreUsuario) throws SAXException,
			IOException, ParserConfigurationException {
		Document doc = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder()
				.parse(new File("./saved/" + nombreUsuario + ".xml"));
		Element element = doc.getDocumentElement();
		Juego juego = null;
		try {
			juego = Juego.fromElement(element);
		} catch (NoSeCumplenLosRequisitosException
				| FondosInsuficientesException
				| SuperficieInvalidaParaConstruir | CoordenadaInvalidaException
				| CapacidadElectricaInsuficienteException
				| NoHayConexionConTuberias | NoHayConexionConRutas
				| NoHayConexionConRedElectrica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		juego.usuario().puntaje(juego.poblacion().getCantidad());
		usuarios.add(juego.usuario());
		listaPuntajes.put(juego.usuario().nombre(), juego.poblacion()
				.getCantidad());
		//agregado para que se actualicen los puntajes en el xml
		juego.persistir();
	}

	public void leerUsuarios() throws 	SAXException, IOException, ParserConfigurationException {
		String sDirectorio = "saved";
		File fDirectorio = new File(sDirectorio);

		try {
			if(!fDirectorio.exists()){
				throw new NoSeEncontroElFicheroException();
			}
		} catch (NoSeEncontroElFicheroException e) {
			crearDirectorio();
			leerUsuarios();
		}

		File[] ficheros = fDirectorio.listFiles();
		for (int i = 0; i < ficheros.length; i++) {

			String nombreUser = ficheros[i].getName();
			String[] arrayUser = nombreUser.split("\\.");

			if(!nombresUsuarios.contains(arrayUser[0])){
				nombresUsuarios.add(arrayUser[0]);
			}
			leerUsuario(arrayUser[0]);

		}
	}

	private void crearDirectorio() {
		File guardados = new File("saved");
		if (!guardados.exists()) {
			guardados.mkdir();
		}

	}

	public ArrayList<Usuario> usuarios() {
		return this.usuarios;
	}

	public ArrayList<String> nombresUsuarios() {
		return this.nombresUsuarios;
	}

	public HashMap<String, Integer> listaPuntajes() {
		return this.listaPuntajes;
	}

	public ArrayList<String> listaPuntajesString() {
		ArrayList<String> arrADevolver = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : listaPuntajes.entrySet()) {
			arrADevolver.add(entry.getKey() + ": "
					+ String.valueOf(entry.getValue()));
		}
		return arrADevolver;
	}

	public void addUsuario(Usuario unUsuario)
			throws NombreDeUsuarioYaExisteException {

		if (usuarios.isEmpty()) {
			usuarios.add(unUsuario);
			nombresUsuarios.add(unUsuario.nombre());
		} else if (!existeNombreUsuario(unUsuario.nombre())) {
			usuarios.add(unUsuario);
			nombresUsuarios.add(unUsuario.nombre());
		}
	}

	public boolean existeNombreUsuario(String nombreUsuarioAChequear)
			throws NombreDeUsuarioYaExisteException {

		// System.out.println(nombreUsuarioAChequear);
		// for (String a : nombresUsuarios) {
		// System.out.println(a);
		// }
		boolean devolucion = nombresUsuarios.contains(nombreUsuarioAChequear);
		if (devolucion) {
			// throw new NombreDeUsuarioYaExisteException();
		}
		return devolucion;
	}

	public boolean existeUsuario(Usuario usuarioAChequear)
			throws ElUsuarioYaExisteException {
		boolean encontrado = false;
		Iterator<Usuario> iteradorUsuarios = usuarios.iterator();
		while (iteradorUsuarios.hasNext() && (!encontrado)) {
			Usuario unUsuario = iteradorUsuarios.next();
			if (unUsuario == usuarioAChequear) {
				encontrado = true;
			}
		}
		if (encontrado) {
			System.out.println("El usuario ya existe");
			throw new ElUsuarioYaExisteException();
		}
		return encontrado;
	}

	public boolean crearUsuario(String nombreIngresado) {

		if (nombreIngresado.length() > 3 && !nombreIngresado.contains(" ")
				&& !nombreIngresado.contains(",")) {
			return (nombresUsuarios.add(nombreIngresado));
		}
		return false;
	}

}
