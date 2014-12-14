package algo3.algocity.model.construcciones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class PozoDeAgua extends Unidad implements Daniable {

	public PozoDeAgua() {
		costo = 250;
		consumo = 0;
	}

	public PozoDeAgua(int x, int y) {
		costo = 250;
		consumo = 0;
		this.coordenadas = new Coordenada(x, y);
	}

	public PozoDeAgua(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {

		coordenadas = new Coordenada(x, y);
		costo = 250;
		consumo = 0;

		if (!esConstruibleEn(mapa.superficie(coordenadas))) {
			throw new NoSeCumplenLosRequisitosException();
		}
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		return superficie.esAgua();
	}

	// @Override
	// public void aplicarDanio(double i) {
	// // TODO Auto-generated method stub
	//
	// }

	@Override
	public double getSalud() {
		// TODO revisar de hacerlo de otra forma
		// por ahora pasan los tests, pero que PozoDeAgua y EstacionDeBomberos
		// entiendan este mensaje nose si es lo mejor
		return 100;
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarACiudad(this);
		mapa.agregarPuntoRelevanteEnTuberias(this);
	}

	@Override
	public void repararse() {
		// TODO Auto-generated method stub

	}

	@Override
	public void aplicarDanio(double unDanio) {
		// TODO Auto-generated method stub

	}

	@Override
	public void aceptar(Visitante v) {
		// TODO Auto-generated method stub

	}

	/* Persistencia */
	// TODO falta probarlo
	@Override
	public Element getElement(Document doc) {

		Element unidad = doc.createElement("PozoDeAgua");

		Element costo = doc.createElement("costo");
		unidad.appendChild(costo);
		costo.setTextContent(String.valueOf(this.costo));

		Element consumo = doc.createElement("consumo");
		unidad.appendChild(consumo);
		consumo.setTextContent(String.valueOf(this.consumo));

		Element coordenadas = doc.createElement("coordenadas");
		unidad.appendChild(coordenadas);
		coordenadas
				.setTextContent((String.valueOf((int) this.coordenadas.getX())
						+ "," + String.valueOf((int) this.coordenadas.getY())));

		return unidad;
	}

	public static PozoDeAgua fromElement(Node hijoDeNodo) {
		PozoDeAgua pa = new PozoDeAgua();
		NodeList hijosDeUnidad = hijoDeNodo.getChildNodes();

		for (int i = 0; i < hijosDeUnidad.getLength(); i++) {
			Node hijoDeUnidad = hijosDeUnidad.item(i);
			if (hijoDeUnidad.getNodeName().equals("costo")) {
				pa.costo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("consumo")) {
				pa.consumo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("coordenadas")) {
				String stringPunto = hijoDeUnidad.getTextContent();
				String[] arrayPunto = stringPunto.split(",");
				Coordenada punto = new Coordenada(
						Integer.valueOf(arrayPunto[0]),
						Integer.valueOf(arrayPunto[1]));
				pa.coordenadas = punto;
			}
		}

		return pa;
	}

}
