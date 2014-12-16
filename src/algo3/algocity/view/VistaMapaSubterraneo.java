package algo3.algocity.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import algo3.algocity.model.mapas.Mapa;

public class VistaMapaSubterraneo extends JPanel {

	private static final long serialVersionUID = 7101557286652466974L;
	
	Mapa mapa;
	
	public VistaMapaSubterraneo(Mapa mapa){
		this.mapa = mapa;
		setVisible(false);
//		setBackground(new Color(255,255,255));
		setPreferredSize(new Dimension(600,600));
		setLayout(new GridLayout(mapa.getTamanio(), mapa.getTamanio()));
		inicializar();
	}

	private void inicializar() {
		for (int i = 0; i < mapa.getTamanio(); i++) {
			for (int j = 0; j < mapa.getTamanio(); j++) {
//				Aca se deb agregar tiles de tierra o tuberia
				JPanel u = new JPanel();
				add(u);
			}		
		}
		
	}
	

}

