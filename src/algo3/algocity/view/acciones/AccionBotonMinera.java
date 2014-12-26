package algo3.algocity.view.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.model.fabricas.FabricaCentralMinera;
import algo3.algocity.view.VistaMapa;

public class AccionBotonMinera implements ActionListener {

	FabricaCentralMinera fabrica; 
	VistaMapa vMapa; 
	
	public AccionBotonMinera (VistaMapa vMapa){
		this.vMapa = vMapa; 
		
		
	}
	
	public void actionPerformed (ActionEvent e){
		fabrica = new FabricaCentralMinera(); 
		vMapa.aniadirEnergetica (fabrica); 
		
	}
}
