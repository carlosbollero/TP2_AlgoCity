package algo3.algocity.model.construcciones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import algo3.algocity.model.Constantes;
import algo3.algocity.model.Dinero;
import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.excepciones.CoordenadaInvalidaException;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoHayConexionConTuberias;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.excepciones.SuperficieInvalidaParaConstruir;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class CentralEolica extends UnidadEnergetica {
	
	public CentralEolica() {
		super(1000, 100, 4);
	}

	public CentralEolica(Coordenada coord) {
		super(1000, 100, 4);
		coordenada = coord;
	}

	public CentralEolica(Mapa mapa, Dinero dinero, Coordenada coord)
			throws NoSeCumplenLosRequisitosException,
			FondosInsuficientesException, SuperficieInvalidaParaConstruir,
			NoHayConexionConTuberias, CoordenadaInvalidaException {
		super(Constantes.COSTO_C_EOLICA, Constantes.CAPACIDAD_C_EOLICA, Constantes.RADIO_C_EOLICA);
		this.coordenada = coord;
		mapa.validarCoordenadas(coord);
		esConstruibleEn(mapa.superficie(coordenada));
		hayConexionesEn(mapa);
		mapa.sistemaElectrico().aumentarCapacidad(capacidad);
		dinero.cobrar(costo);
	}

	protected double porcentajeReparacion() {
		return (this.ESTADOINICIAL * 15) / 100;
	}

	@Override
	public void repararse() {
		this.porcentajeDanios -= this.porcentajeReparacion();
		if (this.getDanios() < 0) {
			this.porcentajeDanios = 0;
		}
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	@Override
	public Element getElement(Document doc) {
		Element unidad = doc.createElement("CentralEolica");

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
				.setTextContent((String.valueOf((int) this.coordenada.getX())
						+ "," + String.valueOf((int) this.coordenada.getY())));

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
	public boolean equals(Unidad ce) {
		if (ce == this) {
			return true;
		} else if (ce.coordenada().getX() == this.coordenada().getX()
				&& ce.coordenada().getY() == this.coordenada().getY()
				&& ((UnidadEnergetica) ce).porcentajeDanios == this.porcentajeDanios) {
			return true;
		}
		return false;
	}

}
