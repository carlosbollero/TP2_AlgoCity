package algo3.algocity.view.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.model.fabricas.FabricaTuberias;
import algo3.algocity.view.VistaMapa;

public class AccionBotonTuberia implements ActionListener {

	FabricaTuberias fabrica; 
	VistaMapa vMapa; 
	
	public AccionBotonTuberia (VistaMapa vMapa){
		this.vMapa = vMapa; 
		
		
	}
	
	public void actionPerformed (ActionEvent e){
		fabrica = new FabricaTuberias(); 
		vMapa.aniadirConector (fabrica); 
		
	}
}
