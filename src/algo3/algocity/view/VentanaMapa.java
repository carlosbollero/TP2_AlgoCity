package algo3.algocity.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaMapa extends JFrame {
	int filas = 10;
	int columnas = 10;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GridLayout grilla;
	
	public VentanaMapa(){
		super("Mapa");
		grilla = new GridLayout(filas, columnas);
		setLayout(grilla);
	}
	

}
