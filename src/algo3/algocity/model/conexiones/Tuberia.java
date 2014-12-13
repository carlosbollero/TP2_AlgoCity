package algo3.algocity.model.conexiones;

import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class Tuberia implements Conector {

	int costo;
	int danios;
	Coordenada coordenadas;

	public Tuberia() {
		costo = 5;
	}
	
	public Tuberia(int x, int y) {
		costo = 5;
		coordenadas = new Coordenada(x, y);
	}

	public Tuberia(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {
		costo = 5;
		coordenadas = new Coordenada(x, y);
		if (!esConstruibleEn(mapa.superficie(coordenadas))) {
			throw new NoSeCumplenLosRequisitosException();
		} else {
			mapa.agregar(this);
		}
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		return (superficie.esTierra() || superficie.esAgua());
	}

	@Override
	public Coordenada coordenadas() {
		return coordenadas;
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarATuberias(this);
	}

	@Override
	public double getSalud() {
		// TODO Auto-generated method stub
		return 100;
	}

}
