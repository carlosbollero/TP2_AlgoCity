package algo3.algocity.model;

import java.awt.Point;
import java.util.ArrayList;

public class LineaTension extends Conector implements Reparable, Visitable {
	
	final boolean intacto = true;
	final boolean destruido = false;
	
	boolean estado; 	//true para intacto
						//false para destruido

	public LineaTension() {

		this.costo = 5;
	}
	
	public LineaTension(ArrayList<Mapa> mapas, int x, int y) {
		this.costo = 5;
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

	@Override
	public void repararse() {
		// TODO Auto-generated method stub
		
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

	public Point getCoordenadas() {
		return new Point(this.coordX,this.coordY);
	}
}
