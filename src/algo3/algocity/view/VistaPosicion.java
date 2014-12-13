package algo3.algocity.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import algo3.algocity.model.terreno.Superficie;

public class VistaPosicion extends JPanel {

	private static final long serialVersionUID = -8808512415555786403L;

	Image imagen;
	private BufferedImage image;
	Dimension tamanio;

	public VistaPosicion(Superficie superficie) {
		setSize(20, 20);
		imagen = new ImageIcon("./img/tierra.png").getImage();
//		tamanio = new Dimension(image.getWidth(null),image.getHeight(null));
//		setPreferredSize(tamanio);
//	    setMinimumSize(tamanio);
//	    setMaximumSize(tamanio);
//	    setSize(tamanio);
//	    setLayout(null);

	}

	@Override
	public void paintComponent(Graphics grafico) {
		
		// super.paintComponent(grafico);
		grafico.drawImage(image, 0, 0, null);
//		grafico.drawImage(imagen.getImage(), 0, 0, tamanio.width,
//				tamanio.height, null);
		setOpaque(false);
		super.paintComponent(grafico);
	}

}
