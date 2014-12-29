package algo3.algocity.view.vistaInicial;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import algo3.algocity.model.RegistroUsuarios;
import algo3.algocity.view.VentanaInicial;

public class VistaJugadorNuevo extends JPanel {

	private static final long serialVersionUID = -4907347486459724854L;

	VentanaInicial ventanaPortadora;
	
	JPanel panelCentral;

	public VistaJugadorNuevo(VentanaInicial ventana, RegistroUsuarios ru) {
		this.ventanaPortadora = ventana;

		setPreferredSize(new Dimension(800, 600));
		setLayout(new BorderLayout());
		
		initPaneles();
		setPaneles(ru);
	}
	
	private void initPaneles(){
		this.panelCentral = new JPanel();
		
	}
	
	private void setPaneles(RegistroUsuarios ru){
		
		VistaJugadorNuevoMenu vistaMenu = new VistaJugadorNuevoMenu(this.ventanaPortadora,ru);
		panelCentral.add(vistaMenu);

		this.panelCentral.setPreferredSize(new Dimension(150,150));
		add(this.panelCentral);
		setVisible(true);
	}

}
