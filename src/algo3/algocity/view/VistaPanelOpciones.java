package algo3.algocity.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import algo3.algocity.controller.accionboton.AccionBotonBomberos;
import algo3.algocity.controller.accionboton.AccionBotonCentralEolica;
import algo3.algocity.controller.accionboton.AccionBotonComercio;
import algo3.algocity.controller.accionboton.AccionBotonIndustrial;
import algo3.algocity.controller.accionboton.AccionBotonLineaTension;
import algo3.algocity.controller.accionboton.AccionBotonMinera;
import algo3.algocity.controller.accionboton.AccionBotonNuclear;
import algo3.algocity.controller.accionboton.AccionBotonPozoAgua;
import algo3.algocity.controller.accionboton.AccionBotonResidencia;
import algo3.algocity.controller.accionboton.AccionBotonRuta;
import algo3.algocity.controller.accionboton.AccionBotonTuberia;

public class VistaPanelOpciones extends JPanel {

	private static final long serialVersionUID = 6011424322780190648L;
	
	Ventana ventana;
	VistaMapa vMapa;
	JButton b_residencial;
	JButton b_comercial;
	JButton b_industrial;
	JButton b_bomberos;
	JButton b_nuclear;
	JButton b_ruta;
	JButton b_lineaTension;
	JButton b_centralEolica;
	JButton b_centralMinera;
	JButton b_tuberia;
	JButton b_pozoDeAgua;
	JButton b_buldozer;
	
	public VistaPanelOpciones(Ventana ventana) {
		this.ventana = ventana;
		vMapa = ventana.getVistaPanelDer().getVistaMapa();
		setPreferredSize(new Dimension(200, 550));
		setLayout(new GridLayout(4, 3));
		inicializarMenu();
	}

	private void inicializarMenu() {
		setImagenes();
		setEtiquetas();
		agregarBotonesAlPanel();
		agregarAcciones();
	}

	private void setImagenes() {
		b_residencial = new JButton(new ImageIcon("img/b_residencial.png"));
		b_industrial = new JButton(new ImageIcon("img/b_industrial.png"));
		b_comercial = new JButton(new ImageIcon("img/b_comercial.png"));
		b_bomberos = new JButton(new ImageIcon("img/b_bomberos.png"));
		b_nuclear = new JButton(new ImageIcon("img/b_nuclear.png"));
		b_centralEolica = new JButton(new ImageIcon("img/b_linea_tension.png"));
		b_centralMinera = new JButton(new ImageIcon("img/b_linea_tension.png"));
		b_ruta = new JButton(new ImageIcon("img/b_ruta.png"));
		b_lineaTension = new JButton(new ImageIcon("img/b_linea_tension.png"));
		b_tuberia = new JButton(new ImageIcon("img/b_linea_tension.png"));
		b_pozoDeAgua = new JButton(new ImageIcon("img/b_linea_tension.png"));
		b_buldozer = new JButton(new ImageIcon("img/bulldozer.png"));
	}

	private void setEtiquetas() {
		b_residencial.setToolTipText("Unidad Residencial");
		b_industrial.setToolTipText("Unidad Industrial");
		b_comercial.setToolTipText("Unidad Comercial");
		b_bomberos.setToolTipText("Bomberos");
		b_nuclear.setToolTipText("Central Nuclear");
		b_ruta.setToolTipText("Ruta");
		b_lineaTension.setToolTipText("Linea de Tensión");
		b_centralEolica.setToolTipText("Central Eolica");
		b_centralMinera.setToolTipText("Central Minera");
		b_tuberia.setToolTipText("Tuberia");
		b_pozoDeAgua.setToolTipText("Pozo de Agua");
		b_buldozer.setToolTipText("Buldozer");
	}

	private void agregarAcciones() {
		b_ruta.addActionListener(new AccionBotonRuta(vMapa));
		b_residencial.addActionListener(new AccionBotonResidencia(vMapa));
		b_industrial.addActionListener(new AccionBotonIndustrial(vMapa));
		b_comercial.addActionListener(new AccionBotonComercio(vMapa));
		b_bomberos.addActionListener(new AccionBotonBomberos(vMapa));
		b_nuclear.addActionListener(new AccionBotonNuclear(vMapa));
		b_lineaTension.addActionListener(new AccionBotonLineaTension(vMapa));
		b_centralEolica.addActionListener(new AccionBotonCentralEolica(vMapa));
		b_centralMinera.addActionListener(new AccionBotonMinera(vMapa));
		b_tuberia.addActionListener(new AccionBotonTuberia(vMapa));
		b_pozoDeAgua.addActionListener(new AccionBotonPozoAgua(vMapa));
//		b_buldozer.addActionListener(new AccionBotonBuldozer(vMapa));
	}

	private void agregarBotonesAlPanel() {
		add(b_residencial);
		add(b_comercial);
		add(b_industrial);
		add(b_nuclear);
		add(b_centralEolica);
		add(b_centralMinera);
		add(b_ruta);
		add(b_lineaTension);
		add(b_tuberia);
		add(b_bomberos);
		add(b_pozoDeAgua);
		add(b_buldozer);
	}

}
