package algo3.algocity.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import algo3.algocity.controller.AccionMouseJugadorExistente;
import algo3.algocity.controller.AccionMouseJugadorNuevo;
import algo3.algocity.controller.AccionMouseVolverMenuInicioJuego;

public class VistaJugadorNuevoOExistenteMenu extends JPanel {

	private static final long serialVersionUID = -3353217854288228571L;

	VentanaInicial ventanaPortadora;
	Image imagenFondo;
	
	JButton bJugadorNuevo;
	JButton bJugadorExistente;
	JButton bVolver;
	
	public VistaJugadorNuevoOExistenteMenu(VentanaInicial ventana) {
		super();
		this.ventanaPortadora = ventana;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//setMinimumSize(new Dimension(25, 50));
		//setMaximumSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));
		
		setContenido();
	}

	private void setContenido(){
		
		bJugadorNuevo = new JButton("Jugador Nuevo");
		bJugadorExistente = new JButton("Jugador Existente");
		bVolver = new JButton("Volver");
		
		add(Box.createRigidArea(new Dimension(0,250)));
		
		add(bJugadorNuevo);
		bJugadorNuevo.setAlignmentX(Component.CENTER_ALIGNMENT);
		bJugadorNuevo.addActionListener(new AccionMouseJugadorNuevo(this.ventanaPortadora));
		
		add(Box.createRigidArea(new Dimension(0,25)));
		
		add(bJugadorExistente);
		bJugadorExistente.setAlignmentX(Component.CENTER_ALIGNMENT);
		bJugadorExistente.addActionListener(new AccionMouseJugadorExistente(this.ventanaPortadora));
		
		add(Box.createRigidArea(new Dimension(0,25)));
		
		add(bVolver);
		bVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		bVolver.addActionListener(new AccionMouseVolverMenuInicioJuego(this.ventanaPortadora));
	}
	
	/*Setea la imagen de fondo del panel*/
	@Override
	public void paintComponent(Graphics g) {
		Dimension tamanio = getSize();
		this.imagenFondo = new ImageIcon("img/fondoAlgoCity.jpg").getImage();
		g.drawImage(this.imagenFondo, 0, 0, getWidth(), getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
