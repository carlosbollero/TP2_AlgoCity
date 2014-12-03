package algo3.algocity.model.terreno;

public class SuperficieAgua implements Superficie {

	@Override
	public boolean esTierra() {
		return false;
	}

	@Override
	public boolean esAgua() {
		return true;
	}

	public SuperficieAgua getSuperficie() {
		return this;
	}

}
