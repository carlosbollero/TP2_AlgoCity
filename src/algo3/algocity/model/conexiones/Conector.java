package algo3.algocity.model.conexiones;

import java.awt.Point;

import algo3.algocity.model.terreno.Superficie;

public interface Conector{

	public Point getCoordenadas();

	public boolean esConstruibleEn(Superficie superficie);

}
