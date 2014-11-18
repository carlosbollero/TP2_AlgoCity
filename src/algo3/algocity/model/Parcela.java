package algo3.algocity.model;

public class Parcela {
	
	private int coordX;
	private int coordY;
	private Ubicable contenido;
	
	public Parcela(Ubicable contenido, int coordX, int coordY){
		this.coordX = coordX;
		this.coordY = coordY;
		this.contenido = contenido;
	}
	
	public int getCoordX(){
		return this.coordX;
	}
	
	public int getCoordY(){
		return this.coordY;
	}

	
	public Ubicable getContenido(){
		return this.contenido;
	}
	
	public boolean tieneCoordenadas(int x, int y){
		return (x == this.coordX && y == coordY);
	}

	public boolean tieneUnidad() {
		return (this.contenido != null);
	}

}
