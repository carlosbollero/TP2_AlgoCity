package algo3.algocity.model;

public class Edificador {

	// TODO HORRIBLEEE!!!!

	int costoUnidadResidencial;
	int costoUnidadIndustrial;
	int costoUnidadComercial;
	int costoCentralEolica;
	int costoCentralMinera;
	int costoCentralNuclear;
	int costoEstacionDebomberos;
	int costoPozoDeAgua;

	int consumoUnidadResidencial;
	int consumoUnidadIndustrial;
	int consumoUnidadComercial;

	int capacidadUnidadResidencial;
	int capacidadUnidadIndustrial;

	int capacidadElectricaCentralEolica;
	int capacidadElectricaCentralMinera;
	int capacidadElectricaCentralNuclear;

	int radioInfluenciaCentralEolica;
	int radioInfluenciaCentralMinera;
	int radioInfluenciaCentralNuclear;

	// Los requisitos de conexiones y de terreno de cada unidad deberian estar
	// aca tambien

	public Edificador() {
		this.costoUnidadResidencial = 5;
		this.costoUnidadIndustrial = 10;
		this.costoUnidadComercial = 5;
		this.costoCentralEolica = 1000;
		this.costoCentralMinera = 3000;
		this.costoCentralNuclear = 10000;
		this.costoEstacionDebomberos = 1500;
		this.costoPozoDeAgua = 250;

		this.consumoUnidadResidencial = 1;
		this.consumoUnidadComercial = 2;
		this.consumoUnidadIndustrial = 5;

		this.capacidadUnidadResidencial = 100;
		this.capacidadUnidadIndustrial = 25;

		this.capacidadElectricaCentralEolica = 100;
		this.capacidadElectricaCentralMinera = 400;
		this.capacidadElectricaCentralNuclear = 1000;

		this.radioInfluenciaCentralEolica = 4;
		this.radioInfluenciaCentralMinera = 10;
		this.radioInfluenciaCentralNuclear = 25;
	}

	public UnidadComercial construirUnidadComercial() {
		return new UnidadComercial();
	}

	public UnidadOcupable construirUnidadIndustrial() {
		return new UnidadOcupable(this.costoUnidadIndustrial,
				this.consumoUnidadIndustrial, this.capacidadUnidadIndustrial);
	}

	public UnidadOcupable construirUnidadResidencial() {
		return new UnidadOcupable(this.costoUnidadResidencial,
				this.consumoUnidadResidencial, this.capacidadUnidadResidencial);
	}

	public PozoDeAgua construirPozoDeAgua() {
		return new PozoDeAgua();
	}

	public EstacionDeBomberos construirEstacionDeBomberos() {
		return new EstacionDeBomberos();
	}

	public UnidadEnergetica construirCentralEolica() {
		return new UnidadEnergetica(this.costoCentralEolica,
				this.capacidadElectricaCentralEolica,
				this.radioInfluenciaCentralEolica);
	}

	public UnidadEnergetica construirCentralMinera() {
		return new UnidadEnergetica(this.costoCentralMinera,
				this.capacidadElectricaCentralMinera,
				this.radioInfluenciaCentralMinera);
	}

	public UnidadEnergetica construirCentralNuclear() {
		return new UnidadEnergetica(this.costoCentralNuclear,
				this.capacidadElectricaCentralNuclear,
				this.radioInfluenciaCentralNuclear);
	}

}
