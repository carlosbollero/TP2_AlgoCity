package algo3.algocity.view.panelIzq.botonesPanelOpciones;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import algo3.algocity.controller.ControladorMensajes;
import algo3.algocity.controller.accionBoton.AccionBoton;

public class Boton extends JButton {
	
	private static final long serialVersionUID = -5976624750905368981L;
	
	AccionBoton accion;

	public Boton(String imagen) {
		super(new ImageIcon(imagen));
	}
	
	public AccionBoton getAccion(){
		return accion;
	}
	
	public void setControladorMensajes(ControladorMensajes controlador){
		accion.setControladorMensajes(controlador);
	}

}
