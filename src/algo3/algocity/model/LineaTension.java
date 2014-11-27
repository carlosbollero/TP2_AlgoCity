package algo3.algocity.model;

public class LineaTension extends Conector implements Reparable, Visitable {
	
	final boolean intacto = true;
	final boolean destruido = false;
	
	boolean estado; 	//true para intacto
						//false para destruido

	public LineaTension() {

		this.costo = 5;
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
	public void aplicarDanio(int unDanio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSalud() {
		// TODO Auto-generated method stub
		return 0;
	}
}
