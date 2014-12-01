package algo3.algocity.model.caracteristicas;

public interface Ocupable {
	
	public abstract int getCapacidad();
	
	public abstract int getOcupacion();
	
	public abstract int consultarDisponibilidad();
	
	public abstract boolean hayDisponibilidad();
	
	public abstract void agregar(int cantidad);
	
	public abstract void quitar(int cantidad);

}
