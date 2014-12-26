package algo3.algocity.view.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.model.fabricas.FabricaPozoAgua;
import algo3.algocity.view.VistaMapa;

public class AccionBotonPozoAgua  implements ActionListener {

	FabricaPozoAgua fabrica; 
	VistaMapa vMapa; 
	
	public AccionBotonPozoAgua (VistaMapa vMapa){
		this.vMapa = vMapa; 
		
		
	}
	
	public void actionPerformed (ActionEvent e){
		fabrica = new FabricaPozoAgua(); 
		vMapa.aniadirUnidades(fabrica); 
		
	}
}
