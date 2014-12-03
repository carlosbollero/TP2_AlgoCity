package algo3.algocity.model.construcciones;

import java.awt.Point;

import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public class CentralMinera extends UnidadEnergetica {

	public CentralMinera() {
		this.costo = 3000;
		this.capacidad = 400;
		this.radioDeInfluencia = 10;
	}

	public CentralMinera(int x, int y) {
		coordenadas = new Point(x, y);
		this.costo = 3000;
		this.capacidad = 400;
		this.radioDeInfluencia = 10;
	}

	public CentralMinera(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {

		this.costo = 3000;
		this.capacidad = 400;
		this.radioDeInfluencia = 10;
		this.coordenadas = new Point(x, y);
		if (!(esConstruibleEn(mapa.superficie(coordenadas)) && hayConexionesEn(mapa))) {
			throw new NoSeCumplenLosRequisitosException();
		}
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarACiudad(this);
		mapa.agregarPuntoRelevanteEnRedElectrica(coordenadas);
	}

}
