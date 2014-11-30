package algo3.algocity.model;

import java.util.ArrayList;

public class Ruta extends Conector implements Visitable {
	
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

}
