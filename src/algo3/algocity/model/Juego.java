package algo3.algocity.model;

import java.io.FileNotFoundException;
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

import algo3.algocity.model.mapas.Mapa;

public class Juego {

	final int anchoMapaJuego = 100;
	final int altoMapaJuego = 100;

	private Mapa mapa;

	private Turno turnos;

	Usuario usuario;

	public Juego() {
		generarMapas();
		iniciarTurnos();
	}

	public void iniciarTurnos() {
		turnos = new Turno();
	}

	private void generarMapas() {
		mapa = new Mapa(altoMapaJuego, anchoMapaJuego);

	}

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

}