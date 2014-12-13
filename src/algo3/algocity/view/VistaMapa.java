package algo3.algocity.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class VistaMapa extends JPanel {
	
	private static final long serialVersionUID = 5750354545703155652L;
	
	public VistaMapa(Mapa mapa){
		setLayout(new GridLayout(mapa.getTamanio(),mapa.getTamanio()));
		inicializarVistaPosiciones(mapa);
		repaint();
	}
	
	private void inicializarVistaPosiciones(Mapa mapa){
		for(int i = 0; i < mapa.getTamanio(); i++){
			for (int j = 0; j < mapa.getTamanio(); j++){
				add(new VistaPosicion(mapa.superficie(new Coordenada(i,j))));
			}
		}
		
	}

}
