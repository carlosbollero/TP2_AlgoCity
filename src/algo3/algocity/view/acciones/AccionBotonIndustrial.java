package algo3.algocity.view.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.model.fabricas.FabricaRuta;
import algo3.algocity.model.fabricas.FabricaUnidadIndustrial;
import algo3.algocity.view.VistaMapa;

public class AccionBotonIndustrial implements ActionListener {

	FabricaUnidadIndustrial fabrica; 
	VistaMapa vMapa; 
	
	public AccionBotonIndustrial (VistaMapa vMapa){
		this.vMapa = vMapa; 
		
		
	}
	
	public void actionPerformed (ActionEvent e){
		fabrica = new FabricaUnidadIndustrial(); 
		vMapa.aniadirUnidades (fabrica); 
		
	}
}
