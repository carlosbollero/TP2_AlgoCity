package algo3.algocity.model.fabricas;

import algo3.algocity.model.construcciones.PozoDeAgua;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;


public class FabricaPozoAgua implements FabricaUnidades {

	public Unidad construir(Mapa mapa, int x, int y) {
		
		try {
			return new PozoDeAgua(mapa, x, y);
			
		} catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
			return null;
		}
	}

}