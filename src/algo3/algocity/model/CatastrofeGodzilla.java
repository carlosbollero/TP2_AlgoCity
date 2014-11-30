package algo3.algocity.model;

import java.util.ArrayList;

public class CatastrofeGodzilla implements Visitante {
	
	public void actuar(ArrayList<Visitable> objetivos){
		for (Visitable u : objetivos){
			u.aceptar(this);
		}
	}

	@Override
	public void visitar(UnidadResidencial unaUnidadResidencial) {
		unaUnidadResidencial.aplicarDanioGodzilla();
		
	}

	@Override
	public void visitar(UnidadComercial unaUnidadComercial) {
		unaUnidadComercial.aplicarDanioGodzilla();
	}

	@Override
	public void visitar(UnidadIndustrial unaUnidadIndustrial) {
		unaUnidadIndustrial.aplicarDanioGodzilla();
		
	}

	@Override
	public void visitar(UnidadEnergetica unaUnidadEnergetica) {
		unaUnidadEnergetica.aplicarDanioGodzilla();
		
	}

	@Override
	public void visitar(LineaTension unaLineaTension) {
		unaLineaTension.aplicarDanioGodzilla();
		
	}

	@Override
	public void visitar(Ruta unaRuta) {
		unaRuta.aplicarDanioGodzilla();
		
	}

	@Override
	public void visitar(Unidad unaUnidad) {
		// TODO Auto-generated method stub
		
	}





}
