package algo3.algocity.model.fabricas;

import algo3.algocity.model.Dinero;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.excepciones.FondosInsuficientesException;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public interface FabricaUnidades {

	public abstract Unidad construir(Mapa mapa, Dinero dinero, int x, int y)
			throws NoSeCumplenLosRequisitosException, FondosInsuficientesException;
}
