package algo3.algocity.model.fabricas;

import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class FabricaLineaTension implements FabricaConectores {

	public Conector construir(Mapa mapa, Coordenada coordenada)
			throws NoSeCumplenLosRequisitosException {
		return new LineaTension(mapa, coordenada);
	}

}