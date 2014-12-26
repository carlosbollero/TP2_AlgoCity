package algo3.algocity.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import algo3.algocity.model.Juego;
import algo3.algocity.model.mapas.Mapa;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 6947930227453761722L;

	int tamanio;
	Juego juego;
	Mapa mapa;
	VistaMapa mapaVista ;

	JPanel panelDer, panelIzq;

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
		setJMenuBar(new VistaPanelSup(panelDer, juego));

	}

	private void setPanelDer() {
		panelDer = new JPanel();
		panelDer.setLayout(new CardLayout());
		VistaMapaSubterraneo vistaMapaSubterraneo = new VistaMapaSubterraneo(mapa);
		panelDer.add(vistaMapaSubterraneo, "subterraneo");
		mapaVista = new VistaMapa(mapa, juego);
		panelDer.add(mapaVista, "superficie");
		add(panelDer);
		((CardLayout) panelDer.getLayout()).show(panelDer, "superficie");

	}

	private void setPanelIzq() {
		panelIzq = new JPanel();
		panelIzq.setPreferredSize(new Dimension(200, 600));
		panelIzq.setLayout(new BorderLayout());
		add(panelIzq, BorderLayout.WEST);
		panelIzq.add(new VistaPanelInfo(juego), BorderLayout.NORTH);
		panelIzq.add(new VistaPanelOpciones(mapaVista), BorderLayout.CENTER);

	}

	private void acomodar() {
		 setPreferredSize(new Dimension (800, 600));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();

	}
	
	public static void main(String[] args) {
		new Ventana(new Juego());
	}

}
