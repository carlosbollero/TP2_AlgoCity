package algo3.algocity.model.construcciones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class EstacionDeBomberos extends Unidad implements Daniable {

	private Conector conexion;

	public EstacionDeBomberos() {
		costo = 1500;
		consumo = 0;
	}

	public EstacionDeBomberos(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {

		coordenadas = new Coordenada(x, y);
		costo = 1500;
		consumo = 0;
		if (!esConstruibleEn(mapa.superficie(coordenadas))) {
			throw new NoSeCumplenLosRequisitosException();
		}
	}

	public EstacionDeBomberos(int x, int y) {
		costo = 1500;
		consumo = 0;
		conexion = null;
		this.coordenadas = new Coordenada(x, y);
	}

	// public void actuar(ArrayList<Visitable> objetivos) {
	// for (Visitable v : objetivos) {
	// v.aceptar(this);
	// }
	// }

	// TODO Revisar si sirve el metodo
	public void conectarTuberia(Conector unaTuberia) {
		conexion = unaTuberia;
	}

	public Conector getConexion() {
		return conexion;
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		return (superficie.esTierra());
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
		mapa.agregarReparador();
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
		v.visitar(this);

	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	@Override
	public Element getElement(Document doc) {

		Element unidad = doc.createElement("EstacionDeBomberos");

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

	public static EstacionDeBomberos fromElement(Node hijoDeNodo) {

		EstacionDeBomberos eb = new EstacionDeBomberos();
		NodeList hijosDeUnidad = hijoDeNodo.getChildNodes();

		for (int i = 0; i < hijosDeUnidad.getLength(); i++) {
			Node hijoDeUnidad = hijosDeUnidad.item(i);
			if (hijoDeUnidad.getNodeName().equals("costo")) {
				eb.costo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("consumo")) {
				eb.consumo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("coordenadas")) {
				String stringPunto = hijoDeUnidad.getTextContent();
				String[] arrayPunto = stringPunto.split(",");
				Coordenada punto = new Coordenada(
						Integer.valueOf(arrayPunto[0]),
						Integer.valueOf(arrayPunto[1]));
				eb.coordenadas = punto;
			}
		}
		return eb;
	}

	/*No evalua los invariantes de la clase*/
	public boolean equals(Daniable eb) {
		if (eb == this) {
			return true;
		} else if (eb.coordenadas().getX() == this.coordenadas().getX()
				&& eb.coordenadas().getY() == this.coordenadas().getY()) {
			return true;
		}
		return false;
	}

}