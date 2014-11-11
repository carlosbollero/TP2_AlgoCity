package algo3.algocity.model;

public class LineaDeTension extends Conector {
	
	static final int COSTO = 5;
	LineaDeTension conexion;
	
	public LineaDeTension() {
		// TODO Auto-generated constructor stub
	}
	
	public void conectarLineDeTension(LineaDeTension unaLineaDeTension){
		conexion = unaLineaDeTension;
	}

}
