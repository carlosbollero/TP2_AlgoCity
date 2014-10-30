package algo3.algocity.model;

public abstract class Unidad {
	static int area;
	static int costo;
	static int consumo;
	int danios;
	
	public Unidad(){
		area = 1;
		danios = 0;
	}

	public int getCosto() {
		return costo;
	}

	public Object getArea() {
		return area;
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
