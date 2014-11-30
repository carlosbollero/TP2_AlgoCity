package algo3.algocity.model;

import java.util.ArrayList;

import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;

public interface FabricaUnidades {

	//public Unidad construir(ArrayList<Mapa> mapas, int x, int y);

	public abstract Unidad construir(ArrayList<Mapa> mapas, int x, int y)
			throws NoSeCumplenLosRequisitosException;
	

}
