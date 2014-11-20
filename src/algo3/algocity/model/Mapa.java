package algo3.algocity.model;


//import org.jgrapht.graph.DefaultEdge;
//import org.jgrapht.graph.ListenableUndirectedGraph;

public abstract class Mapa {

	int alto;
	int ancho;

	public Mapa(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
	}

	public abstract boolean agregar(Ubicable elemento, int i, int j);
	public abstract void remover(int x, int y);

	protected boolean estaDentroDeLimites(int i, int j) {
		return ((i >= 0) && (i <= this.alto) && (j >= 0) && (j <= this.ancho));
	}

	public abstract boolean tieneCoordenadaOcupada(int i, int j);

	public abstract boolean contiene(Ubicable unaUnidad);

	protected abstract boolean estaVacio();

}
