package algo3.algocity.model.construcciones;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Ocupable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class UnidadResidencial extends Unidad implements Ocupable, Daniable, Visitable {

	final double ESTADOINICIAL = 100;

	int capacidad; // capacidad habitacional
	double porcentajeDanios;

	public UnidadResidencial() {
		this.costo = 5;
		this.consumo = 1;
		this.capacidad = 100;
	}

	public UnidadResidencial(int x, int y) {
		coordenadas = new Coordenada(x, y);
		this.costo = 5;
		this.consumo = 1;
		this.capacidad = 100;
	}

	public UnidadResidencial(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {
		this.costo = 5;
		this.consumo = 1;
		this.capacidad = 100;
		coordenadas = new Coordenada(x, y);
		
		if (!(esConstruibleEn(mapa.superficie(coordenadas)) || !hayConexionesEn(mapa))) {
			throw new NoSeCumplenLosRequisitosException();
		}
		/*
		if (!(esConstruibleEn(mapa.superficie(coordenadas)) && hayConexionesEn(mapa))) {
			throw new NoSeCumplenLosRequisitosException();
		}
		*/
	}

	public void aplicarDanioGodzilla() {
		porcentajeDanios = 100;

	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this);
	}

	public int capacidad() {
		return this.capacidad;
	}

	public double getDanios() {
		return porcentajeDanios;
	}

	public double getSalud() {
		return (this.ESTADOINICIAL - this.porcentajeDanios);
	}

	@Override
	public void repararse() {
		this.porcentajeDanios -= this.porcentajeReparacion();
		if (this.getDanios() < 0) {
			this.porcentajeDanios = 0;
		}
	}

	protected double porcentajeReparacion() {
		return (this.ESTADOINICIAL * 10) / 100;
	}
	
	public void aplicarDanio(double cantidad) {
		this.porcentajeDanios += cantidad;
		if (this.porcentajeDanios > 100) {
			this.porcentajeDanios = 100;
		}
	}

	private boolean hayConexionesEn(Mapa mapa) {
		return (mapa.hayConexionCompleta(coordenadas));
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		return superficie.esTierra();
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarACiudad(this);
		mapa.agregarUnidadConPoblacion(this);
		mapa.agregarUnidadDaniable(this);
	}

	
	
	
	/* Persistencia */
	@Override
	public Element getElement(Document doc) {

		Element unidad = doc.createElement("UnidadResidencial");

		Element costo = doc.createElement("costo");
		unidad.appendChild(costo);
		costo.setTextContent(String.valueOf(this.costo));

		Element consumo = doc.createElement("consumo");
		unidad.appendChild(consumo);
		consumo.setTextContent(String.valueOf(this.consumo));

		Element capacidad = doc.createElement("capacidad");
		unidad.appendChild(capacidad);
		capacidad.setTextContent(String.valueOf(this.capacidad));

		Element coordenadas = doc.createElement("coordenadas");
		unidad.appendChild(coordenadas);
		coordenadas
				.setTextContent((String.valueOf((int) this.coordenadas.getX())
						+ "," + String.valueOf((int) this.coordenadas.getY())));

		Element porcentajeDanios = doc.createElement("porcentajeDanios");
		unidad.appendChild(porcentajeDanios);
		porcentajeDanios.setTextContent(String.valueOf(this.porcentajeDanios));

		return unidad;
	}

	public static UnidadResidencial fromElement(Node hijoDeNodo) {
		UnidadResidencial ur = new UnidadResidencial();
		NodeList hijosDeUnidad = hijoDeNodo.getChildNodes();

		for (int i = 0; i < hijosDeUnidad.getLength(); i++) {
			Node hijoDeUnidad = hijosDeUnidad.item(i);
			if (hijoDeUnidad.getNodeName().equals("costo")) {
				ur.costo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("consumo")) {
				ur.consumo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("capacidad")) {
				ur.capacidad = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("coordenadas")) {
				String stringPunto = hijoDeUnidad.getTextContent();
				String[] arrayPunto = stringPunto.split(",");
				Coordenada punto = new Coordenada(
						Integer.valueOf(arrayPunto[0]),
						Integer.valueOf(arrayPunto[1]));
				ur.coordenadas = punto;
			} else if (hijoDeUnidad.getNodeName().equals("porcentajeDanios")) {
				ur.porcentajeDanios = Double.valueOf(hijoDeUnidad
						.getTextContent());
			}
		}
		return ur;
	}

}
