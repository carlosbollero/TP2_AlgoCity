package algo3.algocity.model;

public abstract class UnidadZonal extends Unidad implements Reparable {
	
	// TODO Revisar de que forma conviene que esten estos atributos,
	// si constantes o de clase
	static final int AREA = 1;
	static final int ESTADOINICIAL = 100;
	static int consumo;
	int porcentajeDanios;
	
	
	public abstract int getCosto();
	
	public UnidadZonal(){
		porcentajeDanios = 0;
	}
	
	public int getArea() {
		return AREA;
	}

	public int getConsumo() {
		return consumo;
	}

	public int getDanios() {
		return porcentajeDanios;
	}
	
	@Override
	public void repararse() {
		this.porcentajeDanios -= this.porcentajeReparacion();
		if (this.getDanios() < 0){
			this.porcentajeDanios = 0;
		}
	}
	
	//TODO esta comentado porque debemos saber antes si cada unidad se
	// sabe destruir a si misma o el "daño" lo recibe de manera externa
	// y como destruye un terremoto en un principio
	//public abstract void aplicarDanio();
	
	protected abstract int porcentajeReparacion();


}
