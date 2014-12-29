package algo3.algocity.model.catastrofes;

import java.util.Random;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class CatastrofeTerremoto implements Catastrofe {
	
	int tamanio;
	int radio;
	double tasa;
	Mapa mapa;
	Coordenada epicentro;
	Random aleatorio;

	public CatastrofeTerremoto(Mapa mapa) {
		tamanio = mapa.tamanio();
		radio = 25;
		tasa = 1.5;
		aleatorio = new Random();
		epicentro = new Coordenada(aleatorio.nextInt(tamanio),
				aleatorio.nextInt(tamanio));
		this.mapa = mapa;
		// actuar(calcularObjetivos());
		// actuar();
	}

	// Usado para probar los tests, fija una posicion de epicentro
	public CatastrofeTerremoto(Mapa mapa, int x, int y) {
		tamanio = mapa.tamanio();
		radio = 25;
		tasa = 1.5;
		aleatorio = new Random();
		epicentro = new Coordenada(x, y);
		this.mapa = mapa;
		// this.actuar(calcularObjetivos());
		// actuar();
	}

	@Override
	public void iniciar() {
		System.out.println("iniciando terremoto");
		actuar();
	}

	public void actuar() {
		System.out.println("terremoto actuando....");
		System.out.println("epicentro: "+epicentro.getX()+","+epicentro.getY());

		for (Daniable u : mapa.unidadesDaniables()) {
			int distancia = epicentro.distancia(u.coordenada());
			System.out.println("evaluando radio...");
			if (distancia <= radio) {
				System.out.println("dentro dele radio del terremoto...");
				u.aplicarDanio(100 - (distancia * 1.5));
				System.out.println("terremoto aplico danio"+(100 - (distancia * 1.5))+"a"+u.getClass()+"en"+u.coordenada().getX()+","+u.coordenada().getY());
				System.out.println("salud unidad: "+u.getSalud());
			}
		}
		System.out.println("terremoto saliendo del for....");
		System.out.println("termino");
	}
}