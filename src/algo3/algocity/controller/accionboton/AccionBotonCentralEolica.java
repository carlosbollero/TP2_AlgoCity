package algo3.algocity.controller.accionboton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.model.fabricas.FabricaCentralEolica;
import algo3.algocity.view.VistaMapa;

public class AccionBotonCentralEolica implements ActionListener {

	FabricaCentralEolica fabrica; 
	VistaMapa vMapa; 
	
	public AccionBotonCentralEolica (VistaMapa vMapa){
		this.vMapa = vMapa; 
		
		
	}
	
	public void actionPerformed (ActionEvent e){
		fabrica = new FabricaCentralEolica(); 
		vMapa.aniadirEnergetica (fabrica); 
		
	}
}
