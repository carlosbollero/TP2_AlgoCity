package algo3.algocity.controller;

import java.util.Observable;

import javax.swing.JPanel;

import algo3.algocity.model.Juego;
import algo3.algocity.model.fabricas.FabricaTuberias;
import algo3.algocity.model.mapas.Coordenada;

public class ControladorMouseMapaSup extends ControladorMouseMapa {
	
	JPanel vista;
	
	public ControladorMouseMapaSup(Juego j, Coordenada c, JPanel vista) {
		super(j, c);
		this.vista = vista;
	}
	
	@Override
	public void update(Observable arg0, FabricaTuberias fabrica) {
		estadoActual = null;
	}


}
