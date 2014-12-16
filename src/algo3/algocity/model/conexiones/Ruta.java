package algo3.algocity.model.conexiones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class Ruta implements Conector, Daniable, Visitable {

	final boolean intacto = true;
	final boolean destruido = false;
	final double ESTADOINICIAL = 100;

	boolean estado;
	int costo;
	double porcentajeDanios;
	Coordenada coordenadas;

	public Ruta() {
		this.costo = 10;
	}

	public Ruta(int x, int y) {
		// porcentajeDanios = 0;
		costo = 10;
		coordenadas = new Coordenada(x, y);

	}

	public Ruta(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {
		porcentajeDanios = 0;
		costo = 10;
		coordenadas = new Coordenada(x, y);
		if (!esConstruibleEn(mapa.superficie(coordenadas))) {
			throw new NoSeCumplenLosRequisitosException();
		} /*
		 * else { mapa.agregar(this); }
		 */
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

	public Coordenada coordenadas() {
		return coordenadas;
	}
	
	public void setCoordenadas(Coordenada c){
		this.coordenadas = c;
	}

	@Override
	public void repararse() {
		this.porcentajeDanios -= this.porcentajeReparacion();
		if (this.getDanios() < 0) {
			this.porcentajeDanios = 0;
		}
	}

	public double getDanios() {
		return porcentajeDanios;
	}

	protected double porcentajeReparacion() {
		return 100;
	}

	@Override
	public void aplicarDanio(double cantidad) {
		this.porcentajeDanios += cantidad;
		if (this.porcentajeDanios > 100) {
			this.porcentajeDanios = 100;
		}
	}

	@Override
	public double getSalud() {
		return (this.ESTADOINICIAL - this.porcentajeDanios);
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		return superficie.esTierra();
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarARutas(this);
		mapa.agregarUnidadDaniable(this);
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	@Override
	public Element getElement(Document doc) {
		Element conector = doc.createElement("Ruta");

		Element costo = doc.createElement("costo");
		conector.appendChild(costo);
		costo.setTextContent(String.valueOf(this.costo));

		Element coordenadas = doc.createElement("coordenadas");
		conector.appendChild(coordenadas);
		coordenadas
				.setTextContent((String.valueOf((int) this.coordenadas.getX())
						+ "," + String.valueOf((int) this.coordenadas.getY())));

		Element porcentajeDanios = doc.createElement("porcentajeDanios");
		conector.appendChild(porcentajeDanios);
		porcentajeDanios.setTextContent(String.valueOf(this.porcentajeDanios));

		return conector;
	}

	public static Ruta fromElement(Node hijoDeUnidadDaniable) {
		Ruta rt = new Ruta();
		NodeList hijosDeUnidad = hijoDeUnidadDaniable.getChildNodes();

		for (int i = 0; i < hijosDeUnidad.getLength(); i++) {
			Node hijoDeUnidad = hijosDeUnidad.item(i);
			if (hijoDeUnidad.getNodeName().equals("costo")) {
				rt.costo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("coordenadas")) {
				String stringPunto = hijoDeUnidad.getTextContent();
				String[] arrayPunto = stringPunto.split(",");
				Coordenada punto = new Coordenada(
						Integer.valueOf(arrayPunto[0]),
						Integer.valueOf(arrayPunto[1]));
				rt.coordenadas = punto;
			} else if (hijoDeUnidad.getNodeName().equals("porcentajeDanios")) {
				rt.porcentajeDanios = Double.valueOf(hijoDeUnidad
						.getTextContent());
			}
		}
		return rt;
	}

	/* No evalua los invariantes de la clase */
	public boolean equals(Daniable rt) {
		if (rt == this) {
			return true;
		} else if (rt.coordenadas().getX() == this.coordenadas().getX()
				&& rt.coordenadas().getY() == this.coordenadas().getY()
				&& ((Ruta)rt).porcentajeDanios == this.porcentajeDanios) {
			return true;
		}
		return false;
	}
}
