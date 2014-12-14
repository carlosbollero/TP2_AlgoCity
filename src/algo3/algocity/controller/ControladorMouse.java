package algo3.algocity.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.view.VistaMapa;

public class ControladorMouse extends MouseAdapter {
	
	Mapa mapa;
	VistaMapa vistaMapa;
	
	public ControladorMouse(Mapa mapa, VistaMapa vistaMapa){
		this.mapa = mapa;
		this.vistaMapa = vistaMapa;
		
	}
	
	public void mouseClicked(MouseEvent mouseEvent) {
		int x = vistaMapa.
		mapa.agregar(new Ruta(mapa, x, y));
	}

}
