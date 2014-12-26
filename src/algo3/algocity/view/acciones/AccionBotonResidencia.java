package algo3.algocity.view.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.model.fabricas.FabricaUnidadResidencial;
import algo3.algocity.view.VistaMapa;

public class AccionBotonResidencia implements ActionListener {

	FabricaUnidadResidencial fabricaResidencia; 
	VistaMapa vMapa; 
	
	public AccionBotonResidencia (VistaMapa vMapa){
		this.vMapa = vMapa; 
		
		
	}
	
	public void actionPerformed (ActionEvent e){
		fabricaResidencia = new FabricaUnidadResidencial(); 
		vMapa.aniadirUnidades(fabricaResidencia); 
		
	}
}
