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

public class UnidadIndustrial extends Unidad implements Ocupable, Daniable,
		Visitable {

	final double ESTADOINICIAL = 100;
	int capacidad; // capacidad habitacional
	int ocupacion;
	double porcentajeDanios;

	public UnidadIndustrial() {
		this.costo = 10;
		this.consumo = 5;
		this.capacidad = 25;
	}

	public UnidadIndustrial(int x, int y) {
		coordenadas = new Coordenada(x, y);
		this.costo = 10;
		this.consumo = 5;
		this.capacidad = 25;
	}

	public UnidadIndustrial(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {

		coordenadas = new Coordenada(x, y);
		this.costo = 10;
		this.consumo = 5;
		this.capacidad = 25;
		coordenadas = new Coordenada(x, y);
		if (!(esConstruibleEn(mapa.superficie(coordenadas)) && !hayConexionesEn(mapa))) {
			throw new NoSeCumplenLosRequisitosException();
		}
		/*
		if (!(esConstruibleEn(mapa.superficie(coordenadas)) && hayConexionesEn(mapa))) {
			// if (!mapa.sePuedeConstruir(this)){
			throw new NoSeCumplenLosRequisitosException();
		}
		*/
	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this);

	}

	public void aplicarDanioGodzilla() {
		porcentajeDanios = 40;

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

	public void aplicarDanio(double cantidad) {
		this.porcentajeDanios += cantidad;
		if (this.porcentajeDanios > 100) {
			this.porcentajeDanios = 100;
		}
	}

	protected double porcentajeReparacion() {
		return (this.ESTADOINICIAL * 3) / 100;
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		return superficie.esTierra();
	}

	private boolean hayConexionesEn(Mapa mapa) {
		return (mapa.hayConexionConRedElectrica(coordenadas) && mapa
				.hayConexionConRutas(coordenadas));
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarACiudad(this);
		mapa.agregarUnidadConEmpleo(this);
		mapa.agregarUnidadDaniable(this);
	}

	/* Persistencia */
	@Override
	public Element getElement(Document doc) {

		Element unidad = doc.createElement("UnidadIndustrial");

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

	public static UnidadIndustrial fromElement(Node hijoDeNodo) {

		UnidadIndustrial ui = new UnidadIndustrial();
		NodeList hijosDeUnidad = hijoDeNodo.getChildNodes();

		for (int i = 0; i < hijosDeUnidad.getLength(); i++) {
			Node hijoDeUnidad = hijosDeUnidad.item(i);
			if (hijoDeUnidad.getNodeName().equals("costo")) {
				ui.costo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("consumo")) {
				ui.consumo = Integer.valueOf(hijoDeUnidad.getTextContent());
				;
			} else if (hijoDeUnidad.getNodeName().equals("capacidad")) {
				ui.capacidad = Integer.valueOf(hijoDeUnidad.getTextContent());
				;
			} else if (hijoDeUnidad.getNodeName().equals("porcentajeDanios")) {
				ui.porcentajeDanios = Double.valueOf(hijoDeUnidad
						.getTextContent());
				;
			} else if (hijoDeUnidad.getNodeName().equals("coordenadas")) {
				String stringPunto = hijoDeUnidad.getTextContent();
				String[] arrayPunto = stringPunto.split(",");
				Coordenada punto = new Coordenada(
						Integer.valueOf(arrayPunto[0]),
						Integer.valueOf(arrayPunto[1]));
				ui.coordenadas = punto;
			}
		}
		return ui;
	}

}
