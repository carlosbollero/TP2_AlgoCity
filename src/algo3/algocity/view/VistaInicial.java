package algo3.algocity.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VistaInicial extends JPanel {

	private static final long serialVersionUID = 1421984080735437357L;

	VentanaInicial ventanaPortadora;
	
	Image imagenFondo;
	JPanel panelCentral;

	
	/*Este es el panel principal de la ventana*/
	public VistaInicial(VentanaInicial ventana) {
		this.ventanaPortadora = ventana;
		
		setPreferredSize(new Dimension(800, 600));
		setLayout(new BorderLayout());
		
		initPaneles();
		setPaneles();	
	}
	
	
	private void initPaneles(){
		this.panelCentral = new JPanel();
		
	}
	
	private void setPaneles(){
		
		VistaInicialMenu vista3 = new VistaInicialMenu(this.ventanaPortadora);
		panelCentral.add(vista3);
		
		//this.panelCentral.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.panelCentral.setPreferredSize(new Dimension(150,150));
		add(this.panelCentral);
		setVisible(true);
	}

	
	
	
	/*Setea la imagen de fondo del panel principal*/
	/*
	@Override
	public void paintComponent(Graphics g) {
		Dimension tamanio = getSize();
		this.imagenFondo = new ImageIcon("img/fondoInicioJuego.jpg").getImage();
		g.drawImage(this.imagenFondo, 0, 0, getWidth(), getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}
	*/
}
