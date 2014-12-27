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
		epicentro = new Coordenada(x, y);
		this.mapa = mapa;
		// this.actuar(calcularObjetivos());
		// actuar();
	}

	@Override
	public void iniciar() {
		actuar();

	}

	public void actuar() {
		for (Daniable u : mapa.unidadesDaniables()) {
			int distancia = epicentro.distancia(u.coordenada());
			if (distancia <= radio) {
				u.aplicarDanio(100 - (distancia * 1.5));
			}
		}
	}

	// public double calcularDanio(Coordenada punto) {
	// double distancia = epicentro.distancia(punto);
	// double danio = 100 - (distancia * this.tasa);
	// if (danio < 0) {
	// danio = 0;
	// }
	// return danio;
	// }

	// private ArrayList<Daniable> calcularObjetivos() {
	// ArrayList<Daniable> objetivos = new ArrayList<Daniable>();
	// objetivos = this.mapa.getDaniablesAlrededorDe(this.epicentro,
	// this.radio);
	// //
	// return objetivos;
	// }

	// public void actuar(ArrayList<Daniable> objetivos) {
	// for (Daniable u : objetivos) {
	// u.aceptar(this);
	// }
	// }

	// @Override
	// public void visitar(Unidad unaUnidad) {
	// Point posicion = unaUnidad.getCoordenadas();
	// double danioAAplicar = this.calcularDanio(posicion);
	//
	// unaUnidad.aplicarDanio(danioAAplicar);
	// }

	// public void visitar(Daniable unaUnidad) {
	// Coordenada posicion = unaUnidad.coordenada();
	// double danio = this.calcularDanio(posicion);
	// unaUnidad.aplicarDanio(danio);
	// }
	//
	//
	// @Override
	// public void visitar(UnidadResidencial unaUnidadResidencial) {
	// Coordenada posicion = unaUnidadResidencial.coordenada();
	// double danio = this.calcularDanio(posicion);
	//
	// unaUnidadResidencial.aplicarDanio(danio);
	// }
	//
	// @Override
	// public void visitar(UnidadComercial unaUnidadComercial) {
	// Coordenada posicion = unaUnidadComercial.coordenada();
	// double danio = this.calcularDanio(posicion);
	//
	// unaUnidadComercial.aplicarDanio(danio);
	// }
	//
	// @Override
	// public void visitar(UnidadIndustrial unaUnidadIndustrial) {
	// Coordenada posicion = unaUnidadIndustrial.coordenada();
	// double danio = this.calcularDanio(posicion);
	//
	// unaUnidadIndustrial.aplicarDanio(danio);
	// }
	//
	// @Override
	// public void visitar(UnidadEnergetica unaUnidadEnergetica) {
	// Coordenada posicion = unaUnidadEnergetica.coordenada();
	// double danio = this.calcularDanio(posicion);
	//
	// unaUnidadEnergetica.aplicarDanio(danio);
	// }
	//
	// @Override
	// public void visitar(LineaTension unaLineaTension) {
	// Coordenada posicion = unaLineaTension.coordenada();
	// double danio = this.calcularDanio(posicion);
	//
	// unaLineaTension.aplicarDanio(danio);
	// }
	//
	// @Override
	// public void visitar(Ruta unaRuta) {
	// Coordenada posicion = unaRuta.coordenada();
	// double danio = this.calcularDanio(posicion);
	//
	// unaRuta.aplicarDanio(danio);
	// }

}