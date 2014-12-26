package algo3.algocity.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import algo3.algocity.controller.ControladorMouse;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class VistaMapa extends JPanel implements Observer {

	private static final long serialVersionUID = 5750354545703155652L;

	Mapa mapa;
	LinkedList<JPanel> territorio;

	public VistaMapa(Mapa mapa) {
		setBorder(BorderFactory.createTitledBorder("Mapa superficial"));
		setPreferredSize(new Dimension(600, 600));
		this.mapa = mapa;
		
		territorio = new LinkedList<JPanel>();
		setLayout(new GridLayout(mapa.tamanio(), mapa.tamanio()));
		rellenar();
		mapa.addObserver(this);
		mapa.ciudad().addObserver(this);
		addMouseListener(new ControladorMouse(mapa, this));
	}

	private void rellenar() {
		for (int i = 0; i < mapa.tamanio(); i++) {
			for (int j = 0; j < mapa.tamanio(); j++) {
				Coordenada coord = new Coordenada(i, j);
				// add(new VistaTerreno(mapa.superficie(coord), coord));
				VistaTerreno superficie = new VistaTerreno(mapa, coord);
				territorio.add(superficie);
				add(superficie);
			}
		}
	}
	
	private void actualizar(Coordenada coord){
		for(JPanel v : territorio){
			if(mapa.ciudad().tieneCoordenadaOcupada(coord)){
				territorio.add(territorio.indexOf(v), new VistaUnidad(mapa, coord));
				territorio.remove(territorio.indexOf(v));
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
//		rellenar();
		actualizar((Coordenada)arg);
	}

}
