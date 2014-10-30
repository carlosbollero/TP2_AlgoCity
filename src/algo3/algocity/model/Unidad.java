package algo3.algocity.model;

public abstract class Unidad {
	
	// TODO Revisar de que forma conviene que esten estos atrivutos
	// si constantes o de clase
	static final int AREA = 1;
	static int costo;
	static int consumo;
	int danios;
	
	public Unidad(){
		danios = 0;
	}

	public int getCosto() {
		return costo;
	}

	public Object getArea() {
		return AREA;
	}

	public Object getConsumo() {
		return consumo;
	}

	public Object getDanios() {
		return danios;
	}
	
	public void aplicarDanio(int porcentaje){
		if (danios + porcentaje >= 100){
			danios = 100;
		}
		else{
			danios += porcentaje;
		}
	}

}
