package algo3.algocity.model;

public class Parcela {
	
	private int coordX;
	private int coordY;
	private Conector dato; //No deberia ser un conjunto de conectores??
	private Unidad unaUnidad;
	
	public Parcela(Unidad unaUnidad, int coordX, int coordY){
		this.coordX = coordX;
		this.coordY = coordY;
		this.unaUnidad = unaUnidad;
	}
	
	public int getCoordX(){
		return this.coordX;
	}
	
	public int getCoordY(){
		return this.coordY;
	}
	
	public Conector getDato(){
		return this.dato;
	}
	
	public Unidad getUnidad(){
		return this.unaUnidad;
	}
	
	public boolean tieneCoordenadas(int x, int y){
		return (x == this.coordX && y == coordY);
	}

	public boolean tieneUnidad() {
		return (this.unaUnidad != null);
	}

}
