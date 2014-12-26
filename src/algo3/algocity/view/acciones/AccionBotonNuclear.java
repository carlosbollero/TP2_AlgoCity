package algo3.algocity.view.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.model.fabricas.FabricaCentralNuclear;
import algo3.algocity.view.VistaMapa;

public class AccionBotonNuclear implements ActionListener {

	FabricaCentralNuclear fabrica; 
	VistaMapa vMapa; 
	
	public AccionBotonNuclear (VistaMapa vMapa){
		this.vMapa = vMapa; 
		
		
	}
	
	public void actionPerformed (ActionEvent e){
		fabrica = new FabricaCentralNuclear(); 
		vMapa.aniadirEnergetica (fabrica); 
		
	}

}
