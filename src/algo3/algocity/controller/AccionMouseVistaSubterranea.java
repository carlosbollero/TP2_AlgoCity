package algo3.algocity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.view.VistaMapa;

public class AccionMouseVistaSubterranea implements ActionListener {
	
	VistaMapa vista;
	
	public AccionMouseVistaSubterranea(VistaMapa vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vista.setInvisible();
		
	}

}
