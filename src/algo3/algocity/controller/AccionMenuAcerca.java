package algo3.algocity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.view.panelSup.VistaVentanaAcerca;

public class AccionMenuAcerca implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new VistaVentanaAcerca();
	}

}
