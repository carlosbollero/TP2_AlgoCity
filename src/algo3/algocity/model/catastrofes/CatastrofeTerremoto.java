package algo3.algocity.model.catastrofes;

import java.util.ArrayList;
import java.util.Random;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class CatastrofeTerremoto implements Visitante {

	int alto;
	int ancho;
	int radio;
	double tasa;
	Mapa mapa;
	Coordenada epicentro;
	Random aleatorio;

	public CatastrofeTerremoto(Mapa mapa) {
		this.alto = mapa.alto();
		this.ancho = mapa.ancho();
		this.radio = 25;
		this.tasa = 1.5;
		this.epicentro = new Coordenada(aleatorio.nextInt(this.ancho + 1),
				aleatorio.nextInt(this.alto + 1));
		this.mapa = mapa;
		actuar(calcularObjetivos());
	}

	// Usado para probar los tests, fija una posicion de epicentro
	public CatastrofeTerremoto(Mapa mapa, int x, int y) {
		this.alto = mapa.alto();
		this.ancho = mapa.ancho();
		this.radio = 25;
		this.tasa = 1.5;
		this.epicentro = new Coordenada(x, y);
		this.mapa = mapa;
		this.actuar(calcularObjetivos());
	}

	private ArrayList<Daniable> calcularObjetivos() {
		ArrayList<Daniable> objetivos = new ArrayList<Daniable>();
		objetivos = this.mapa.getDaniablesAlrededorDe(this.epicentro,
				this.radio);
		//
		return objetivos;
	}

	public void actuar(ArrayList<Daniable> objetivos) {
		for (Daniable u : objetivos) {
			u.aceptar(this);
		}
	}

	// @Override
	// public void visitar(Unidad unaUnidad) {
	// Point posicion = unaUnidad.getCoordenadas();
	// double danioAAplicar = this.calcularDanio(posicion);
	//
	// unaUnidad.aplicarDanio(danioAAplicar);
	// }

	public void visitar(Daniable unaUnidad) {
		Coordenada posicion = unaUnidad.coordenada();
		double danio = this.calcularDanio(posicion);
		unaUnidad.aplicarDanio(danio);
	}

	public double calcularDanio(Coordenada punto) {
		double distancia = epicentro.distancia(punto);
		double danio = 100 - (distancia * this.tasa);
		if (danio < 0) {
			danio = 0;
		}
		return danio;
	}

	@Override
	public void visitar(UnidadResidencial unaUnidadResidencial) {
		Coordenada posicion = unaUnidadResidencial.coordenada();
		double danio = this.calcularDanio(posicion);

		unaUnidadResidencial.aplicarDanio(danio);
	}

	@Override
	public void visitar(UnidadComercial unaUnidadComercial) {
		Coordenada posicion = unaUnidadComercial.coordenada();
		double danio = this.calcularDanio(posicion);

		unaUnidadComercial.aplicarDanio(danio);
	}

	@Override
	public void visitar(UnidadIndustrial unaUnidadIndustrial) {
		Coordenada posicion = unaUnidadIndustrial.coordenada();
		double danio = this.calcularDanio(posicion);

		unaUnidadIndustrial.aplicarDanio(danio);
	}

	@Override
	public void visitar(UnidadEnergetica unaUnidadEnergetica) {
		Coordenada posicion = unaUnidadEnergetica.coordenada();
		double danio = this.calcularDanio(posicion);

		unaUnidadEnergetica.aplicarDanio(danio);
	}

	@Override
	public void visitar(LineaTension unaLineaTension) {
		Coordenada posicion = unaLineaTension.coordenada();
		double danio = this.calcularDanio(posicion);

		unaLineaTension.aplicarDanio(danio);
	}

	@Override
	public void visitar(Ruta unaRuta) {
		Coordenada posicion = unaRuta.coordenada();
		double danio = this.calcularDanio(posicion);

		unaRuta.aplicarDanio(danio);
	}

}