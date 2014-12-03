package algo3.algocity.model.fabricas;

import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public interface FabricaUnidades {

	public abstract Unidad construir(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException;
}
