package algo3.algocity.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import algo3.algocity.controller.ControladorMouse;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class VistaMapa extends JPanel implements Observer {

	private static final long serialVersionUID = 5750354545703155652L;

	Mapa mapa;
	LinkedList<VistaTerreno> territorio;

	public VistaMapa(Mapa mapa) {
		this.mapa = mapa;
		territorio = new LinkedList<VistaTerreno>();
		setBackground(new Color(0));
		setLayout(new GridLayout(mapa.getTamanio(), mapa.getTamanio()));
		inicializarVistaTerreno();
		mapa.addObserver(this);
		addMouseListener(new ControladorMouse(mapa, this));
	}

	private void inicializarVistaTerreno() {
		for (int i = 0; i < mapa.getTamanio(); i++) {
			for (int j = 0; j < mapa.getTamanio(); j++) {
				Coordenada coord = new Coordenada(i, j);
//				add(new VistaTerreno(mapa.superficie(coord), coord));
				VistaTerreno superficie = new VistaTerreno(mapa, coord);
				territorio.add(superficie);
				add(superficie);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		inicializarVistaTerreno();
	}
	
	public void setInvisible(){
		setVisible(false);
	}
	
	public void setVisible(){
		setVisible(true);
	}


}
