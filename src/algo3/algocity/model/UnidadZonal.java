package algo3.algocity.model;

public abstract class UnidadZonal extends Unidad {
	
	// TODO Revisar de que forma conviene que esten estos atributos,
	// si constantes o de clase
	static final int AREA = 1;
	static int consumo;
	int danios;
	
	public UnidadZonal(){
		danios = 0;
	}

	public int getArea() {
		return AREA;
	}

	public int getConsumo() {
		return consumo;
	}

	public int getDanios() {
		return danios;
	}
	
	public void aplicarDanio(int porcentaje){
		if (danios + porcentaje >= 100){
			danios = 100;
		}else{
			danios += porcentaje;
		}
	}
	
	public void repararDanio(int porcentaje){
		if (danios - porcentaje < 0){
			danios = 0;
		}else{
			danios -= porcentaje;
		}
	}


}
