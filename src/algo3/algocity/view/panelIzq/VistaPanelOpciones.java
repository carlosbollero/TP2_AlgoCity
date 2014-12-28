package algo3.algocity.view.panelIzq;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import algo3.algocity.view.botonesPanelOpciones.Boton;
import algo3.algocity.view.botonesPanelOpciones.BotonBomberos;
import algo3.algocity.view.botonesPanelOpciones.BotonBulldozer;
import algo3.algocity.view.botonesPanelOpciones.BotonCentralEolica;
import algo3.algocity.view.botonesPanelOpciones.BotonCentralMinera;
import algo3.algocity.view.botonesPanelOpciones.BotonCentralNuclear;
import algo3.algocity.view.botonesPanelOpciones.BotonLineaTension;
import algo3.algocity.view.botonesPanelOpciones.BotonPozoDeAgua;
import algo3.algocity.view.botonesPanelOpciones.BotonRuta;
import algo3.algocity.view.botonesPanelOpciones.BotonTuberia;
import algo3.algocity.view.botonesPanelOpciones.BotonUnidadComercial;
import algo3.algocity.view.botonesPanelOpciones.BotonUnidadIndustrial;
import algo3.algocity.view.botonesPanelOpciones.BotonUnidadResidencial;
import algo3.algocity.view.panelDer.VistaMapa;

public class VistaPanelOpciones extends JPanel {

	private static final long serialVersionUID = 6011424322780190648L;
	
	VistaPanelIzq contenedor;
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
	
	public VistaPanelOpciones(VistaPanelIzq contenedor) {
		this.contenedor = contenedor;
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
		for(Boton b : botones){
			b.setControladorMensajes(contenedor.getControladorMensajes());
		}
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
