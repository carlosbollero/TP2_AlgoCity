package algo3.algocity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import algo3.algocity.view.VistaMapa;

public class AccionMouseVistaSuperficial implements ActionListener {
	
	VistaMapa vista;
	JPanel tuberias;
	
	public AccionMouseVistaSuperficial(VistaMapa vista, JPanel tuberias) {
		this.vista = vista;
		this.tuberias = tuberias;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		tuberias.setVisible(false);
		vista.setVisible();
		
		
	}


}
