package algo3.algocity.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import algo3.algocity.controller.ControladorMensajes;
import algo3.algocity.model.Juego;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.view.panelDer.VistaPanelDer;
import algo3.algocity.view.panelIzq.VistaPanelIzq;
import algo3.algocity.view.panelSup.VistaPanelSup;

public class VentanaJuego extends JFrame {

	private static final long serialVersionUID = 6947930227453761722L;

	int tamanio;
	Juego juego;
	Mapa mapa;

	VistaPanelDer panelDer;
	VistaPanelIzq panelIzq;
	VistaPanelSup panelSup;
	
	ControladorMensajes controladorMsj;

	public VentanaJuego(Juego juego) {
		super("Algoritmos 3 | AlgoCity");
		this.juego = juego;
		mapa = juego.mapa();
		controladorMsj = new ControladorMensajes();
		setPanelIzq();
		setPanelDer();
		setPanelSup();
		acomodar();
	}

	private void setPanelIzq() {
		panelIzq = new VistaPanelIzq(juego, this);
		add(panelIzq, BorderLayout.WEST);
	}
	
	private void setPanelDer() {
		panelDer = new VistaPanelDer(juego, this);
		add(panelDer, BorderLayout.CENTER);
		
	}
	
	private void setPanelSup() {
		panelSup = new VistaPanelSup(juego, this);
		setJMenuBar(panelSup);
	}

	private void acomodar() {
		setPreferredSize(new Dimension(800, 600));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();

	}
	
	public VistaPanelSup getPanelSup(){
		return panelSup;
	}

	public VistaPanelDer getPanelDer() {
		return panelDer;
	}

	public VistaPanelIzq getPanelIzq() {
		return panelIzq;
	}
	
	public ControladorMensajes getControladorMensajes(){
		return controladorMsj;
	}

//	public static void main(String[] args) {
//		new VentanaJuego(new Juego());
//	}

}
