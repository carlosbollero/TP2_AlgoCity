package algo3.algocity.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import algo3.algocity.controller.accionboton.AccionBotonBomberos;
import algo3.algocity.controller.accionboton.AccionBotonCentralEolica;
import algo3.algocity.controller.accionboton.AccionBotonComercial;
import algo3.algocity.controller.accionboton.AccionBotonIndustrial;
import algo3.algocity.controller.accionboton.AccionBotonLineaTension;
import algo3.algocity.controller.accionboton.AccionBotonCentralMinera;
import algo3.algocity.controller.accionboton.AccionBotonCentralNuclear;
import algo3.algocity.controller.accionboton.AccionBotonPozoAgua;
import algo3.algocity.controller.accionboton.AccionBotonResidencia;
import algo3.algocity.controller.accionboton.AccionBotonRuta;
import algo3.algocity.controller.accionboton.AccionBotonTuberia;
import algo3.algocity.view.botonespanelopciones.Boton;
import algo3.algocity.view.botonespanelopciones.BotonBomberos;
import algo3.algocity.view.botonespanelopciones.BotonBulldozer;
import algo3.algocity.view.botonespanelopciones.BotonCentralEolica;
import algo3.algocity.view.botonespanelopciones.BotonCentralMinera;
import algo3.algocity.view.botonespanelopciones.BotonCentralNuclear;
import algo3.algocity.view.botonespanelopciones.BotonLineaTension;
import algo3.algocity.view.botonespanelopciones.BotonPozoDeAgua;
import algo3.algocity.view.botonespanelopciones.BotonRuta;
import algo3.algocity.view.botonespanelopciones.BotonTuberia;
import algo3.algocity.view.botonespanelopciones.BotonUnidadComercial;
import algo3.algocity.view.botonespanelopciones.BotonUnidadIndustrial;
import algo3.algocity.view.botonespanelopciones.BotonUnidadResidencial;

public class VistaPanelOpciones extends JPanel {

	private static final long serialVersionUID = 6011424322780190648L;
	
	Ventana ventana;
	VistaMapa vMapa;
	Boton b_residencial;
	Boton b_comercial;
	Boton b_industrial;
	Boton b_bomberos;
	Boton b_nuclear;
	Boton b_ruta;
	Boton b_lineaTension;
	Boton b_centralEolica;
	Boton b_centralMinera;
	Boton b_tuberia;
	Boton b_pozoDeAgua;
	Boton b_bulldozer;
	
	ArrayList<Boton> botones;
	
	public VistaPanelOpciones(Ventana ventana) {
		this.ventana = ventana;
//		vMapa = ventana.getVistaPanelDer().getVistaMapa();
		setPreferredSize(new Dimension(200, 550));
		setLayout(new GridLayout(4, 3));
		botones = new ArrayList<Boton>();
		inicializarMenu();
	}

	private void inicializarMenu() {
		setBotones();
		agregarBotonesAlPanel();
	}

	private void setBotones() {
		botones.add(b_residencial = new BotonUnidadResidencial());
		botones.add(b_industrial = new BotonUnidadIndustrial());
		botones.add(b_comercial = new BotonUnidadComercial());
		botones.add(b_nuclear = new BotonCentralNuclear());
		botones.add(b_bomberos  = new BotonBomberos());
		botones.add(b_centralEolica = new BotonCentralEolica());
		botones.add(b_centralMinera = new BotonCentralMinera());
		botones.add(b_ruta = new BotonRuta());
		botones.add(b_lineaTension = new BotonLineaTension());
		botones.add(b_tuberia = new BotonTuberia());
		botones.add(b_pozoDeAgua = new BotonPozoDeAgua());
		botones.add(b_bulldozer = new BotonBulldozer());
	}


	private void agregarBotonesAlPanel() {
		for(Boton boton : botones){
			add(boton);
		}
	}
	
	public ArrayList<Boton> getBotones(){
		return botones;
	}


}
