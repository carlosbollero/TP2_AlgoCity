package algo3.algocity.model.fabricas;

import java.util.ArrayList;

import algo3.algocity.model.Unidad;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;

public interface FabricaUnidades {

	//public Unidad construir(ArrayList<Mapa> mapas, int x, int y);

	public abstract Unidad construir(ArrayList<Mapa> mapas, int x, int y)
			throws NoSeCumplenLosRequisitosException;
	

}
