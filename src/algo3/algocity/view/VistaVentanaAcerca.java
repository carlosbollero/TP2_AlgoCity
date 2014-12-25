package algo3.algocity.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class VistaVentanaAcerca extends JFrame {

	private static final long serialVersionUID = -1474006066988397183L;
	
	JTextPane texto;
	JTextPane titulo;
	JPanel panel;

	String alumno1 = "\n  Olivera, Rodrigo";
	String alumno2 = "\n  Botalla, Tomas";
	String alumno3 = "\n  Bollero, Carlos";
	
	public VistaVentanaAcerca() {
		
		texto = new JTextPane();
		texto.setText("Alumnos:" + alumno1 + alumno2 + alumno3);
		texto.setEditable(false);
		texto.setBackground(null);
		texto.setFocusable(false);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new ImagenAlgoCity(), BorderLayout.CENTER);
		panel.add(texto, BorderLayout.EAST);
		
		add(panel);
		
		pack();
		setLocationRelativeTo(null);
		validate();
		setVisible(true);
		setResizable(false);
	}
	
	class ImagenAlgoCity extends JPanel{

		private static final long serialVersionUID = -5829519721392551973L;
		String ruta;
		Image imagen;
		
		public ImagenAlgoCity() {
			ruta = "img/algocity_icon.png";
			ImageIcon icon = new ImageIcon("img/algocity_icon.png"); 
			imagen = icon.getImage();
			setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
//			super.paintComponent(g);
		}
	}
	
	public static void main(String[] args) {
		new VistaVentanaAcerca();
	}

}
