package algo3.algocity.controller;

import java.util.Observable;

import algo3.algocity.model.Juego;
import algo3.algocity.model.fabricas.FabricaTuberias;
import algo3.algocity.model.mapas.Coordenada;

public class ControladorMouseMapaSup extends ControladorMouseMapa {
	
	public ControladorMouseMapaSup(Juego j, Coordenada c) {
		super(j, c);
	}
	
	@Override
	public void update(Observable arg0, FabricaTuberias fabrica) {
		estadoActual = null;
	}


}
