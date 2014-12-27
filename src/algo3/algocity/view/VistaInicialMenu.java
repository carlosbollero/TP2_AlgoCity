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

import algo3.algocity.controller.AccionMouseContinuarPartida;
import algo3.algocity.controller.AccionMouseIniciarPartida;
import algo3.algocity.controller.AccionMouseSalirJuego;
import algo3.algocity.controller.AccionMouseVerPuntajes;

public class VistaInicialMenu extends JPanel{

	private static final long serialVersionUID = 4364337929569456655L;
	
	VentanaInicial ventanaPortadora;
	Image imagenFondo;
	
	JButton bIniciarPartida;
	JButton bContinuarPartida;
	JButton bVerPuntajes;
	JButton bSalir;

	
	public VistaInicialMenu(VentanaInicial ventana){
		super();
		this.ventanaPortadora = ventana;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//setMinimumSize(new Dimension(25, 50));
		//setMaximumSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));
		
		setContenido();
		
	}
	
	private void setContenido(){
		
		bIniciarPartida = new JButton("Iniciar Partida");
		bContinuarPartida = new JButton("Continuar Partida");
		bVerPuntajes = new JButton("Ver Puntajes");
		bSalir = new JButton("Salir");

		
		add(Box.createRigidArea(new Dimension(0,250)));
		
		add(bIniciarPartida);
		bIniciarPartida.setAlignmentX(Component.CENTER_ALIGNMENT);
		bIniciarPartida.addActionListener(new AccionMouseIniciarPartida(ventanaPortadora));
		
		add(Box.createRigidArea(new Dimension(0,25)));
		
		add(bContinuarPartida);
		bContinuarPartida.setAlignmentX(Component.CENTER_ALIGNMENT);
		bContinuarPartida.addActionListener(new AccionMouseContinuarPartida(ventanaPortadora));
		
		add(Box.createRigidArea(new Dimension(0,25)));
		
		add(bVerPuntajes);
		bVerPuntajes.setAlignmentX(Component.CENTER_ALIGNMENT);
		bVerPuntajes.addActionListener(new AccionMouseVerPuntajes(ventanaPortadora));
		//ver de hacer esto con un JDialog y que levante una ventana nueva
		
		
		add(Box.createRigidArea(new Dimension(0,25)));
		
		add(bSalir);
		bSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
		bSalir.addActionListener(new AccionMouseSalirJuego());
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
