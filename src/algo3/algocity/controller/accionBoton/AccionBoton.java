package algo3.algocity.controller.accionBoton;

import java.awt.event.ActionListener;
import java.util.Observable;

import algo3.algocity.controller.ControladorMensajes;

public abstract class AccionBoton extends Observable implements ActionListener{
	
	ControladorMensajes controladorMsj;
	
	public void setControladorMensajes(ControladorMensajes controlador){
		controladorMsj = controlador;
	}

}
