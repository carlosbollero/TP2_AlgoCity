package algo3.algocity.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import algo3.algocity.model.Juego;
import algo3.algocity.model.fabricas.FabricaConectores;
import algo3.algocity.model.fabricas.FabricaEnergetica;
import algo3.algocity.model.fabricas.FabricaUnidades;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class VistaMapa extends JPanel implements Observer {

	private static final long serialVersionUID = 5750354545703155652L;

	FabricaEnergetica energetica;
	FabricaUnidades unidades;
	FabricaConectores conectores;
	Mapa mapa;
	HashMap<Coordenada, JPanel> territorio;
	JPanel[][] tabla;
	// JTable grilla;
	// LinkedList<JPanel> territorio;
	Juego juego;

	public VistaMapa(Mapa mapa, Juego juego) {
		setBorder(BorderFactory.createTitledBorder("Mapa superficial"));
		setPreferredSize(new Dimension(600, 600));
		this.juego = juego;
		this.mapa = mapa;

		mapa.addObserver(this);
		mapa.ciudad().addObserver(this);
		territorio = new HashMap<Coordenada, JPanel>();
		tabla = new JPanel[mapa.tamanio()][mapa.tamanio()];
		setLayout(new GridLayout(mapa.tamanio(), mapa.tamanio()));
		rellenar();
	}

	private void rellenar() {
		for (int i = 0; i < mapa.tamanio(); i++) {
			for (int j = 0; j < mapa.tamanio(); j++) {
				Coordenada coord = new Coordenada(i, j);
				VistaTerreno superficie = new VistaTerreno(mapa, coord, this,
						juego);
				tabla[i][j] = superficie;
				add(tabla[i][j]);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// rellenar();
		actualizar((Coordenada) arg);
	}

	private void actualizar(Coordenada coord) {
		tabla[coord.getX()][coord.getY()] = (mapa.ciudad()
				.tieneCoordenadaOcupada(coord)) ? new VistaUnidad(mapa, coord)
				: new VistaTerreno(mapa, coord, this, juego);
		repintar();
	}

	private void repintar() {
		removeAll();
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length; j++) {
				add(tabla[i][j]);
			}
		}
	}

	public void aniadirConector(FabricaConectores conector) {
		conectores = conector;
	}

	public boolean hayConector() {
		return (conectores != null);
	}

	public FabricaConectores devolverConector() {
		return conectores;
	}

	public void aniadirEnergetica(FabricaEnergetica energetica) {
		this.energetica = energetica;
	}

	public boolean hayEnergetica() {
		return (energetica != null);
	}

	public FabricaEnergetica devolverEnergetica() {
		return energetica;
	}

	public void aniadirUnidades(FabricaUnidades unidades) {
		this.unidades = unidades;
	}

	public boolean hayUnidades() {
		return (unidades != null);
	}

	public FabricaUnidades devolverUnidades() {
		return unidades;
	}

	public void resetearFabricas() {
		this.energetica = null;
		this.unidades = null;
		this.conectores = null;
	}

}
