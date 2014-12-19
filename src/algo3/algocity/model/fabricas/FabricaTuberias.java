package algo3.algocity.model.fabricas;

import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.conexiones.Tuberia;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class FabricaTuberias implements FabricaConectores {

	public Conector construir(Mapa mapa, Coordenada coordenada)
			throws NoSeCumplenLosRequisitosException {
		return new Tuberia(mapa, coordenada);
	}

}