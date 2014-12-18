package algo3.algocity.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextPane;

public class VistaVentanaAcerca extends JFrame {

	private static final long serialVersionUID = -1474006066988397183L;
	
	JTextPane texto;

	String alumno1 = "\n  Olivera, Rodrigo";
	String alumno2 = "\n  Botalla, Tomas";
	String alumno3 = "\n  Bollero, Carlos";
	
	public VistaVentanaAcerca() {
//		setPreferredSize(new Dimension(200,200));
		texto = new JTextPane();
		texto.setText("Alumnos:" + alumno1 + alumno2 + alumno3);
		texto.setEditable(false);
		texto.setBackground(null);
		texto.setFocusable(false);
		add(texto);
		pack();
		setLocationRelativeTo(null);
		validate();
		setVisible(true);
	}

}
