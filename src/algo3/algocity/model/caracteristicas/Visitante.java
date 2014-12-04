package algo3.algocity.model.caracteristicas;

import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;

public interface Visitante {

	public void visitar(UnidadResidencial unaUnidadResidencial);

	public void visitar(UnidadComercial unaUnidadComercial);

	public void visitar(UnidadIndustrial unaUnidadIndustrial);

	public void visitar(UnidadEnergetica unaUnidadEnergetica);

	public void visitar(LineaTension unaLineaTension);

	public void visitar(Ruta unaRuta);

	// public void visitar(Unidad unaUnidad); // usado por CatastrofeTerremoto
	public void visitar(Daniable unaUnidad);

}
