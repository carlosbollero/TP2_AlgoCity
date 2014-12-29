package algo3.algocity.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import algo3.algocity.model.catastrofes.GeneradorCatastrofe;
import algo3.algocity.model.excepciones.CapacidadElectricaInsuficienteException;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConRedElectrica;
import algo3.algocity.model.excepciones.NoHayConexionConRutas;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.mapas.Mapa;

public class Juego {

	private Mapa mapa;
	private Turno turnos;
	private Poblacion poblacion;
	private Usuario usuario;
	private Dinero dinero;
	private GeneradorCatastrofe genCatastrofe;

	public Juego(Usuario u, Mapa map, Turno t, Poblacion p, Dinero d) {
		crearDirectorioGuardados();
		usuario = u;
		mapa = map;
		turnos = t;
		poblacion = p;
		dinero = d;
		genCatastrofe = new GeneradorCatastrofe(mapa);
		turnos.addObserver(genCatastrofe);
		turnos.addObserver(poblacion);
		turnos.addObserver(dinero);
		mapa.setTurno(turnos);
		poblacion.actualizar(mapa);
	}
	
	public Juego(Usuario usuario) {
		crearDirectorioGuardados();
		mapa = new Mapa();
		this.usuario = usuario;
		poblacion = new Poblacion();
		// poblacion = new Poblacion(mapa);
		turnos = new Turno();
		dinero = new Dinero(poblacion, turnos);
		genCatastrofe = new GeneradorCatastrofe(mapa);
		turnos.addObserver(genCatastrofe);
		turnos.addObserver(poblacion);
		turnos.addObserver(dinero);
		// this(new Usuario(), new Mapa(), new Turno(), new Poblacion());

		// poblacion.actualizar(mapa);
	}

	/* Usado para persistencia */
	public Juego() {
		crearDirectorioGuardados();
		mapa = new Mapa();
		usuario = new Usuario();
		poblacion = new Poblacion();
		// poblacion = new Poblacion(mapa);
		turnos = new Turno();
		dinero = new Dinero(poblacion, turnos);
		genCatastrofe = new GeneradorCatastrofe(mapa);
		turnos.addObserver(genCatastrofe);
		turnos.addObserver(poblacion);
		turnos.addObserver(dinero);
		mapa.setTurno(turnos);
		// this(new Usuario(), new Mapa(), new Turno(), new Poblacion());

		// poblacion.actualizar(mapa);
	}

	private void crearDirectorioGuardados() {
		File guardados = new File("saved");
		if (!guardados.exists()) {
			guardados.mkdir();
		}

	}

	public void iniciar() {
		generarMapas();
		// iniciarTurnos();
	}

	public void actualizar() {
		turnos.addObserver(poblacion);
		turnos.addObserver(dinero);
	}

	private void iniciarTurnos() {
		turnos = new Turno();
	}

	private void generarMapas() {
		mapa = new Mapa();
	}

	public Mapa mapa() {
		return this.mapa;
	}

	public Usuario usuario() {
		return this.usuario;
	}

	public Turno turno() {
		return this.turnos;
	}

	public Poblacion poblacion() {
		return this.poblacion;
	}

	public Dinero dinero() {
		return dinero;
	}

	public Reparador reparador() {
		return this.mapa.reparador();
	}

	public GeneradorCatastrofe genCatastrofe() {
		return genCatastrofe;
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**
	 * @throws IOException
	 ********************************************************************/
	public void persistir() throws IOException {

		try {
			Document doc = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder().newDocument();

			Element element = this.getElement(doc);
			doc.appendChild(element);

			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.transform(new DOMSource(doc), new StreamResult(
					new PrintStream(this.usuario.ruta())));

			// TODO
			// falta cerrar el documento

			// doc.close();
			InputStream in = new FileInputStream(this.usuario.ruta());
			in.close();

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	// Al recuperar una instancia de juego, esta debe ser valida
	// y cumplir con todos sus requisitos
	public Juego recuperar(String nombreUsuario) throws SAXException,
			IOException, ParserConfigurationException,
			NoSeCumplenLosRequisitosException, FondosInsuficientesException,
			SuperficieInvalidaParaConstruir, CoordenadaInvalidaException,
			CapacidadElectricaInsuficienteException, NoHayConexionConTuberias,
			NoHayConexionConRutas, NoHayConexionConRedElectrica {

		Document doc = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder()
				.parse(new File("./saved/" + nombreUsuario + ".xml"));
		Element element = doc.getDocumentElement();
		Juego juego = Juego.fromElement(element);
		return juego;
	}

	private Element getElement(Document doc) {
		Element juego = doc.createElement("Juego");

		Element usuario = this.usuario.getElement(doc);
		juego.appendChild(usuario);

		Element turnos = this.turnos.getElement(doc);
		juego.appendChild(turnos);

		// Element poblacion = this.poblacion.getElement(doc);
		// juego.appendChild(poblacion);

		// Element dinero = this.dinero.getElement(doc);
		// juego.appendChild(dinero);

		Element mapa = this.mapa.getElement(doc, this.poblacion, this.turnos);
		juego.appendChild(mapa);

		this.poblacion.actualizar(this.mapa);
		Element poblacion = this.poblacion.getElement(doc);
		juego.appendChild(poblacion);

		Element dinero = this.dinero.getElement(doc, this.poblacion,
				this.turnos);
		juego.appendChild(dinero);

		return juego;
	}

	// La visibilidad no es private, pues RegistroUsuarios debe tener acceso a
	// ella
	static Juego fromElement(Element element)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, SuperficieInvalidaParaConstruir,
			CoordenadaInvalidaException,
			CapacidadElectricaInsuficienteException, NoHayConexionConTuberias,
			NoHayConexionConRutas, NoHayConexionConRedElectrica {
		Juego juego = new Juego();

		NodeList hijosDeJuego = element.getChildNodes();
		for (int i = 0; i < hijosDeJuego.getLength(); i++) {
			Node hijoDeJuego = hijosDeJuego.item(i);
			if (hijoDeJuego.getNodeName().equals("Usuario")) {
				Usuario usuario = Usuario.fromElement(hijoDeJuego);
				juego.usuario = usuario;
			} else if (hijoDeJuego.getNodeName().equals("Turnos")) {
				Turno turnos = Turno.fromElement(hijoDeJuego);
				juego.turnos = turnos;
			} else if (hijoDeJuego.getNodeName().equals("Poblacion")) {
				Poblacion poblacion = Poblacion.fromElement(hijoDeJuego,
						juego.mapa);
				juego.poblacion = poblacion;
			} else if (hijoDeJuego.getNodeName().equals("Dinero")) {
				Dinero dinero = Dinero.fromElement(hijoDeJuego, juego.mapa,
						juego.turnos, juego.poblacion);
				juego.dinero = dinero;
			} else if (hijoDeJuego.getNodeName().equals("Mapa")) {
				Mapa mapa = Mapa.fromElement(hijoDeJuego, juego.mapa,
						juego.dinero, juego.turnos, juego.poblacion);
				juego.mapa = mapa;
			}
		}
		juego.poblacion.actualizar(juego.mapa());
		return juego;
	}

}