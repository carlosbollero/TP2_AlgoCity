package algo3.algocity.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import algo3.algocity.model.Juego;
import algo3.algocity.model.mapas.Mapa;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 6947930227453761722L;

	int tamanio;
	Juego juego;
	Mapa mapa;

	VistaPanelDer panelDer;
	VistaPanelIzq panelIzq;
	VistaPanelSup panelSup;

	public Ventana(Juego juego) {
		super("Algoritmos 3 | AlgoCity");
		this.juego = juego;
		this.mapa = juego.mapa();
		setPanelDer();
		setPanelIzq();
		setPanelSup();
		acomodar();
	}

	private void setPanelSup() {
		panelSup = new VistaPanelSup(juego, this);
		setJMenuBar(panelSup);
	}

	private void setPanelDer() {
		panelDer = new VistaPanelDer(juego, this);
		add(panelDer, BorderLayout.CENTER);

	}

	private void setPanelIzq() {
		panelIzq = new VistaPanelIzq(juego, this);
		add(panelIzq, BorderLayout.WEST);
	}

	private void acomodar() {
		setPreferredSize(new Dimension(800, 600));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();

	}
	
	public VistaPanelSup getVistaPanelSup(){
		return panelSup;
	}

	public VistaPanelDer getVistaPanelDer() {
		return panelDer;
	}

	public VistaPanelIzq getVistaPanelIzq() {
		return panelIzq;
	}

	public static void main(String[] args) {
		new Ventana(new Juego());
	}

}
