package algo3.algocity.model.fabricas;

import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public interface FabricaEnergetica {

	public abstract UnidadEnergetica construir(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException;

}
