package algo3.algocity.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import algo3.algocity.model.excepciones.NoSeEncontroElFicheroException;

public class VistaPuntajes extends JPanel {

	private static final long serialVersionUID = 6802067655885366386L;
	
	VentanaInicial ventanaPortadora;
	
	JPanel panelCentral;
	
	public VistaPuntajes(VentanaInicial ventana) throws SAXException, IOException, ParserConfigurationException, NoSeEncontroElFicheroException{
		this.ventanaPortadora = ventana;

		setPreferredSize(new Dimension(800, 600));
		setLayout(new BorderLayout());
	
		initPaneles();
		setPaneles();
	}
	
	private void initPaneles(){
		this.panelCentral = new JPanel();
		
	}
	
	private void setPaneles() throws SAXException, IOException, ParserConfigurationException, NoSeEncontroElFicheroException{
		
		VistaPuntajesMenu vistaMenu = new VistaPuntajesMenu(this.ventanaPortadora);
		panelCentral.add(vistaMenu);

		this.panelCentral.setPreferredSize(new Dimension(150,150));
		add(this.panelCentral);
		setVisible(true);
	}	
		
	

}
