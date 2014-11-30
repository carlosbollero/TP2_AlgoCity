package algo3.algocity.model.fabricas;

import java.util.ArrayList;

import algo3.algocity.model.PozoDeAgua;
import algo3.algocity.model.Unidad;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public class FabricaPozoAgua implements FabricaUnidades {

	public Unidad construir(ArrayList<Mapa> mapas, int x, int y) {
		
		try {
			return new PozoDeAgua(mapas, x, y);
			
		} catch (NoSeCumplenLosRequisitosException e) {
			System.out.println(e);
			return null;
		}		
	}

}