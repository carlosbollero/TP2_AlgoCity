package algo3.algocity.model.construcciones;

import java.awt.Point;

import algo3.algocity.model.caracteristicas.Reparable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class UnidadComercial extends Unidad implements Reparable, Visitable {

	int consumo;
	final double ESTADOINICIAL = 100;
	double porcentajeDanios;

	public UnidadComercial(){
		this.costo = 5;
		this.consumo = 2;
	}
	
	public UnidadComercial(int x, int y) {
		coordenadas = new Point(x, y);
		this.costo = 5;
		this.consumo = 2;
	}

	public UnidadComercial(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {
		this.costo = 5;
		this.consumo = 2;
		coordenadas = new Point(x, y);
		if (!(esConstruibleEn(mapa.getSuperficie(coordenadas)) && hayConexionesEn(mapa))){
			throw new NoSeCumplenLosRequisitosException();
		}
	}


	public int consumo() {
		return this.consumo;
	}

	@Override
	public void repararse() {
		// TODO Auto-generated method stub

	}

	@Override
	public void aplicarDanio(double cantidad) {
		if (this.porcentajeDanios > 100) {
			this.porcentajeDanios = 100;
		} else {
			this.porcentajeDanios += cantidad;
		}
	}

	@Override
	public double getSalud() {
		return (this.ESTADOINICIAL - this.porcentajeDanios);
	}

	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this);

	}

	public void aplicarDanioGodzilla() {
		porcentajeDanios = 75;

	}

	private boolean hayConexionesEn(Mapa mapa){
		return (mapa.hayConexionCompleta(coordenadas));
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {

		return superficie.esTierra();
	}

}