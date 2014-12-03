package algo3.algocity.model.construcciones;

public class Danio {
	
//	ANALIZAR SI VALE LA PENA ESTA CLASE
//	PARA AISLAR LA PARTE DE DANIOS DE CADA UNIDAD
//	Y QUE C/UNIDAD TENA UN ATRIBUTO DE ESTA CLASE
	
	double porcentaje;
	
	public Danio(){
		porcentaje = 0;
	}
	
	public void aplicarDanioGodzilla() {
		porcentaje = 100;
	}
	
	public void aplicarDanio(int porcentaje){
		this.porcentaje += porcentaje;
	}
	
	public void aplicarDanio(double porcentaje){
		this.porcentaje += porcentaje;
	}
	
	public double get(){
		return porcentaje;
	}

}
