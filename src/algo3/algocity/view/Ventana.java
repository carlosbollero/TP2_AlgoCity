package algo3.algocity.view;

import javax.swing.JFrame;

import algo3.algocity.model.mapas.Mapa;

public class Ventana extends JFrame {
	
	private static final long serialVersionUID = 6947930227453761722L;
	
	int tamanio;
	
	public Ventana(Mapa mapa){
		super("Algoritmos 3 | AlgoCity");
		iniciarVistaMapa(mapa);
		acomodar();
	}
	
	private void acomodar() {
		setSize(500, 400);
		setLocationRelativeTo(null);
		setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	private void iniciarVistaMapa(Mapa mapa){
		add(new VistaMapa(mapa));
	}
	

}
