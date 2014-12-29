package algo3.algocity.model.construcciones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.Constantes;
import algo3.algocity.model.Dinero;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class EstacionDeBomberos extends Unidad {

	private Conector conexion;

	public EstacionDeBomberos() {
		super(Constantes.COSTO_E_BOMBEROS, 0);
	}

	public EstacionDeBomberos(Mapa mapa, Dinero dinero, Coordenada coord)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, CoordenadaInvalidaException,
			SuperficieInvalidaParaConstruir {
		super(Constantes.COSTO_E_BOMBEROS, 0);
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

	public void conectarTuberia(Conector unaTuberia) {
		conexion = unaTuberia;
	}

	public Conector getConexion() {
		return conexion;
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
	@Override
	public boolean equals(Unidad eb) {
		if (eb == this) {
			return true;
		} else if (eb.coordenada().getX() == this.coordenada().getX()
				&& eb.coordenada().getY() == this.coordenada().getY()) {
			return true;
		}
		return false;
	}

}