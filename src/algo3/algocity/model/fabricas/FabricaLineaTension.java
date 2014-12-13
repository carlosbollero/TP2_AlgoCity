package algo3.algocity.model.fabricas;

import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public class FabricaLineaTension implements FabricaConectores {

	public Conector construir(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {
		return new LineaTension(mapa, x, y);
	}

}