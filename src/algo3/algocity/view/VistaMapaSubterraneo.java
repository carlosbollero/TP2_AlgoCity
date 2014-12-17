package algo3.algocity.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class VistaMapaSubterraneo extends JPanel implements Observer {

	private static final long serialVersionUID = 7101557286652466974L;

	Mapa mapa;

	public VistaMapaSubterraneo(Mapa mapa) {
		setBorder(BorderFactory.createTitledBorder("Mapa subterraneo"));
		this.mapa = mapa;
		setPreferredSize(new Dimension(600, 600));
		setLayout(new GridLayout(mapa.getTamanio(), mapa.getTamanio()));
		rellenar();
	}

	private void rellenar() {
		for (int i = 0; i < mapa.getTamanio(); i++) {
			for (int j = 0; j < mapa.getTamanio(); j++) {
				VistaTerrenoSub sub = new VistaTerrenoSub(new Coordenada(i, j));
				add(sub);
			}
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		rellenar();
		
	}

}
