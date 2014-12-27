package algo3.algocity.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import algo3.algocity.controller.AccionMouseComenzarConJugadorNuevo;
import algo3.algocity.controller.AccionMouseVolverMenuInicioJuego;

public class VistaJugadorNuevoMenu extends JPanel {

	private static final long serialVersionUID = -4357344124215831133L;

	VentanaInicial ventanaPortadora;
	Image imagenFondo;

	JPanel panelNombre;
	JTextField areaNombre;
	JTextField panelInforme;
	JButton bComenzar;
	JButton bVolver;

	public VistaJugadorNuevoMenu(VentanaInicial ventana) {
		this.ventanaPortadora = ventana;

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		// setMinimumSize(new Dimension(25, 50));
		// setMaximumSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));
		setContenido();
	}

	private void setContenido() {

		/* Ajusto el panel del nombre */
		this.panelNombre = new JPanel();
		this.panelNombre.setPreferredSize(new Dimension(400, 28));
		this.panelNombre.setMaximumSize(new Dimension(400, 28));
		this.panelNombre
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.panelNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.panelNombre.setAlignmentY(Component.CENTER_ALIGNMENT);

		/* Agrego los componentes del panel del nombre */
		JLabel etiquetaNombre = new JLabel("Nombre Jugador:", JLabel.CENTER);
		etiquetaNombre.setOpaque(true);
		// etiquetaNombre.setForeground(Color.red);
		this.areaNombre = new JTextField(15);
		this.panelNombre.add(etiquetaNombre);
		this.panelNombre.add(Box.createRigidArea(new Dimension(10, 0)));
		this.panelNombre.add(this.areaNombre);

		// this.panelNombre.setBackground(Color.lightGray);

		/* Ajusto el panel de informe */
		this.panelInforme = new JTextField("");
		this.panelInforme.setPreferredSize(new Dimension(350, 27));
		this.panelInforme.setMaximumSize(new Dimension(350, 27));
		this.panelInforme.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.panelInforme.setAlignmentY(Component.CENTER_ALIGNMENT);
		// this.panelInforme.setBackground(Color.white);
		this.panelInforme.setForeground(Color.red);
		this.panelInforme.setHorizontalAlignment(JTextField.CENTER);

		/* Ajusto los botones */
		this.bComenzar = new JButton(" Comenzar !!");
		this.bComenzar.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.bComenzar.setAlignmentY(Component.CENTER_ALIGNMENT);
		this.bComenzar
				.addActionListener(new AccionMouseComenzarConJugadorNuevo(
						this.ventanaPortadora, areaNombre,
						this.panelInforme));

		this.bVolver = new JButton("Volver");
		this.bVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.bVolver.setAlignmentY(Component.CENTER_ALIGNMENT);
		this.bVolver
				.addActionListener(new AccionMouseVolverMenuInicioJuego(
						this.ventanaPortadora));

		add(Box.createRigidArea(new Dimension(0, 250)));
		add(this.panelNombre);
		add(Box.createRigidArea(new Dimension(0, 25)));
		add(this.panelInforme);
		add(Box.createRigidArea(new Dimension(0, 25)));
		add(this.bComenzar);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(this.bVolver);
		add(Box.createRigidArea(new Dimension(0, 250)));
	}

	/* Setea la imagen de fondo del panel */
	@Override
	public void paintComponent(Graphics g) {
		Dimension tamanio = getSize();
		// Dimension tamanio = new Dimension(800,600);
		this.imagenFondo = new ImageIcon("img/fondoAlgoCity.jpg").getImage();
		g.drawImage(this.imagenFondo, 0, 0, getWidth(), getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
