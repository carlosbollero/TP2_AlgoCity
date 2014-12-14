package algo3.algocity.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VistaPanelSup extends JPanel {

	private static final long serialVersionUID = -3892726120581801752L;
	
	JButton b_guardar;

	public VistaPanelSup(){
		setLayout(new FlowLayout());
		b_guardar = new JButton("Guardar");
		add(b_guardar, FlowLayout.LEFT);
		definirCaracteristicasBotonGuardar();
	}

	private void definirCaracteristicasBotonGuardar() {
		b_guardar.setBorderPainted(false);
		b_guardar.setContentAreaFilled(false);
	}
}
