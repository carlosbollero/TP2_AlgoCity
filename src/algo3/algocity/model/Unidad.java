package algo3.algocity.model;

import java.util.ArrayList;

public abstract class Unidad implements Ubicable {

	int costo;
	ArrayList<Requisito> requisitos; //tres atributos estaConectadoA por cada cosa o una instancia de Requisito para cada requisito

	public int getCosto() {
		return this.costo;
	}
	
	public ArrayList<Requisito> getRequisitos(){
		return this.requisitos;
	}
	
	//la idea es desde mapa ir consultando a todas las unidades del mapa 
	//y preguntandoles si estan conectadas, y que cada unidad almacene sus requisitos de conexion
	//y devuelva si esta conectada o no
	
}
