package algo3.algocity.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import algo3.algocity.view.VistaMapa;

public class AccionMouseVistaSuperficial implements MouseListener {
	
	VistaMapa vista;
	
	public AccionMouseVistaSuperficial(VistaMapa vista) {
		this.vista = vista;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		vista.setVisible(true);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseClicked(e);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
