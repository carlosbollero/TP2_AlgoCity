package algo3.algocity.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import algo3.algocity.controller.AccionMouseVistaSubterranea;
import algo3.algocity.controller.AccionMouseVistaSuperficial;

public class VistaPanelSup extends JMenuBar {

	private static final long serialVersionUID = -3892726120581801752L;

	VistaMapa vistaMapa;

	JMenu m_menu;
	JMenu m_vista;

	JMenuItem i_guardar;
	JMenuItem i_salir;
	JMenuItem i_superficial;
	JMenuItem i_subterranea;

	public VistaPanelSup(VistaMapa vista) {
		vistaMapa = vista;
		setMenuArchivo();
		add(m_menu);
		setMenuVista();
		add(m_vista);
	}

	private void setMenuArchivo() {
		m_menu = new JMenu("Menu");
		i_guardar = new JMenuItem("Guardar");
		i_salir = new JMenuItem("Salir");
		m_menu.add(i_guardar);
		m_menu.addSeparator();
		m_menu.add(i_salir);
	}

	private void setMenuVista() {
		m_vista = new JMenu("Vista");
		i_superficial = new JMenuItem("Superficial");
		i_superficial.addActionListener(new AccionMouseVistaSuperficial(vistaMapa));
		i_subterranea = new JMenuItem("Subterranea");
		i_subterranea.addActionListener(new AccionMouseVistaSubterranea(vistaMapa));
		m_vista.add(i_superficial);
		m_vista.add(i_subterranea);
	}

}
