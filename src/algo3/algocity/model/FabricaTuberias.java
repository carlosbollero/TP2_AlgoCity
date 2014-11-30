package algo3.algocity.model;


public class FabricaTuberias implements FabricaConectores{

	public Conector construir() {
		return new Tuberia();
	}

}