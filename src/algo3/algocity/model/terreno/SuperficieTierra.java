package algo3.algocity.model.terreno;

public class SuperficieTierra implements Superficie {

	@Override
	public boolean esTierra() {
		return true;
	}

	@Override
	public boolean esAgua() {
		return false;
	}

	public SuperficieTierra getSuperficie() {
		return this;
	}

}
