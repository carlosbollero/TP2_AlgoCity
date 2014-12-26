package algo3.algocity.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JPanel;

public class VistaJugadorNuevoOExistente extends JPanel{

	private static final long serialVersionUID = -4061331838425983438L;

	VentanaInicial ventanaPortadora;
	
	Image imagenFondo;
	JPanel panelCentral;
	
	public VistaJugadorNuevoOExistente(VentanaInicial ventana){
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
		
		VistaJugadorNuevoOExistenteMenu vista4 = new VistaJugadorNuevoOExistenteMenu(this.ventanaPortadora);
		panelCentral.add(vista4);
		
		//this.panelCentral.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.panelCentral.setPreferredSize(new Dimension(150,150));
		add(this.panelCentral);
		setVisible(true);

	}
}
