package algo3.algocity.model;

public class Edificador {
	
	int costoUnidadResidencial;
	int costoUnidadIndustrial;
	int costoUnidadComercial;
	int costoCentralEolica;
	int costoCentralMinera;
	int costoCentralNuclear;
	int costoEstacionDebomberos;
	int costoPozoDeAgua;
	
	public Edificador(){
		this.costoUnidadResidencial = 5;
		this.costoUnidadIndustrial = 10;
		this.costoUnidadComercial = 5;
		this.costoCentralEolica = 1000;
		this.costoCentralMinera = 3000;
		this.costoCentralNuclear = 10000;
		this.costoEstacionDebomberos = 1500;
		this.costoPozoDeAgua = 250;
	}
	
	public UnidadComercial construirUnidadComercial(){
		return new UnidadComercial(this.costoUnidadComercial,2);
	}
	
	public UnidadOcupable construirUnidadIndustrial(){
		return new UnidadOcupable(this.costoUnidadIndustrial, 5, 25);
	}
	
	public UnidadOcupable construirUnidadResidencial(){
		return new UnidadOcupable(this.costoUnidadResidencial, 1, 100);
	}
	
	public PozoDeAgua construirPozoDeAgua(){
		return new PozoDeAgua(this.costoPozoDeAgua);
	}
	
	public EstacionDeBomberos construirEstacionDeBomberos(){
		return new EstacionDeBomberos(this.costoEstacionDebomberos);
	}
}
