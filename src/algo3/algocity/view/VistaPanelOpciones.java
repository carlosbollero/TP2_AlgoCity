package algo3.algocity.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VistaPanelOpciones extends JPanel {

	private static final long serialVersionUID = 6011424322780190648L;

	JButton b_residencial;
	JButton b_comercial;
	JButton b_industrial;
	JButton b_bomberos;
	JButton b_nuclear;
	JButton b_ruta;
	JButton b_lineaTension;

	public VistaPanelOpciones() {
		setPreferredSize(new Dimension(200, 550));
		setLayout(new GridLayout(4, 2));
		inicializarMenu();
	}

	private void inicializarMenu() {

		b_residencial = new JButton(new ImageIcon("img/b_residencial.png"));
		b_industrial = new JButton(new ImageIcon("img/b_industrial.png"));
		b_comercial = new JButton(new ImageIcon("img/b_comercial.png"));
		b_bomberos = new JButton(new ImageIcon("img/b_bomberos.png"));
		b_nuclear = new JButton(new ImageIcon("img/b_nuclear.png"));
		b_ruta = new JButton(new ImageIcon("img/b_ruta.png"));
		b_lineaTension = new JButton(new ImageIcon("img/b_linea_tension.png"));

		add(b_residencial);
		add(b_comercial);
		add(b_industrial);
		add(b_bomberos);
		add(b_nuclear);
		add(b_ruta);
		add(b_lineaTension);
	}

}
