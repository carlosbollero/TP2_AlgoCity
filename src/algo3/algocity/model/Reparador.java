package algo3.algocity.model;

import java.util.ArrayList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.mapas.Mapa;

public class Reparador implements Visitante {

	private Mapa mapa;
	private ArrayList<Daniable> objetivos;
	
	
	public Reparador(Mapa mapa){
		this.mapa = mapa;
		this.objetivos = mapa.unidadesDaniables();
	}
	
	public void actuar() {
		for (Daniable v : this.objetivos) {
			v.aceptar(this);
		}
	}
	
	public void actualizarObjetivos(){
		this.objetivos = mapa.unidadesDaniables();
	}
	
	@Override
	public void visitar(UnidadResidencial unaUnidadResidencial) {
		unaUnidadResidencial.repararse();
	}

	@Override
	public void visitar(UnidadComercial unaUnidadComercial) {
		unaUnidadComercial.repararse();
	}

	@Override
	public void visitar(UnidadIndustrial unaUnidadIndustrial) {
		unaUnidadIndustrial.repararse();
	}

	@Override
	public void visitar(UnidadEnergetica unaUnidadEnergetica) {
		unaUnidadEnergetica.repararse();
	}

	@Override
	public void visitar(LineaTension unaLineaTension) {
		unaLineaTension.repararse();
	}

	@Override
	public void visitar(Ruta unaRuta) {
		unaRuta.repararse();
	}

	@Override
	public void visitar(Daniable unaUnidad) {
		unaUnidad.repararse();
	}
	
	
	
	
}
