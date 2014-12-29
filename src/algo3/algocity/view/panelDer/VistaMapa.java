package algo3.algocity.view.panelDer;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import algo3.algocity.model.Juego;
import algo3.algocity.model.caracteristicas.Agregable;
import algo3.algocity.model.conexiones.Conector;
import algo3.algocity.model.construcciones.Unidad;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.view.panelIzq.botonesPanelOpciones.Boton;

public class VistaMapa extends JPanel implements Observer {

	private static final long serialVersionUID = 5750354545703155652L;

	Juego juego;
	Mapa mapa;
	VistaPanelDer contenedor;
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
		System.out.println(o.getClass().getSimpleName());
		System.out.println("primer update" + ((Agregable) arg).coordenada());
		try {
			Method local = getClass().getMethod("setPosicion",
					arg.getClass().getSuperclass());
			System.out.println("busqueda metodo setPosicion");
			local.invoke(this, arg);
			System.out.println("metodo invocado ok");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			System.out.println("aca");
			e.printStackTrace();
		}
		System.out.println("repintando");
		repintar(((Agregable) arg).coordenada());
		System.out.println("agregado");
	}

	public void setPosicion(UnidadEnergetica unidad)
			throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		System.out.print("setPosicion unidadEnergetica en coord:");
		System.out.println(unidad.coordenada());
		Method metodo = getClass().getMethod("setPosicion",
				unidad.getClass().getSuperclass().getSuperclass());
		metodo.invoke(this,(Unidad) unidad);
	}

	public void setPosicion(Unidad unidad) {
		System.out.println("setCposicion unidad");
		Coordenada coord = unidad.coordenada();
		System.out.print("define coordenada ");
		System.out.println(coord.getX() + "," + coord.getY() + "+");
		System.out.println("agrega a tabla[][]");
		tabla[coord.getX()][coord.getY()] = (mapa.ciudad()
				.tieneCoordenadaOcupada(coord)) ? new VistaUnidad(juego, coord)
				: new VistaTerreno(juego, coord);
		System.out.println("agregado a tabla[][]");
	}

	public void setPosicion(Conector conector) {
		Coordenada coord = conector.coordenada();
		System.out.print("Conector");
		System.out.println(coord.getX() + "," + coord.getY() + "-");
		tabla[coord.getX()][coord.getY()] = (mapa.rutas()
				.tieneCoordenadaOcupada(coord) || mapa.redElectrica()
				.tieneCoordenadaOcupada(coord)) ? new VistaConector(juego,
				coord, conector) : new VistaTerreno(juego, coord);
	}

	private void setPosicion(Coordenada coord) {
		System.out.println("Seteando pos iniciales");
		if(mapa.ciudad().tieneCoordenadaOcupada(coord)){
			tabla[coord.getX()][coord.getY()] = new VistaUnidad(juego, coord);
		}else if(mapa.redElectrica().tieneCoordenadaOcupada(coord)){
			Conector c = mapa.redElectrica().getConectorEn(coord.getX(), coord.getY());
			tabla[coord.getX()][coord.getY()] = new VistaConector(juego,coord, c);
		}else if(mapa.rutas().tieneCoordenadaOcupada(coord)){
			Conector c = mapa.rutas().getConectorEn(coord);
			tabla[coord.getX()][coord.getY()] = new VistaConector(juego,coord, c);
		} else{
			tabla[coord.getX()][coord.getY()] = new VistaTerreno(juego, coord);
		}
		
	}

	private void repintar(Coordenada coord) {
		System.out.print("repintando coord ");
		System.out.println(coord.getX() + "," + coord.getY());
		int i = (coord.getX()) * mapa.tamanio() + coord.getY();
		remove(i);
		add(tabla[coord.getX()][coord.getY()], i);
		revalidate();
	}

}
