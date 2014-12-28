package algo3.algocity.view.panelSup;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.StyleConstants;

public class VistaVentanaAcerca extends JFrame {

	private static final long serialVersionUID = -1474006066988397183L;
	
	JTextPane texto, link;
	JPanel panel;

	String vinculo = "https://github.com/carlosbollero/TP2_AlgoCity";
	String alumnos = "   Alumnos:";
	String alumno1 = "\n    Olivera, Rodrigo";
	String alumno2 = "\n    Botalla, Tomas";
	String alumno3 = "\n    Bollero, Carlos";
	
	public VistaVentanaAcerca() {
		
		texto = new JTextPane();
		texto.setText(alumnos + alumno1 + alumno2 + alumno3);
		texto.setEditable(false);
		texto.setBackground(null);
		texto.setFocusable(false);
		
		link = new JTextPane();
		link.setText(vinculo);
		link.setEditable(false);
		link.setBackground(null);
		link.setFont(new Font("Serif", Font.ITALIC, 11));
		link.setAlignmentX(StyleConstants.ALIGN_CENTER);
		link.setFocusable(true);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new ImagenAlgoCity(), BorderLayout.CENTER);
		panel.add(texto, BorderLayout.EAST);
		panel.add(link, BorderLayout.SOUTH);
		
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
