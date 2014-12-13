package algo3.algocity.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VistaPanelOpciones extends JPanel {
	
	private static final long serialVersionUID = 6011424322780190648L;

	public VistaPanelOpciones(){
		setLayout(new GridLayout(3,2));
		inicializarMenu();
	}

	private void inicializarMenu() {
		ImageIcon residencial = new ImageIcon("img/b_residencial.png");
		ImageIcon comercial = new ImageIcon("img/b_comercial.png");
		ImageIcon industrial = new ImageIcon("img/b_industrial.png");
		ImageIcon nuclear = new ImageIcon("img/b_nuclear.png");
		ImageIcon ruta = new ImageIcon("img/b_ruta.png");
		ImageIcon lineaTension = new ImageIcon("img/b_linea_tension.png");
		
		
		add(new JButton(residencial));
		add(new JButton(comercial));
		add(new JButton(industrial));
		add(new JButton(nuclear));
		add(new JButton(ruta));
		add(new JButton(lineaTension));
	}

}
