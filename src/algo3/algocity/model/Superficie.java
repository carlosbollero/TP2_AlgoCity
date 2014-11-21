package algo3.algocity.model;

public class Superficie implements Ubicable {

	// TODO revisar esto
	// true == tierra;
	// false == agua;
	boolean tipo;

	public Superficie(boolean tipoSuperficie) {
		this.tipo = tipoSuperficie;
	}

	public boolean tipo() {
		return this.tipo;
	}

	public boolean esTierra() {
		return (this.tipo == true);
	}

	public boolean esAgua() {
		return (this.tipo == false);
	}

}
