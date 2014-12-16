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
	VistaMapa vistaMapa;	
	VistaMapaSubterraneo vistaMapaSubterraneo;
	

	public Ventana(Mapa mapa, Juego juego) {
		super("Algoritmos 3 | AlgoCity");
		this.juego = juego;
		this.mapa = mapa;
		definirPanelIzq();
		definirPanelDer();
		definirPanelSup();
		acomodar();
		pack();
	}

	private void definirPanelSup() {
		setJMenuBar(new VistaPanelSup(vistaMapa, vistaMapaSubterraneo, juego));
		
	}

	private void definirPanelDer() {
		JPanel panelDer = new JPanel();
		panelDer.setLayout(new CardLayout());
		vistaMapaSubterraneo = new VistaMapaSubterraneo(mapa);
		panelDer.add(vistaMapaSubterraneo);
		vistaMapa = new VistaMapa(mapa);
		panelDer.add(vistaMapa);
		add(panelDer);
		
	}

	private void definirPanelIzq() {
		JPanel panelIzq = new JPanel();
		panelIzq.setPreferredSize(new Dimension(200, 600));
		panelIzq.setLayout(new BorderLayout());
		add(panelIzq, BorderLayout.WEST);
		panelIzq.add(new VistaPanelInfo(), BorderLayout.NORTH);
		panelIzq.add(new VistaPanelOpciones(), BorderLayout.CENTER);

	}

	private void acomodar() {
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		Este metodo sirve para que la ventana se ajuste al tamanio
//		minimo determinado por el tamanio de los paneles internos
//		pack();

	}

	private void iniciarVistaMapa(Mapa mapa) {
		add(new VistaMapa(mapa));
	}

	private void iniciarPanelOpciones() {
		add(new VistaPanelOpciones(), BorderLayout.WEST);
	}

	private void iniciarPanelInfo() {
		add(new VistaPanelInfo(), BorderLayout.LINE_START);
	}

}
