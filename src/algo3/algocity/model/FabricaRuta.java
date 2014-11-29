package algo3.algocity.model;

public class FabricaRuta implements FabricaConectores {

	public Conector construir() {
		return new Ruta();
	}

}