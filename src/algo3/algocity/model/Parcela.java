package algo3.algocity.model;

public class Parcela {
	
	private int coordX;
	private int coordY;
	private Conector dato;
	
	public Parcela(int coordX, int coordY){
		this.coordX = coordX;
		this.coordY = coordY;
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

}
