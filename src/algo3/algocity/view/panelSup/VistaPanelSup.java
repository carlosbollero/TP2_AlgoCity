package algo3.algocity.view.panelSup;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import algo3.algocity.controller.AccionMenuAcerca;
import algo3.algocity.controller.AccionMenuGuardarJuego;
import algo3.algocity.controller.AccionMenuSalirJuego;
import algo3.algocity.controller.AccionMenuVistaSubterranea;
import algo3.algocity.controller.AccionMenuVistaSuperficial;
import algo3.algocity.model.Juego;
import algo3.algocity.view.VentanaJuego;
import algo3.algocity.view.panelDer.VistaMapa;
import algo3.algocity.view.panelDer.VistaMapaSubterraneo;

public class VistaPanelSup extends JMenuBar {

	private static final long serialVersionUID = -3892726120581801752L;

	Juego juego;
	VistaMapa vistaMapa;
	VistaMapaSubterraneo vistaMapaSub;
	
	JPanel panelDer;
	JFrame ventana;

	JMenu m_archivo;
	JMenuItem i_guardar;
	JMenuItem i_salir;

	JMenu m_vista;
	JMenuItem i_superficial;
	JMenuItem i_subterranea;

	JMenu m_ayuda;
	JMenuItem i_acerca;

	public VistaPanelSup(Juego juego, VentanaJuego ventana) {
		this.juego = juego;
		panelDer = ventana.getPanelDer();
		setMenuArchivo();
		setMenuVista();
		setMenuAyuda();
	}

	private void setMenuArchivo() {
		m_archivo = new JMenu("Archivo");
		i_guardar = new JMenuItem("Guardar");
		i_guardar.addActionListener(new AccionMenuGuardarJuego(juego));
		i_salir = new JMenuItem("Salir");
		i_salir.addActionListener(new AccionMenuSalirJuego());
		m_archivo.add(i_guardar);
		m_archivo.addSeparator();
		m_archivo.add(i_salir);

		add(m_archivo);
	}

	private void setMenuVista() {
		m_vista = new JMenu("Vista");
		i_superficial = new JMenuItem("Superficial");
		i_superficial.addActionListener(new AccionMenuVistaSuperficial(
				panelDer));
		i_subterranea = new JMenuItem("Subterranea");
		i_subterranea.addActionListener(new AccionMenuVistaSubterranea(
				panelDer));
		m_vista.add(i_superficial);
		m_vista.add(i_subterranea);

		add(m_vista);
	}

	private void setMenuAyuda() {
		m_ayuda = new JMenu("Ayuda");
		i_acerca = new JMenuItem("Acerca");
		i_acerca.addActionListener(new AccionMenuAcerca());
		m_ayuda.add(i_acerca);

		add(m_ayuda);
	}

}
