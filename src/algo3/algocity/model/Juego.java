package algo3.algocity.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JFrame;
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
import org.xml.sax.SAXException;

import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.conexiones.Tuberia;
import algo3.algocity.model.construcciones.CentralEolica;
import algo3.algocity.model.construcciones.CentralMinera;
import algo3.algocity.model.construcciones.CentralNuclear;
import algo3.algocity.model.construcciones.EstacionDeBomberos;
import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.view.Ventana;

public class Juego {

	final int anchoMapaJuego = 100;
	final int altoMapaJuego = 100;

	private Mapa mapa;

	private Turno turnos;

	Usuario usuario;

	public Juego() {

	}

	public void iniciar() {
		// generarMapas();
		crearVentana();
		// iniciarTurnos();
	}

	private void crearVentana() {
		JFrame ventana = new Ventana(new Mapa());
	}

	private void iniciarTurnos() {
		turnos = new Turno();
	}

	private void generarMapas() {
		mapa = new Mapa();
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	
	public void persistir() {

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
					new PrintStream("Juego.xml")));

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

	private Element getElement(Document doc) {
		Element juego = doc.createElement("Juego");

		Element ancho = doc.createElement("anchoMapaJuego");
		ancho.setTextContent(String.valueOf(this.anchoMapaJuego));
		juego.appendChild(ancho);

		Element alto = doc.createElement("altoMapaJuego");
		alto.setTextContent(String.valueOf(this.altoMapaJuego));
		juego.appendChild(alto);

		Element mapa = this.mapa.getElement(doc);
		juego.appendChild(mapa);

		Element turnos = this.turnos.getElement(doc);
		juego.appendChild(turnos);

		return juego;
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * PARA PROBAR COMO SE GUARDAN LOS XML
	 */
	public static void main(String[] args) throws ParserConfigurationException,
			TransformerFactoryConfigurationError, FileNotFoundException,
			TransformerException {

		//prueba1();

		prueba2();

		//Juego juego = new Juego();

		//juego.persistir();

	}

	private static void prueba2() {

		try {

			Document doc = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder().parse(new File("pruebamapa.xml"));
			Element element = doc.getDocumentElement();

			Mapa mapa = Mapa.fromElement(element);

			System.out.println(mapa.alto());
			System.out.println(mapa.ancho());

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public static void prueba1() {

		Mapa mapa = new Mapa();

		UnidadResidencial ur = new UnidadResidencial(10, 10);
		ur.agregarseA(mapa);

		UnidadComercial uc = new UnidadComercial(2, 2);
		uc.agregarseA(mapa);

		UnidadIndustrial ui = new UnidadIndustrial(4, 8);
		ui.agregarseA(mapa);

		PozoDeAgua pa = new PozoDeAgua(5, 5);
		pa.agregarseA(mapa);

		EstacionDeBomberos eb = new EstacionDeBomberos(6, 6);
		eb.agregarseA(mapa);

		CentralNuclear cn = new CentralNuclear(4, 1);
		cn.agregarseA(mapa);

		CentralMinera cm = new CentralMinera(7, 1);
		cm.agregarseA(mapa);

		CentralEolica ce = new CentralEolica(1, 9);
		ce.agregarseA(mapa);

		LineaTension lt = new LineaTension(7, 2);
		lt.agregarseA(mapa);

		Ruta rt = new Ruta(9, 1);
		rt.agregarseA(mapa);

		Tuberia tb = new Tuberia(4, 7);
		tb.agregarseA(mapa);

		try {
			Document doc = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder().newDocument();

			Element element = mapa.getElement(doc);
			doc.appendChild(element);

			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.transform(new DOMSource(doc), new StreamResult(
					new PrintStream("pruebamapa.xml")));

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

}