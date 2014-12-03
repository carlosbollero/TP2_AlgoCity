package algo3.algocity.model.conexiones;

import java.awt.Point;

import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public interface Conector {

	public abstract Point getCoordenadas();

	public abstract boolean esConstruibleEn(Superficie superficie);

	public abstract void agregarseA(Mapa mapa);

}
