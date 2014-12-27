package algo3.algocity.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import algo3.algocity.model.Juego;

public class VistaPanelIzq extends JPanel {

	private static final long serialVersionUID = 5830016803052863621L;

	Ventana contenedor;

	VistaPanelInfo vistaPanelInfo;
	VistaPanelOpciones vistaPanelOpciones;

	public VistaPanelIzq(Juego juego, Ventana ventana) {
		contenedor = ventana;
		setPreferredSize(new Dimension(200, 600));
		setLayout(new BorderLayout());
		vistaPanelInfo = new VistaPanelInfo(juego);
		add(vistaPanelInfo, BorderLayout.NORTH);
		vistaPanelOpciones = new VistaPanelOpciones(contenedor);
		add(vistaPanelOpciones, BorderLayout.CENTER);
	}

	public VistaPanelInfo getVistaPanelInfo() {
		return vistaPanelInfo;
	}

	public VistaPanelOpciones getVistaPanelOpciones() {
		return vistaPanelOpciones;
	}

}
