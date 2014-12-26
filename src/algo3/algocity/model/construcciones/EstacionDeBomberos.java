package algo3.algocity.model.construcciones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.NoSePuedeConstruirEnSuperficie;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class EstacionDeBomberos extends Unidad {

	private Conector conexion;

	public EstacionDeBomberos() {
		super(1500, 0);
	}

	public EstacionDeBomberos(Mapa mapa, Dinero dinero, Coordenada coord)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, CoordenadaInvalidaException,
			NoSePuedeConstruirEnSuperficie {

		super(1500, 0);
		coordenada = coord;
		mapa.validarCoordenadas(coord);
		esConstruibleEn(mapa.superficie(coordenada));
		dinero.cobrar(costo);
	}

	public EstacionDeBomberos(Coordenada coord) {
		super(1500, 0);
		conexion = null;
		this.coordenada = coord;
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
	public boolean esConstruibleEn(Superficie superficie)
			throws NoSePuedeConstruirEnSuperficie {
		if (!superficie.esTierra()) {
			throw new NoSePuedeConstruirEnSuperficie();
		}
		return (superficie.esTierra());
	}

	@Override
	public boolean agregarseA(Mapa mapa) {
		mapa.agregarReparador();
		return mapa.ciudad().agregar(this);
	}

	@Override
	public boolean estaContenidoEn(Mapa mapa) {
		return mapa.ciudad().contiene(this);
	}

	// @Override
	// public void aplicarDanio(double i) {
	// // TODO Auto-generated method stub
	//
	// }

	// @Override
	// public double getSalud() {
	// // TODO revisar de hacerlo de otra forma
	// // por ahora pasan los tests, pero que PozoDeAgua y EstacionDeBomberos
	// // entiendan este mensaje nose si es lo mejor
	// return 100;
	// }

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
				.setTextContent((String.valueOf((int) this.coordenada.getX())
						+ "," + String.valueOf((int) this.coordenada.getY())));

		return unidad;
	}

	public void fromElement(Node hijoDeNodo) {
		NodeList hijosDeUnidad = hijoDeNodo.getChildNodes();

		for (int i = 0; i < hijosDeUnidad.getLength(); i++) {
			Node hijoDeUnidad = hijosDeUnidad.item(i);
			if (hijoDeUnidad.getNodeName().equals("costo")) {
				this.costo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("consumo")) {
				this.consumo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("coordenadas")) {
				String stringPunto = hijoDeUnidad.getTextContent();
				String[] arrayPunto = stringPunto.split(",");
				Coordenada punto = new Coordenada(
						Integer.valueOf(arrayPunto[0]),
						Integer.valueOf(arrayPunto[1]));
				this.coordenada = punto;
			}
		}
	}

	/* No evalua los invariantes de la clase */
	public boolean equals(Daniable eb) {
		if (eb == this) {
			return true;
		} else if (eb.coordenada().getX() == this.coordenada().getX()
				&& eb.coordenada().getY() == this.coordenada().getY()) {
			return true;
		}
		return false;
	}

}