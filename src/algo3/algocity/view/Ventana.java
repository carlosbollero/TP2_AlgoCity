package algo3.algocity.view;

import javax.swing.JFrame;

import algo3.algocity.model.mapas.Mapa;

public class Ventana extends JFrame {
	
	private static final long serialVersionUID = 6947930227453761722L;
	
	int tamanio;
	
	public Ventana(Mapa mapa){
		super("Mapa");
//		this.mapa = mapa; 
		tamanio = mapa.getTamanio();
		iniciarVistaMapa(mapa);
		repaint();
	}
	
	private void iniciarVistaMapa(Mapa mapa){
		getContentPane().add(new VistaMapa(mapa));
//		setContentPane(new VistaMapa(mapa));
	}
	

}
