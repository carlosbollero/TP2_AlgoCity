package algo3.algocity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.view.VistaMapa;

public class AccionMouseVistaSuperficial implements ActionListener {
	
	VistaMapa vista;
	
	public AccionMouseVistaSuperficial(VistaMapa vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		vista.setVisible();
		
	}


}
