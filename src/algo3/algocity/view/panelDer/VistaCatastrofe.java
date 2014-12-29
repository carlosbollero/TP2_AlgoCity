package algo3.algocity.view.panelDer;

import java.util.Observable;
import java.util.Observer;

import algo3.algocity.model.Juego;
import algo3.algocity.model.catastrofes.CatastrofeTerremoto;
import algo3.algocity.model.catastrofes.GeneradorCatastrofe;

public class VistaCatastrofe implements Observer {

	GeneradorCatastrofe genCatastrofe;
	VistaPanelDer contenedor;

	public VistaCatastrofe(Juego juego, VistaPanelDer contenedor) {
		genCatastrofe = juego.genCatastrofe();
		genCatastrofe.addObserver(this);
		this.contenedor = contenedor;
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		String mensaje = (arg1.getClass().equals(CatastrofeTerremoto.class)) ? "terremoto!!!!"
				: "godzilla!!!!";
//		contenedor.getVentana().getControladorMensajes()
//				.recibirYNotificar(mensaje);
	}
}
