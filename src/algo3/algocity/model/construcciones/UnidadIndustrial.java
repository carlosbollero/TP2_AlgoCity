package algo3.algocity.model.construcciones;

import java.awt.Point;

import algo3.algocity.model.caracteristicas.Ocupable;
import algo3.algocity.model.caracteristicas.Reparable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class UnidadIndustrial extends Unidad implements Ocupable, Reparable, Visitable{
	
	final double ESTADOINICIAL = 100;
	int capacidad; // capacidad habitacional
	int ocupacion;
	double porcentajeDanios;

	public UnidadIndustrial(){
		this.costo = 10;
		this.consumo = 5;
		this.capacidad = 25;
	}
	
	public UnidadIndustrial(int x, int y) {
		coordenadas = new Point(x, y);
		this.costo = 10;
		this.consumo = 5;
		this.capacidad = 25;
	}
	
	public UnidadIndustrial(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {
		
		coordenadas = new Point(x, y);
		this.costo = 10;
		this.consumo = 5;
		this.capacidad = 25;
		coordenadas = new Point (x, y);
		if (!(esConstruibleEn(mapa.getSuperficie(coordenadas)) && hayConexionesEn(mapa))){
//		if (!mapa.sePuedeConstruir(this)){
			throw new NoSeCumplenLosRequisitosException();
		}
	}



	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this); 
		
	}

	public void aplicarDanioGodzilla() {
		porcentajeDanios = 40;
		
	}

	public int getCapacidad() {
		return this.capacidad;
	}

	public int getOcupacion() {
		return this.ocupacion;
	}

	public int consultarDisponibilidad() {
		return (this.capacidad - this.ocupacion);
	}

	public boolean hayDisponibilidad() {
		return ((this.capacidad - this.ocupacion) > 0);
	}
	
	public void agregar(int cantidad){
		agregarEmpleados(cantidad);
	}

	public void agregarEmpleados(int cantidad) {
		if (this.hayDisponibilidad(cantidad)) {
			this.ocupacion += cantidad;
		}
	}
	
	public void quitar(int cantidad){
		quitarEmpleados(cantidad);
	}

	public void quitarEmpleados(int cantidad) {
		this.ocupacion -= cantidad;
		if (this.ocupacion < 0) {
			this.ocupacion = 0;
		}
	}

	public double getDanios() {
		return porcentajeDanios;
	}

	public double getSalud() {
		return (this.ESTADOINICIAL - this.porcentajeDanios);
	}

	@Override
	public void repararse() {
		this.porcentajeDanios -= this.porcentajeReparacion();
		if (this.getDanios() < 0) {
			this.porcentajeDanios = 0;
		}
	}

	public void aplicarDanio(double cantidad) {
		if (this.porcentajeDanios > 100) {
			this.porcentajeDanios = 100;
		} else {
			this.porcentajeDanios += cantidad;
		}
	}

	protected double porcentajeReparacion() {
		return (this.ESTADOINICIAL * 10) / 100;
	}

	public boolean estaOcupada() {
		return (this.consultarDisponibilidad() == 0);
	}

	public boolean hayDisponibilidad(int cantidad) {
		return (this.consultarDisponibilidad() >= cantidad);
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean hayConexionesEn(Mapa mapa) {
		return mapa.hayConexionParcial(coordenadas);
	}

}
