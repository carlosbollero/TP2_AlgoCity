package algo3.algocity.model.construcciones;

import java.awt.Point;

import algo3.algocity.model.catastrofes.CatastrofeTerremoto;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public class CentralEolica extends UnidadEnergetica {

	public CentralEolica() {
		this.costo = 1000;
		this.capacidad = 100;
		this.radioDeInfluencia = 4;
	}

	public CentralEolica(int x, int y) {
		coordenadas = new Point(x, y);
		this.costo = 1000;
		this.capacidad = 100;
		this.radioDeInfluencia = 4;
	}

	public CentralEolica(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {

		coordenadas = new Point(x, y);
		this.costo = 1000;
		this.capacidad = 100;
		if (!(esConstruibleEn(mapa.superficie(coordenadas)) && hayConexionesEn(mapa))) {
			throw new NoSeCumplenLosRequisitosException();
		}
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarACiudad(this);
		mapa.agregarUnidadDaniable(this);
		mapa.agregarPuntoRelevanteEnRedElectrica(coordenadas);
	}


}
