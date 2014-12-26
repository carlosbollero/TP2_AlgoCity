package algo3.algocity.view.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.model.fabricas.FabricaUnidadComercial;
import algo3.algocity.view.VistaMapa;

public class AccionBotonComercio implements ActionListener {

	FabricaUnidadComercial fabrica; 
	VistaMapa vMapa; 
	
	public AccionBotonComercio (VistaMapa vMapa){
		this.vMapa = vMapa; 
		
		
	}
	
	public void actionPerformed (ActionEvent e){
		fabrica = new FabricaUnidadComercial(); 
		vMapa.aniadirUnidades (fabrica); 
		
	}
}
