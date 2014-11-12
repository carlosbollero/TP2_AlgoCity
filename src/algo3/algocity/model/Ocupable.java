package algo3.algocity.model;

public interface Ocupable {
	
	void agregar(int cantidad);
	
	void despedir(int cantidad);
	
	boolean hayDisponibilidad();

}
