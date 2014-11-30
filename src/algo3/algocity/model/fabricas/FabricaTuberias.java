package algo3.algocity.model.fabricas;

import algo3.algocity.model.Conector;
import algo3.algocity.model.Tuberia;

public class FabricaTuberias implements FabricaConectores{

	public Conector construir() {
		return new Tuberia();
	}

}