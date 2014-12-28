package algo3.algocity.view.panelIzq;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import algo3.algocity.view.panelDer.VistaMapa;
import algo3.algocity.view.panelIzq.botonesPanelOpciones.Boton;
import algo3.algocity.view.panelIzq.botonesPanelOpciones.BotonBomberos;
import algo3.algocity.view.panelIzq.botonesPanelOpciones.BotonBulldozer;
import algo3.algocity.view.panelIzq.botonesPanelOpciones.BotonCentralEolica;
import algo3.algocity.view.panelIzq.botonesPanelOpciones.BotonCentralMinera;
import algo3.algocity.view.panelIzq.botonesPanelOpciones.BotonCentralNuclear;
import algo3.algocity.view.panelIzq.botonesPanelOpciones.BotonLineaTension;
import algo3.algocity.view.panelIzq.botonesPanelOpciones.BotonPozoDeAgua;
import algo3.algocity.view.panelIzq.botonesPanelOpciones.BotonRuta;
import algo3.algocity.view.panelIzq.botonesPanelOpciones.BotonTuberia;
import algo3.algocity.view.panelIzq.botonesPanelOpciones.BotonUnidadComercial;
import algo3.algocity.view.panelIzq.botonesPanelOpciones.BotonUnidadIndustrial;
import algo3.algocity.view.panelIzq.botonesPanelOpciones.BotonUnidadResidencial;

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
	ArrayList<Boton> botonesAccionSup;
	ArrayList<Boton> botonesAccionSub;
	
	public VistaPanelOpciones(VistaPanelIzq contenedor) {
		this.contenedor = contenedor;
		setPreferredSize(new Dimension(200, 550));
		setLayout(new GridLayout(4, 3));
		botones = new ArrayList<Boton>();
		botonesAccionSub = new ArrayList<Boton>();
		botonesAccionSub = new ArrayList<Boton>();
		inicializarMenu();
	}

	private void inicializarMenu() {
		setBotones();
		agregarBotones();
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
//		botonesAccionSup = botones.;
	}


	private void agregarBotones() {
		for(Boton boton : botones){
			add(boton);
		}
	}
	
	public ArrayList<Boton> getBotones(){
		return botones;
	}


}
