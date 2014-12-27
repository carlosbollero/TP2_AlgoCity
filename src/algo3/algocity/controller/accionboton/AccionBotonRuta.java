package algo3.algocity.controller.accionboton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.model.fabricas.FabricaRuta;
import algo3.algocity.view.VistaMapa;

public class AccionBotonRuta implements ActionListener {

	FabricaRuta fabricaRuta; 
	VistaMapa vMapa; 
	
	public AccionBotonRuta (VistaMapa vMapa){
		this.vMapa = vMapa; 
		
		
	}
	
	public void actionPerformed (ActionEvent e){
		fabricaRuta = new FabricaRuta(); 
		vMapa.aniadirConector (fabricaRuta); 
		
	}
}
