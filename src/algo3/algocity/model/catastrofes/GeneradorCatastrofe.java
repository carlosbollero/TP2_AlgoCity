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
		System.out.println("iniciando random catastrofe--dentro del emtodo");
		Random aleatorio = new Random();
		System.out.println("inicia random catastrofe");
		if (aleatorio.nextInt(100) <= 90) {
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
		System.out.println("iniciando random catastrofe");
		initRandomCatastrofe();
	}

}
