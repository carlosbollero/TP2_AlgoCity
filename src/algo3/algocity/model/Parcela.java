package algo3.algocity.model;

public class Parcela {
	
	private int coordX;
	private int coordY;
<<<<<<< HEAD
<<<<<<< HEAD

	private Conector dato; //
	private Unidad unaUnidad;//Estos dos datos unificados en uno, porque va a haber mapas para c/cosa

=======
>>>>>>> 18797e2c0548d036388d373d0be623ae1d5117f5
=======
>>>>>>> 18797e2c0548d036388d373d0be623ae1d5117f5
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

	public boolean tieneContenido() {
		return (this.contenido != null);
	}

}
