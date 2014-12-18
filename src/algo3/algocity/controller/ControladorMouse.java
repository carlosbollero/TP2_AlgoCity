package algo3.algocity.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.view.VistaMapa;
import algo3.algocity.view.VistaTerreno;

public class ControladorMouse extends MouseAdapter {
	
	Mapa mapa;
	VistaMapa vistaMapa;
	VistaTerreno vistaTerreno;
	
	public ControladorMouse(VistaMapa vista){
		mapa = null;
		vistaMapa = vista;
		vistaTerreno = null;
	}
	
	public ControladorMouse(Mapa mapa, VistaMapa vistaMapa){
		this.mapa = mapa;
		this.vistaMapa = vistaMapa;
		
	}
	
	public ControladorMouse(Mapa mapa, VistaTerreno vistaTerreno){
		this.mapa = mapa;
		this.vistaTerreno = vistaTerreno;
		
	}
	
	public void mouseClicked(MouseEvent mouseEvent) {
//		mapa.agregar(new Ruta(10,10));
//		mapa.setTerritorioTierraParaTest();
//		vistaMapa.setInvisible();
//		mapa.agregar(new Ruta(mapa, x, y));
	}

}
