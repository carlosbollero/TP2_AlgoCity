package algo3.algocity.controller;

import java.util.Observable;

import algo3.algocity.model.Juego;
import algo3.algocity.model.fabricas.FabricaCentralEolica;
import algo3.algocity.model.fabricas.FabricaCentralMinera;
import algo3.algocity.model.fabricas.FabricaCentralNuclear;
import algo3.algocity.model.fabricas.FabricaEstacionDeBomberos;
import algo3.algocity.model.fabricas.FabricaLineaTension;
import algo3.algocity.model.fabricas.FabricaPozoAgua;
import algo3.algocity.model.fabricas.FabricaRuta;
import algo3.algocity.model.fabricas.FabricaUnidadComercial;
import algo3.algocity.model.fabricas.FabricaUnidadIndustrial;
import algo3.algocity.model.fabricas.FabricaUnidadResidencial;
import algo3.algocity.model.mapas.Coordenada;

public class ControladorMouseMapaSub extends ControladorMouseMapa {

	public ControladorMouseMapaSub(Juego j, Coordenada c) {
		super(j, c);
	}

	public void update(Observable arg0, FabricaEstacionDeBomberos fabrica) {
		estadoActual = null;
	}

	public void update(Observable arg0, FabricaPozoAgua fabrica) {
		estadoActual = null;
	}

	public void update(Observable arg0, FabricaUnidadResidencial fabrica) {
		estadoActual = null;
	}

	public void update(Observable arg0, FabricaUnidadComercial fabrica) {
		estadoActual = null;
	}

	public void update(Observable arg0, FabricaUnidadIndustrial fabrica) {
		estadoActual = null;
	}

	public void update(Observable arg0, FabricaCentralEolica fabrica) {
		estadoActual = null;
	}

	public void update(Observable arg0, FabricaCentralMinera fabrica) {
		estadoActual = null;
	}

	public void update(Observable arg0, FabricaCentralNuclear fabrica) {
		estadoActual = null;
	}

	public void update(Observable arg0, FabricaLineaTension fabrica) {
		estadoActual = null;
	}

	public void update(Observable arg0, FabricaRuta fabrica) {
		estadoActual = null;
	}

}
