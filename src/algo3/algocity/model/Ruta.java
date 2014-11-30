package algo3.algocity.model;

import java.awt.Point;
import java.util.ArrayList;

import algo3.algocity.model.mapas.Mapa;

public class Ruta extends Conector implements Reparable,Visitable {
	
	final boolean intacto = true;
	final boolean destruido = false;
	
	boolean estado;

	public Ruta() {
		this.costo = 10;
	}
	
	public Ruta(ArrayList<Mapa> mapas, int x, int y) {
		this.costo = 10;
		this.coordX = x;
		this.coordY = y;
	}

	public boolean estado(){
		return estado;
	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this); 
		
	}
	
	public void aplicarDanioGodzilla() {
		estado = destruido;
		
	}

	public void repararse() {
		estado = intacto;
		
	}

	public Point getCoordenadas() {
		return new Point(this.coordX,this.coordY);
	}

	@Override
	public void aplicarDanio(double unDanio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getSalud() {
		// TODO Auto-generated method stub
		return 0;
	}

}
