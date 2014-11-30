package algo3.algocity.model;

import java.util.ArrayList;

import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;

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