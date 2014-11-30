package algo3.algocity.model.catastrofes;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import algo3.algocity.model.LineaTension;
import algo3.algocity.model.Ruta;
import algo3.algocity.model.Unidad;
import algo3.algocity.model.UnidadComercial;
import algo3.algocity.model.UnidadEnergetica;
import algo3.algocity.model.UnidadIndustrial;
import algo3.algocity.model.UnidadResidencial;
import algo3.algocity.model.Visitable;
import algo3.algocity.model.Visitante;
import algo3.algocity.model.mapas.MapaEdilicio;

public class CatastrofeTerremoto implements Visitante {

	int alto;
	int ancho;
	int radio;
	double tasa;
	MapaEdilicio mapaEdilicio;
	Point epicentro;
	Random aleatorio;

	public CatastrofeTerremoto(MapaEdilicio me) {
		this.alto = me.getAlto();
		this.ancho = me.getAncho();
		this.radio = 25;
		this.tasa = 1.5;
		this.epicentro = new Point(aleatorio.nextInt(this.ancho + 1),
				aleatorio.nextInt(this.alto + 1));
		this.mapaEdilicio = me;
		calcularObjetivos();
	}

	// Usado para probar los tests, fija una posicion de epicentro
	public CatastrofeTerremoto(MapaEdilicio me, int x, int y) {
		this.alto = me.getAlto();
		this.ancho = me.getAncho();
		this.radio = 25;
		this.tasa = 1.5;
		this.epicentro = new Point(x, y);
		this.mapaEdilicio = me;
		this.actuar(calcularObjetivos());
	}

	private ArrayList<Visitable> calcularObjetivos() {
		ArrayList<Visitable> objetivos = new ArrayList<Visitable>();
		objetivos = this.mapaEdilicio.getUnidadesAlrededorDe(this.epicentro,
				this.radio);
		return objetivos;
	}

	public void actuar(ArrayList<Visitable> objetivos) {
		for (Visitable u : objetivos) {
			u.aceptar(this);
		}
	}

	@Override
	public void visitar(Unidad unaUnidad) {
		Point posicion = unaUnidad.getCoordenadas();
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
		Point posicion = unaUnidadResidencial.getCoordenadas();
		double danioAAplicar = this.calcularDanio(posicion);
		
		unaUnidadResidencial.aplicarDanio(danioAAplicar);
	}

	@Override
	public void visitar(UnidadComercial unaUnidadComercial) {
		Point posicion = unaUnidadComercial.getCoordenadas();
		double danioAAplicar = this.calcularDanio(posicion);
		
		unaUnidadComercial.aplicarDanio(danioAAplicar);
	}

	@Override
	public void visitar(UnidadIndustrial unaUnidadIndustrial) {
		Point posicion = unaUnidadIndustrial.getCoordenadas();
		double danioAAplicar = this.calcularDanio(posicion);
		
		unaUnidadIndustrial.aplicarDanio(danioAAplicar);
	}

	@Override
	public void visitar(UnidadEnergetica unaUnidadEnergetica) {
		Point posicion = unaUnidadEnergetica.getCoordenadas();
		double danioAAplicar = this.calcularDanio(posicion);
		
		unaUnidadEnergetica.aplicarDanio(danioAAplicar);
	}

	@Override
	public void visitar(LineaTension unaLineaTension) {
		Point posicion = unaLineaTension.getCoordenadas();
		double danioAAplicar = this.calcularDanio(posicion);
		
		unaLineaTension.aplicarDanio(danioAAplicar);
	}

	@Override
	public void visitar(Ruta unaRuta) {
		Point posicion = unaRuta.getCoordenadas();
		double danioAAplicar = this.calcularDanio(posicion);
		
		unaRuta.aplicarDanio(danioAAplicar);
	}

}
