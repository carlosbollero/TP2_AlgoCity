package algo3.algocity.model.fabricas;

import algo3.algocity.model.Conector;
import algo3.algocity.model.Ruta;

public class FabricaRuta implements FabricaConectores {

	public Conector construir() {
		return new Ruta();
	}

}