package algo3.algocity.model;

public class Parcela {
	
	private int coordX;
	private int coordY;
<<<<<<< HEAD
	private Conector dato; //No deberia ser un conjunto de conectores??
	private Unidad unaUnidad;
=======
	private Ubicable contenido;
>>>>>>> b1bf6db82b43854cea7d8b224bbe09e6ade3681d
	
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

	public boolean tieneContenido() {
		return (this.contenido != null);
	}

}
