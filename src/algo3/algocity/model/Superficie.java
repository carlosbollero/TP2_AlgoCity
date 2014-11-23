package algo3.algocity.model;

public class Superficie implements Ubicable {

	final boolean tierra = true;
	final boolean agua = false;
	boolean tipo;

	public Superficie(boolean tipoSuperficie) {
		this.tipo = tipoSuperficie;
	}

	public boolean tipo() {
		return this.tipo;
	}

	public boolean esTierra() {
		return (this.tipo == tierra);
	}

	public boolean esAgua() {
		return (this.tipo == agua);
	}

}
