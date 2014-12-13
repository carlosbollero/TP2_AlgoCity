package algo3.algocity.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import algo3.algocity.model.mapas.Mapa;

public class Ventana extends JFrame {
	
	private static final long serialVersionUID = 6947930227453761722L;
	
	int tamanio;
	
	public Ventana(Mapa mapa){
		super("Algoritmos 3 | AlgoCity");
		definirPanelIzq();
//		iniciarPanelInfo();
//		iniciarPanelOpciones();
		iniciarVistaMapa(mapa);
		acomodar();
	}

	private void definirPanelIzq() {
		JPanel panelIzq = new JPanel();
		panelIzq.setLayout(new BorderLayout());
		add(panelIzq,BorderLayout.WEST);
		panelIzq.add(new VistaPanelInfo(),BorderLayout.NORTH);
		panelIzq.add(new VistaPanelOpciones(), BorderLayout.CENTER);
		
	}

	private void acomodar() {
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	private void iniciarVistaMapa(Mapa mapa){
		add(new VistaMapa(mapa));
	}
	
	private void iniciarPanelOpciones() {
		add(new VistaPanelOpciones(),BorderLayout.WEST);	
	}
	
	private void iniciarPanelInfo() {
		add(new VistaPanelInfo(),BorderLayout.LINE_START);		
	}
	
	
	

}
