package algo3.algocity.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class AccionMenuVistaSuperficial implements ActionListener {
	
	JPanel panel;
	
	public AccionMenuVistaSuperficial(JPanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((CardLayout) panel.getLayout()).show(panel, "superficie");
		
	}


}
