package algo3.algocity.view.botonespanelopciones;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import algo3.algocity.controller.accionboton.AccionBoton;

public class Boton extends JButton {
	
	private static final long serialVersionUID = -5976624750905368981L;
	
	AccionBoton accion;

	public Boton(String imagen) {
		super(new ImageIcon(imagen));
	}
	
	public AccionBoton getAccion(){
		return accion;
	}

}
