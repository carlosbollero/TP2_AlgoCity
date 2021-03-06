package algo3.algocity.model.catastrofes;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import algo3.algocity.model.mapas.Mapa;

public class GeneradorCatastrofe extends Observable implements Observer {

	Catastrofe catastrofe;
	Mapa mapa;

	public GeneradorCatastrofe(Mapa map) {
		mapa = map;
	}

	public void initRandomCatastrofe() {
		Random aleatorio = new Random();
		if (aleatorio.nextInt(100) <= 8) {
			catastrofe = (aleatorio.nextInt(2) == 0) ? new CatastrofeGodzilla(
					mapa) : new CatastrofeTerremoto(mapa);
			System.out.println(catastrofe.getClass().getSimpleName());
			catastrofe.iniciar();
			setChanged();
			notifyObservers(catastrofe);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		initRandomCatastrofe();
	}

}
