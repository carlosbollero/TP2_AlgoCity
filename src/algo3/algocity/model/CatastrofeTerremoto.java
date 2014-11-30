package algo3.algocity.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

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
//		Point posicion = unaUnidad.getCoordenadas();
//		int danioAAplicar = this.calcularDanio(posicion);
		
		//unaUnidad.aplicarDanio(danioAAplicar);
		unaUnidad.aplicarDanio(100);
	}

	public int calcularDanio(Point punto) {
		double distancia = epicentro.distance(punto);
		double danio = 100 - (distancia * this.tasa);
		if (danio < 0) {
			danio = 0;
		}
		return (int) danio;
	}

	@Override
	public void visitar(UnidadResidencial unaUnidadResidencial) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitar(UnidadComercial unaUnidadComercial) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitar(UnidadIndustrial unaUnidadIndustrial) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitar(UnidadEnergetica unaUnidadEnergetica) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitar(LineaTension unaLineaTension) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitar(Ruta unaRuta) {
		// TODO Auto-generated method stub

	}

}
