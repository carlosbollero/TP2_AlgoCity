package algo3.algocity.model.catastrofes;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.mapas.Mapa;

public class CatastrofeTerremoto implements Visitante {

	int alto;
	int ancho;
	int radio;
	double tasa;
	Mapa mapa;
	Point epicentro;
	Random aleatorio;

	public CatastrofeTerremoto(Mapa mapa) {
		this.alto = mapa.alto();
		this.ancho = mapa.ancho();
		this.radio = 25;
		this.tasa = 1.5;
		this.epicentro = new Point(aleatorio.nextInt(this.ancho + 1),
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
		this.epicentro = new Point(x, y);
		this.mapa = mapa;
		this.actuar(calcularObjetivos());
	}

	private ArrayList<Daniable> calcularObjetivos() {
		ArrayList<Daniable> objetivos = new ArrayList<Daniable>();
		objetivos = this.mapa
				.getDaniablesAlrededorDe(this.epicentro, this.radio);
		return objetivos;
	}

	public void actuar(ArrayList<Daniable> objetivos) {
		for (Daniable u : objetivos) {
			u.aceptar(this);
		}
	}

//	@Override
//	public void visitar(Unidad unaUnidad) {
//		Point posicion = unaUnidad.getCoordenadas();
//		double danioAAplicar = this.calcularDanio(posicion);
//
//		unaUnidad.aplicarDanio(danioAAplicar);
//	}
	
	public void visitar(Daniable unaUnidad){
		Point posicion = unaUnidad.coordenadas();
		double danioAAplicar = this.calcularDanio(posicion);
		unaUnidad.aplicarDanio(danioAAplicar);
	}

	public double calcularDanio(Point punto) {
		double distancia = epicentro.distance(punto);
		double danio = 100 - (distancia * this.tasa);
		if (danio < 0) {
			danio = 0;
		}
		return danio;
	}

	@Override
	public void visitar(UnidadResidencial unaUnidadResidencial) {
		Point posicion = unaUnidadResidencial.coordenadas();
		double danioAAplicar = this.calcularDanio(posicion);

		unaUnidadResidencial.aplicarDanio(danioAAplicar);
	}

	@Override
	public void visitar(UnidadComercial unaUnidadComercial) {
		Point posicion = unaUnidadComercial.coordenadas();
		double danioAAplicar = this.calcularDanio(posicion);

		unaUnidadComercial.aplicarDanio(danioAAplicar);
	}

	@Override
	public void visitar(UnidadIndustrial unaUnidadIndustrial) {
		Point posicion = unaUnidadIndustrial.coordenadas();
		double danioAAplicar = this.calcularDanio(posicion);

		unaUnidadIndustrial.aplicarDanio(danioAAplicar);
	}

	@Override
	public void visitar(UnidadEnergetica unaUnidadEnergetica) {
		Point posicion = unaUnidadEnergetica.coordenadas();
		double danioAAplicar = this.calcularDanio(posicion);

		unaUnidadEnergetica.aplicarDanio(danioAAplicar);
	}

	@Override
	public void visitar(LineaTension unaLineaTension) {
		Point posicion = unaLineaTension.coordenadas();
		double danioAAplicar = this.calcularDanio(posicion);

		unaLineaTension.aplicarDanio(danioAAplicar);
	}

	@Override
	public void visitar(Ruta unaRuta) {
		Point posicion = unaRuta.coordenadas();
		double danioAAplicar = this.calcularDanio(posicion);

		unaRuta.aplicarDanio(danioAAplicar);
	}

}