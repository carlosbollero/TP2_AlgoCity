package algo3.algocity.controller.accionboton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.model.fabricas.FabricaEstacionDeBomberos;
import algo3.algocity.view.VistaMapa;

public class AccionBotonBomberos implements ActionListener {

//	FabricaEstacionDeBomberos fabrica; 
	VistaMapa vMapa; 
	
	public AccionBotonBomberos (VistaMapa vMapa){
		this.vMapa = vMapa; 
		
		
	}
	
	public void actionPerformed (ActionEvent e){
//		fabrica = new FabricaEstacionDeBomberos(); 
		vMapa.aniadirUnidades (new FabricaEstacionDeBomberos()); 
		
	}
}
