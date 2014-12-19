package algo3.algocity.model.fabricas;

import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public interface FabricaConectores {

	public abstract Conector construir(Mapa mapa, Coordenada coordenada)
			throws NoSeCumplenLosRequisitosException;

}
