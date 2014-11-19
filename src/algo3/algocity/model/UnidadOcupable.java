package algo3.algocity.model;

public class UnidadOcupable extends Unidad implements Reparable {
	
	final int ESTADOINICIAL = 100;
	final int FAMILIA = 4;
	int capacidad; //capacidad de habitantes	
	int ocupacion;
	int consumo;
	int porcentajeDanios;	
	
	
	public UnidadOcupable(int costo, int consumo, int capacidad){
		this.costo = costo;
		this.consumo = consumo;
		this.capacidad = capacidad;		
		this.porcentajeDanios = 0;
		this.ocupacion = 0;
	}
	

	public int getCapacidad() {
		return this.capacidad;
	}
	

	public int getConsumo() {
		return consumo;
	}
	

	public int getOcupacion() {
		return this.ocupacion;
	}
	
	
	public int getDanios() {
		return porcentajeDanios;
	}	
	

	public boolean estaOcupada() {
		return (this.consultarDisponibilidad() == 0);
	}
	

	public int consultarDisponibilidad() {
		return (this.capacidad - this.ocupacion);
	}	
	
	
	public boolean hayDisponibilidad() {
		return (this.consultarDisponibilidad() >= this.FAMILIA);
	}
	
	
	public int getSalud() {
		return (this.ESTADOINICIAL - this.porcentajeDanios);
	}
	
	
	@Override
	public void repararse() {
		this.porcentajeDanios -= this.porcentajeReparacion();
		if (this.getDanios() < 0){
			this.porcentajeDanios = 0;
		}
	}
	
	//TODO VER si debemos saber antes si cada unidad se
	// sabe destruir a si misma o el "danio" lo recibe de manera externa
	// y como destruye un terremoto en un principio
	public void aplicarDanio(int cantidad){
		if (this.porcentajeDanios > 100){
			this.porcentajeDanios = 100;
		}else{
		this.porcentajeDanios += cantidad;
		}
	}


	
	//**ESTOS DOS METODOS PUESTOS COMO PRIVATE EN VEZ DE PROTECTED**
	//Porque si no fueran private se podria agregar habitantes arbitrariamente
	//TODO
	private void recibirHabitantes(int cantidad) {
		this.ocupacion += cantidad;	
	}
	
	//
	private void despedirHabitantes(int cantidad) {
		this.ocupacion -= cantidad;
		if(this.ocupacion < 0) {
			this.ocupacion = 0;
		}
	}	
	
	
	public void agregarFamilias(int cantidadFamiliasAAgregar) {
		
		if (this.hayDisponibilidad()){
			recibirHabitantes(cantidadFamiliasAAgregar * this.FAMILIA);
		}		
	}
	
	public void quitarFamilias(int cantidadFamiliasAQuitar) {
		
		despedirHabitantes(cantidadFamiliasAQuitar * this.FAMILIA);		
	}
	
	
	//TODO
	//No deberia ser public??
	protected int porcentajeReparacion() {
		return (this.ESTADOINICIAL * 10) / 100;
	}
	

}

