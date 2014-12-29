package algo3.algocity.view.vistaInicial;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import algo3.algocity.model.RegistroUsuarios;
import algo3.algocity.view.VentanaInicial;

public class VistaJugadorExistente extends JPanel {
	private static final long serialVersionUID = 3830075888681236725L;
	VentanaInicial ventanaPortadora;
	JPanel panelCentral;

	public VistaJugadorExistente(VentanaInicial ventana, RegistroUsuarios ru) throws SAXException,
			IOException, ParserConfigurationException {
		this.ventanaPortadora = ventana;
		setPreferredSize(new Dimension(800, 600));
		setLayout(new BorderLayout());
		initPaneles();
		setPaneles(ru);
	}

	private void initPaneles() {
		this.panelCentral = new JPanel();
	}

	private void setPaneles(RegistroUsuarios ru) throws SAXException, IOException,
			ParserConfigurationException {
		VistaJugadorExistenteMenu vistaMenu = new VistaJugadorExistenteMenu(
				this.ventanaPortadora,ru);
		panelCentral.add(vistaMenu);
		this.panelCentral.setPreferredSize(new Dimension(150, 150));
		add(this.panelCentral);
		setVisible(true);
	}
}