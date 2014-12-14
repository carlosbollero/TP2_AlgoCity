package algo3.algocity.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VistaPanelSup extends JMenuBar {

	private static final long serialVersionUID = -3892726120581801752L;
	
	JMenu m_menu;
	
	JMenuItem i_guardar;
	JMenuItem i_salir;

	public VistaPanelSup(){
		setMenuArchivo();
		add(m_menu);

	}

	private void setMenuArchivo() {
		m_menu = new JMenu("Menu");
		i_guardar = new JMenuItem("Guardar");
		i_salir = new JMenuItem("Salir");
		m_menu.add(i_guardar);
		m_menu.addSeparator();
		m_menu.add(i_salir);
	}


}
