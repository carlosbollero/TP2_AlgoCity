package algo3.algocity.model;

public interface Visitante {
	
	public void visitar(UnidadResidencial unaUnidadResidencial);
	public void visitar(UnidadComercial unaUnidadComercial);
	public void visitar(UnidadIndustrial unaUnidadIndustrial);
	public void visitar(UnidadEnergetica unaUnidadEnergetica);
	public void visitar(LineaTension unaLineaTension);
	public void visitar(Ruta unaRuta);

}
