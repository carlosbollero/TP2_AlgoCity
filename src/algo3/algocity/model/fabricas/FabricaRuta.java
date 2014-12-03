package algo3.algocity.model.fabricas;

import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public class FabricaRuta implements FabricaConectores {

	public Conector construir(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {
		return new Ruta(mapa, x, y);
	}

}