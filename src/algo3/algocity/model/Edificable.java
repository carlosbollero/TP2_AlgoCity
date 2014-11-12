package algo3.algocity.model;

import java.util.ArrayList;


public interface Edificable {
	
	public void construir();
	
	//TODO corroborar que sea correcto esto
	public ArrayList<boolean[]> getRequisitosTerreno();
	
}
