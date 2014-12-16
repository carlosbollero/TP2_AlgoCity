package algo3.algocity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import algo3.algocity.view.VistaMapa;

public class AccionMouseVistaSubterranea implements ActionListener {
	
	VistaMapa vista;
	JPanel tuberias;
	
	public AccionMouseVistaSubterranea(VistaMapa vistaMapa, JPanel tuberias) {
		this.vista = vistaMapa;
		this.tuberias = tuberias;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vista.setInvisible();
		tuberias.setVisible(true);
		
	}

}
