package algo3.algocity.model;

public class Ruta extends Conector implements Visitable {
	
	boolean estado;

	public Ruta() {
		this.costo = 10;
	}
	
	public boolean estado(){
		return estado;
	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this); 
		
	}
	
	public void aplicarDanioGodzilla() {
		estado = false;
		
	}

}
