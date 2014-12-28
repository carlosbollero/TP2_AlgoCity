package algo3.algocity.view.vistaInicial;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import algo3.algocity.controller.AccionMouseVolverMenuInicioJuego;
import algo3.algocity.model.RegistroUsuarios;
import algo3.algocity.model.excepciones.NoSeEncontroElFicheroException;
import algo3.algocity.view.VentanaInicial;

public class VistaPuntajesMenu extends JPanel {
	private static final long serialVersionUID = -5991160202284758342L;

	VentanaInicial ventanaPortadora;
	Image imagenFondo;

	JButton bVolver;

	public VistaPuntajesMenu(VentanaInicial ventana)
			throws NoSeEncontroElFicheroException, SAXException, IOException,
			ParserConfigurationException {
		super();
		this.ventanaPortadora = ventana;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		// setMinimumSize(new Dimension(25, 50));
		// setMaximumSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));

		setContenido();
	}

	private void setContenido() throws NoSeEncontroElFicheroException,
			SAXException, IOException, ParserConfigurationException {

		bVolver = new JButton("Volver");

		add(Box.createRigidArea(new Dimension(0, 250)));

		// Obtengo los usuarios existentes
		RegistroUsuarios ru = new RegistroUsuarios();
		ArrayList<String> puntajes = ru.listaPuntajesString();
		String[] datos = new String[puntajes.size()];
		Iterator<String> it = puntajes.iterator();
		int i = 0;
		while (it.hasNext()) {
			datos[i] = it.next();
			i++;
		}

		JList<String> lista = new JList<String>(datos);
		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		lista.setLayoutOrientation(JList.HORIZONTAL_WRAP);

		JScrollPane panelDesplazamiento = new JScrollPane(lista);

		panelDesplazamiento.setPreferredSize(new Dimension(175, 85));
		panelDesplazamiento.setMaximumSize(new Dimension(175, 85));
		panelDesplazamiento
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panelDesplazamiento.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelDesplazamiento.setAlignmentY(Component.CENTER_ALIGNMENT);

		add(panelDesplazamiento);
		add(Box.createRigidArea(new Dimension(0, 25)));

		add(bVolver);
		bVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		bVolver.addActionListener(new AccionMouseVolverMenuInicioJuego(
				this.ventanaPortadora));
		add(Box.createRigidArea(new Dimension(0, 150)));
	}

	/* Setea la imagen de fondo del panel */
	@Override
	public void paintComponent(Graphics g) {
		this.imagenFondo = new ImageIcon("img/fondoAlgoCity.jpg").getImage();
		g.drawImage(this.imagenFondo, 0, 0, getWidth(), getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
