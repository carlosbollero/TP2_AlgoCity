package algo3.algocity.model;

import java.util.ArrayList;

import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;

public class EstacionDeBomberos extends Unidad implements Visitante {

	private Conector conexion;

	public EstacionDeBomberos(ArrayList<Mapa> mapas, int x, int y) throws NoSeCumplenLosRequisitosException {
		
		requisitos = new RequisitoTierra();
		
		if (requisitos.evaluar(mapas, x, y)){
			costo = 1500;
			consumo = 0;
		}else{
			throw new NoSeCumplenLosRequisitosException();
		}
		
		conexion = null;
	}

	public void actuar(ArrayList<Visitable> objetivos){
		for (Visitable v : objetivos){
			v.aceptar(this);
		}
	}
	
	// TODO Revisar si sirve el metodo
	public void conectarTuberia(Conector unaTuberia) {
		conexion = unaTuberia;
	}

	public Conector getConexion() {
		return conexion;
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

}