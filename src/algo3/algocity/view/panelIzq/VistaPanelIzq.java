package algo3.algocity.view.panelIzq;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import algo3.algocity.controller.ControladorMensajes;
import algo3.algocity.model.Juego;
import algo3.algocity.view.VentanaJuego;

public class VistaPanelIzq extends JPanel {

	private static final long serialVersionUID = 5830016803052863621L;

	VentanaJuego contenedor;

	VistaPanelInfo vistaPanelInfo;
	VistaPanelOpciones vistaPanelOpciones;

	public VistaPanelIzq(Juego juego, VentanaJuego ventana) {
		contenedor = ventana;
		setPreferredSize(new Dimension(200, 600));
		setLayout(new BorderLayout());
		vistaPanelInfo = new VistaPanelInfo(juego, this);
		add(vistaPanelInfo, BorderLayout.NORTH);
		vistaPanelOpciones = new VistaPanelOpciones(this);
		add(vistaPanelOpciones, BorderLayout.CENTER);
	}

	public VistaPanelInfo getPanelInfo() {
		return vistaPanelInfo;
	}

	public VistaPanelOpciones getPanelOpciones() {
		return vistaPanelOpciones;
	}
	
	public ControladorMensajes getControladorMensajes() {
		return contenedor.getControladorMensajes();
	}

}
