package algo3.algocity.model.construcciones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.SistemaElectrico;
import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.NoSePuedeConstruirEnSuperficie;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class CentralMinera extends UnidadEnergetica {

	public CentralMinera() {
		this.costo = 3000;
		this.capacidad = 400;
		this.radioDeInfluencia = 10;
	}

	public CentralMinera(Coordenada coord) {
		coordenadas = coord;
		this.costo = 3000;
		this.capacidad = 400;
		this.radioDeInfluencia = 10;
	}

	public CentralMinera(Mapa mapa, Dinero dinero,
			SistemaElectrico sisElectrico, Coordenada coord)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, NoSePuedeConstruirEnSuperficie,
			NoHayConexionConTuberias {

		this.costo = 3000;
		this.capacidad = 400;
		this.radioDeInfluencia = 10;
		this.coordenadas = coord;
		if (!esConstruibleEn(mapa.superficie(coordenadas))
				|| !hayConexionesEn(mapa)) {
			throw new NoSeCumplenLosRequisitosException();
		}
		sisElectrico.aumentarCapacidad(capacidad);
		dinero.cobrar(costo);
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

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarACiudad(this);
		mapa.agregarUnidadDaniable(this);
		mapa.agregarPuntoRelevanteEnRedElectrica(this);
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	@Override
	public Element getElement(Document doc) {
		Element unidad = doc.createElement("CentralMinera");

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

		Element radioDeInfluencia = doc.createElement("radioDeInfluencia");
		unidad.appendChild(radioDeInfluencia);
		radioDeInfluencia
				.setTextContent(String.valueOf(this.radioDeInfluencia));

		return unidad;
	}

	/* No evalua los invariantes de la clase */
	public boolean equals(Daniable cm) {
		if (cm == this) {
			return true;
		} else if (cm.coordenadas().getX() == this.coordenadas().getX()
				&& cm.coordenadas().getY() == this.coordenadas().getY()
				&& ((CentralMinera) cm).porcentajeDanios == this.porcentajeDanios) {
			return true;
		}
		return false;
	}

}
