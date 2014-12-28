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

public class VistaMapaSubterraneo extends JPanel implements Observer {
	private static final long serialVersionUID = 7101557286652466974L;
	Juego juego;
	Mapa mapa;
	VistaPanelDer contenedor;
	VistaPosicion[][] tabla;

	public VistaMapaSubterraneo(Juego juego, VistaPanelDer contenedor) {
		this.contenedor = contenedor;
		setBorder(BorderFactory.createTitledBorder("Mapa subterraneo"));
		this.juego = juego;
		mapa = juego.mapa();
		mapa.tuberias().addObserver(this);
		setPreferredSize(new Dimension(600, 600));
		setLayout(new GridLayout(mapa.tamanio(), mapa.tamanio()));
		tabla = new VistaPosicion[mapa.tamanio()][mapa.tamanio()];
		rellenar();
	}

	private void rellenar() {
		for (int i = 0; i < mapa.tamanio(); i++) {
			for (int j = 0; j < mapa.tamanio(); j++) {
				VistaPosicion sub = new VistaTerrenoSub(juego,
						new Coordenada(i, j));
				sub.getControlador().setControladorMensajes(
						contenedor.getControladorMensajes());
				for (Boton boton : contenedor.getVentana().getPanelIzq()
						.getPanelOpciones().getBotones()) {
					boton.getAccion().addObserver(sub.getControlador());
				}
				tabla[i][j] = sub;
				add(sub);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		actualizar((Coordenada) arg);
	}

	private void actualizar(Coordenada coord) {
		if (mapa.tuberias().tieneCoordenadaOcupada(coord)) {
			(tabla[coord.getX()][coord.getY()]).setImagen();
		}
	}
}