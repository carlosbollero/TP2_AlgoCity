package algo3.algocity.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import algo3.algocity.model.terreno.Superficie;

public class VistaPosicion extends JPanel {

	private static final long serialVersionUID = -8808512415555786403L;

	Image imagen;

	public VistaPosicion(Superficie superficie) {
		imagen = (superficie.esAgua()) ? new ImageIcon("img/water.png")
				.getImage() : new ImageIcon("img/dirt.png").getImage();

	}

	public void paintComponent(Graphics g) {
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
	}

}
