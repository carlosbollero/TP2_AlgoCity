package algo3.algocity.model;

import java.util.ArrayList;

public class UnidadComercial extends Unidad implements Reparable, Visitable{

	int consumo;
	final double ESTADOINICIAL = 100;
	double porcentajeDanios;

	public UnidadComercial() {
		this.costo = 5;
		this.consumo = 2;
	}

	public UnidadComercial(ArrayList<Mapa> mapas, int x, int y) {
		this.costo = 5;
		this.consumo = 2;
		this.coordX = x;
		this.coordY = y;
	}

	public int consumo() {
		return this.consumo;
	}

	@Override
	public void repararse() {
		// TODO Auto-generated method stub

	}

	@Override
	public void aplicarDanio(double cantidad) {
		if (this.porcentajeDanios > 100) {
			this.porcentajeDanios = 100;
		} else {
			this.porcentajeDanios += cantidad;
		}
	}

	@Override
	public double getSalud() {
		return (this.ESTADOINICIAL - this.porcentajeDanios);
	}
	
	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this); 
		
	}

	public void aplicarDanioGodzilla() {
		porcentajeDanios = 75;
		
	}

}