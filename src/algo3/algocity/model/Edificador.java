package algo3.algocity.model;

public class Edificador {
	
	public UnidadResidencial construirUnidadResidencial(){
		return new UnidadResidencial();
	}
	
	public UnidadComercial construirUnidadComercial(){
		return new UnidadComercial();
	}
	
	public UnidadIndustrial construirUnidadIndustrial(){
		return new UnidadIndustrial();
	}
	
	public CentralEolica construirCentralEolica(){
		return new CentralEolica();
	}
	
	public CentralMinera construirCentralMinera(){
		return new CentralMinera();
	}
	
	public CentralNuclear construirCentralNuclear(){
		return new CentralNuclear();
	}

	public Tuberia construirTuberia(){
		return new Tuberia();
	}
	
	public Ruta construirRuta(){
		return new Ruta();
	}
	
	public LineaDeTension construirLineaDeTension(){
		return new LineaDeTension();
	}
	
	public PozoDeAgua construirPozoDeAgua(){
		return new PozoDeAgua();
	}
	
	public EstacionDeBomberos construirEstacionDeBomberos(){
		return new EstacionDeBomberos();
	}
}
