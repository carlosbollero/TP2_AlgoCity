package algo3.algocity.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import algo3.algocity.model.Juego;

public class VistaPanelInfo extends JPanel {

	private static final long serialVersionUID = -7918349684154728725L;

	JTextPane texto;
	Juego juego;

	public VistaPanelInfo(Juego juego) {
		this.juego = juego;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(200, 250));
		setBorder(BorderFactory.createTitledBorder("Info"));
		
		texto = new JTextPane();
		texto.setBackground(null);
		texto.setEditable(false);
		
		add(texto, BorderLayout.WEST);
		agregarTexto("Poblacion  " + juego.poblacion().getCantidad());
	}

	public void agregarTexto(String texto) {
		this.texto.setText(texto);
	}

}
