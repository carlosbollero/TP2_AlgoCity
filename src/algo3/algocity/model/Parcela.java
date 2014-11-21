/******************************************************************
 * 
 * Por la implementación de Point dentro de Mapa, Parcela empieza a 
 * carecer de sentido, por lo que hay que evaluar si realmente
 * se necesita.
 * 
 ******************************************************************/

package algo3.algocity.model;

public class Parcela {

	private int coordX;
	private int coordY;

	private Conector contenido;

	public Parcela(Conector contenido, int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.contenido = contenido;
//		this.contenido.setContenedor(this);
	}

	public int getCoordX() {
		return this.coordX;
	}

	public int getCoordY() {
		return this.coordY;
	}

	public Ubicable getContenido() {
		return this.contenido;
	}

	public boolean tieneCoordenadas(int x, int y) {
		return (x == this.coordX && y == coordY);
	}

	public boolean tieneContenido() {
		return (this.contenido != null);
	}

}
