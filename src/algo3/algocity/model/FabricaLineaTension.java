package algo3.algocity.model;


public class FabricaLineaTension implements FabricaConectores {

	public Conector construir() {
		return new LineaTension();
	}

}