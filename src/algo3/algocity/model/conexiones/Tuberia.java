package algo3.algocity.model.conexiones;

import java.awt.Point;

import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class Tuberia implements Conector {

	int costo;
	int danios;
	Point coordenadas;

	public Tuberia() {
		costo = 5;
	}

	public Tuberia(Mapa mapa, int x, int y) throws NoSeCumplenLosRequisitosException {
		costo = 5;
		coordenadas = new Point(x, y);
		if (!esConstruibleEn(mapa.getSuperficie(coordenadas))){
			throw new NoSeCumplenLosRequisitosException();
		}
	}
	
	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		return superficie.esTierra();
	}

	@Override
	public Point getCoordenadas() {
		return coordenadas;
	}

}