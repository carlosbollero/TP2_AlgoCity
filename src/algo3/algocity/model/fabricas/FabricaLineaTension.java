package algo3.algocity.model.fabricas;

import algo3.algocity.model.Conector;
import algo3.algocity.model.LineaTension;

public class FabricaLineaTension implements FabricaConectores {

	public Conector construir() {
		return new LineaTension();
	}

}