package algo3.algocity.view.panelDer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;
import java.util.Observer;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import algo3.algocity.controller.ControladorMensajes;
import algo3.algocity.model.Juego;
import algo3.algocity.model.catastrofes.CatastrofeTerremoto;
import algo3.algocity.model.catastrofes.GeneradorCatastrofe;

public class VistaCatastrofe implements Observer {


	GeneradorCatastrofe genCatastrofe;
	VistaPanelDer contenedor;
	ControladorMensajes controladorMsj;

	public VistaCatastrofe(Juego juego, VistaPanelDer contenedor) {
		genCatastrofe = juego.genCatastrofe();
		setControladorMsj(contenedor.getControladorMensajes());
		genCatastrofe.addObserver(this);
		this.contenedor = contenedor;
		
		
	}

	private void ruido() {
		try {
			AudioStream audioStream;
			InputStream in = new FileInputStream(
					new File("sound/terremoto.wav"));
			audioStream = new AudioStream(in);
			AudioPlayer.player.start(audioStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ruido();
	}
	
	public void setControladorMsj(ControladorMensajes controladorMsj) {
		this.controladorMsj = controladorMsj;
	}
}
