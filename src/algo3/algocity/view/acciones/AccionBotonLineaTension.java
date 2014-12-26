package algo3.algocity.view.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.model.fabricas.FabricaLineaTension;
import algo3.algocity.model.fabricas.FabricaRuta;
import algo3.algocity.view.VistaMapa;

public class AccionBotonLineaTension implements ActionListener {

	FabricaLineaTension fabrica; 
	VistaMapa vMapa; 
	
	public AccionBotonLineaTension (VistaMapa vMapa){
		this.vMapa = vMapa; 
		
		
	}
	
	public void actionPerformed (ActionEvent e){
		fabrica = new FabricaLineaTension(); 
		vMapa.aniadirConector (fabrica); 
		
	}
}
