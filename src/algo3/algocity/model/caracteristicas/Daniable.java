package algo3.algocity.model.caracteristicas;

import algo3.algocity.model.mapas.Coordenada;

public interface Daniable {

	public void repararse();

	public void aplicarDanio(double unDanio);

	public double getSalud();

	public Coordenada coordenadas();
	
	public void aceptar(Visitante v);

}
