package algo3.algocity.model.conexiones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.Constantes;
import algo3.algocity.model.Dinero;
import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;
import algo3.algocity.model.Constantes;

public class LineaTension implements Conector, Daniable, Visitable {

	final boolean intacto = true;
	final boolean destruido = false;
	final double ESTADOINICIAL = 100;

	boolean estado; // true para intacto
					// false para destruido
	int costo;
	double porcentajeDanios;
	int danios; // no usado?
	Coordenada coordenada;

	public LineaTension() {
		this.costo = 5;
	}

	public LineaTension(Coordenada coordenada) {
		porcentajeDanios = 0;
		this.coordenada = coordenada;
	}

	public LineaTension(Mapa mapa, Dinero dinero, Coordenada coordenada)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, CoordenadaInvalidaException {
		costo = Constantes.COSTO_LINEATENSION;
		porcentajeDanios = 0;
		this.coordenada = coordenada;

		mapa.validarCoordenadas(coordenada);
		esConstruibleEn(mapa.superficie(coordenada));
		dinero.cobrar(costo);
	}

	public boolean estado() {
		return estado;
	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this);

	}

	public void aplicarDanioGodzilla() {
		estado = destruido;

	}

	@Override
	public void repararse() {
		porcentajeDanios = 0;
		// this.porcentajeDanios -= this.porcentajeReparacion();
		// if (this.getDanios() < 0) {
		// this.porcentajeDanios = 0;
		// }
	}

	public double getDanios() {
		return porcentajeDanios;
	}

	protected double porcentajeReparacion() {
		return 100;
	}

	public void aplicarDanio(double cantidad) {
		estado = destruido;
		porcentajeDanios = (porcentajeDanios + cantidad > ESTADOINICIAL) ? ESTADOINICIAL
				: porcentajeDanios + cantidad;
	}

	public double getSalud() {
		return (ESTADOINICIAL - porcentajeDanios);
	}

	public Coordenada coordenada() {
		return coordenada;
	}

	public void setCoordenadas(Coordenada c) {
		this.coordenada = c;
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		return superficie.esTierra();
	}

	@Override
	public boolean agregarseA(Mapa mapa) {
		return mapa.redElectrica().agregar(this);
		// mapa.agregarUnidadDaniable(this);
	}

	@Override
	public boolean estaContenidoEn(Mapa mapa) {
		return mapa.redElectrica().contiene(this);

	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	@Override
	public Element getElement(Document doc) {
		Element conector = doc.createElement("LineaTension");

		Element costo = doc.createElement("costo");
		conector.appendChild(costo);
		costo.setTextContent(String.valueOf(this.costo));

		Element coordenadas = doc.createElement("coordenadas");
		conector.appendChild(coordenadas);
		coordenadas
				.setTextContent((String.valueOf((int) this.coordenada.getX())
						+ "," + String.valueOf((int) this.coordenada.getY())));

		Element porcentajeDanios = doc.createElement("porcentajeDanios");
		conector.appendChild(porcentajeDanios);
		porcentajeDanios.setTextContent(String.valueOf(this.porcentajeDanios));

		return conector;
	}

	public void fromElement(Node hijoDeUnidadDaniable) {

		NodeList hijosDeUnidad = hijoDeUnidadDaniable.getChildNodes();

		for (int i = 0; i < hijosDeUnidad.getLength(); i++) {
			Node hijoDeUnidad = hijosDeUnidad.item(i);
			if (hijoDeUnidad.getNodeName().equals("costo")) {
				this.costo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("coordenadas")) {
				String stringPunto = hijoDeUnidad.getTextContent();
				String[] arrayPunto = stringPunto.split(",");
				Coordenada punto = new Coordenada(
						Integer.valueOf(arrayPunto[0]),
						Integer.valueOf(arrayPunto[1]));
				this.coordenada = punto;
			} else if (hijoDeUnidad.getNodeName().equals("porcentajeDanios")) {
				this.porcentajeDanios = Double.valueOf(hijoDeUnidad
						.getTextContent());
			}
		}
	}

	// public LineaTension fromElement(Node hijoDeUnidadDaniable) {
	// LineaTension lt = new LineaTension();
	// NodeList hijosDeUnidad = hijoDeUnidadDaniable.getChildNodes();
	//
	// for (int i = 0; i < hijosDeUnidad.getLength(); i++) {
	// Node hijoDeUnidad = hijosDeUnidad.item(i);
	// if (hijoDeUnidad.getNodeName().equals("costo")) {
	// lt.costo = Integer.valueOf(hijoDeUnidad.getTextContent());
	// } else if (hijoDeUnidad.getNodeName().equals("coordenadas")) {
	// String stringPunto = hijoDeUnidad.getTextContent();
	// String[] arrayPunto = stringPunto.split(",");
	// Coordenada punto = new Coordenada(
	// Integer.valueOf(arrayPunto[0]),
	// Integer.valueOf(arrayPunto[1]));
	// lt.coordenadas = punto;
	// } else if (hijoDeUnidad.getNodeName().equals("porcentajeDanios")) {
	// lt.porcentajeDanios = Double.valueOf(hijoDeUnidad
	// .getTextContent());
	// }
	// }
	// return lt;
	// }

	/* No evalua los invariantes de la clase */
	public boolean equals(Daniable lt) {
		if (lt == this) {
			return true;
		} else if (lt.coordenada().getX() == this.coordenada().getX()
				&& lt.coordenada().getY() == this.coordenada().getY()
				&& ((LineaTension) lt).porcentajeDanios == this.porcentajeDanios) {
			return true;
		}
		return false;
	}

}
