package algo3.algocity.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import algo3.algocity.controller.AccionMouseGuardarJuego;
import algo3.algocity.controller.AccionMouseSalirJuego;
import algo3.algocity.controller.AccionMouseVistaSubterranea;
import algo3.algocity.controller.AccionMouseVistaSuperficial;
import algo3.algocity.model.Juego;

public class VistaPanelSup extends JMenuBar {

	private static final long serialVersionUID = -3892726120581801752L;

	Juego juego;
	VistaMapa vistaMapa;
	JPanel vistaTuberias;

	JMenu m_menu;
	JMenuItem i_guardar;
	JMenuItem i_salir;

	JMenu m_vista;
	JMenuItem i_superficial;
	JMenuItem i_subterranea;

	JMenu m_ayuda;
	JMenuItem i_acerca;

	public VistaPanelSup(VistaMapa vista, JPanel vistatuberias, Juego juego) {
		this.juego = juego;
		vistaMapa = vista;
		this.vistaTuberias = vistatuberias;
		setMenuArchivo();
		setMenuVista();
		setMenuAyuda();

	}

	private void setMenuArchivo() {
		m_menu = new JMenu("Menu");
		i_guardar = new JMenuItem("Guardar");
		i_guardar.addActionListener(new AccionMouseGuardarJuego(juego));
		i_salir = new JMenuItem("Salir");
		i_salir.addActionListener(new AccionMouseSalirJuego());
		m_menu.add(i_guardar);
		m_menu.addSeparator();
		m_menu.add(i_salir);

		add(m_menu);
	}

	private void setMenuVista() {
		m_vista = new JMenu("Vista");
		i_superficial = new JMenuItem("Superficial");
		i_superficial.addActionListener(new AccionMouseVistaSuperficial(
				vistaMapa, vistaTuberias));
		i_subterranea = new JMenuItem("Subterranea");
		i_subterranea.addActionListener(new AccionMouseVistaSubterranea(
				vistaMapa, vistaTuberias));
		m_vista.add(i_superficial);
		m_vista.add(i_subterranea);

		add(m_vista);
	}

	private void setMenuAyuda() {
		m_ayuda = new JMenu("Ayuda");
		i_acerca = new JMenuItem("Acerca");
		// i_acerca.addActionListener(new AccionMouseAcerca());
		m_ayuda.add(i_acerca);

		add(m_ayuda);
	}

}
