package algo3.algocity.view.panelDer;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import algo3.algocity.model.Juego;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.view.panelIzq.botonesPanelOpciones.Boton;

public class VistaMapa extends JPanel implements Observer {

	private static final long serialVersionUID = 5750354545703155652L;

	Juego juego;
	Mapa mapa;
	VistaPanelDer contenedor;
	VistaCatastrofe vistaCatastrofe;
	VistaPosicion[][] tabla;

	public VistaMapa(Juego juego, VistaPanelDer contenedor) {
		this.contenedor = contenedor;
		setBorder(BorderFactory.createTitledBorder("Mapa superficial"));
		setPreferredSize(new Dimension(600, 600));
		this.juego = juego;
		mapa = juego.mapa();
		mapa.ciudad().addObserver(this);
		mapa.redElectrica().addObserver(this);
		mapa.rutas().addObserver(this);
		tabla = new VistaPosicion[mapa.tamanio()][mapa.tamanio()];
		setLayout(new GridLayout(mapa.tamanio(), mapa.tamanio()));
		rellenar();
	}

	private void rellenar() {
		for (int i = 0; i < mapa.tamanio(); i++) {
			for (int j = 0; j < mapa.tamanio(); j++) {
				Coordenada coord = new Coordenada(i, j);
				setPosicion(coord);
				tabla[i][j].getControlador().setControladorMensajes(
						contenedor.getControladorMensajes());
				for (Boton boton : contenedor.getVentana().getPanelIzq()
						.getPanelOpciones().getBotones()) {
					boton.getAccion().addObserver(tabla[i][j].getControlador());
				}
				add(tabla[i][j]);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		Coordenada coord = (Coordenada) arg;
		System.out.println("agregado");
		setPosicion(coord);
		repintar(coord);
	}

	private void setPosicion(Coordenada coord) {
		tabla[coord.getX()][coord.getY()] = (mapa.ciudad()
				.tieneCoordenadaOcupada(coord)) ? new VistaUnidad(juego, coord)
				: new VistaTerreno(juego, coord);
	}

	private void repintar(Coordenada coord) {
		int i = (coord.getX()) * mapa.tamanio() + coord.getY();
		remove(i);
		add(tabla[coord.getX()][coord.getY()], i);
		revalidate();
	}

}
