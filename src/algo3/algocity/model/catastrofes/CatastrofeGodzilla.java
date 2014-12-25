package algo3.algocity.model.catastrofes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.conexiones.LineaTension;
import algo3.algocity.model.conexiones.Ruta;
import algo3.algocity.model.construcciones.UnidadComercial;
import algo3.algocity.model.construcciones.UnidadEnergetica;
import algo3.algocity.model.construcciones.UnidadIndustrial;
import algo3.algocity.model.construcciones.UnidadResidencial;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class CatastrofeGodzilla implements Catastrofe, Visitante {

	private int tamanio;
	private Random aleatorio;
	private LinkedList<Coordenada> caminoGodzilla;

	// TODO mover algunas cosas a una clase abstracta.

	public CatastrofeGodzilla() {

		this.caminoGodzilla = new LinkedList<Coordenada>();

	}

	public CatastrofeGodzilla(Mapa mapa) {
		tamanio = mapa.tamanio();
		this.caminoGodzilla = new LinkedList<Coordenada>();

	}

	@Override
	public void iniciar() {
		comenzar();
	}

	// Comienzo aleatorio de Godzilla , que puede ser tanto el linea recta como
	// en zigzag
	public void comenzar() {

		this.aleatorio = new Random();
		Coordenada puntoInicio;
		Coordenada puntoFinal;
		if (this.girarMoneda() == 0) {
			puntoInicio = new Coordenada(aleatorio.nextInt(tamanio + 1), 0);
			puntoFinal = new Coordenada(aleatorio.nextInt(tamanio + 1), tamanio);
		} else {
			puntoInicio = new Coordenada(0, aleatorio.nextInt(tamanio + 1));
			puntoFinal = new Coordenada(tamanio, aleatorio.nextInt(tamanio + 1));
		}
		if (girarMoneda() == 0 || girarMoneda() == 1) {
			caminarEnLineaRecta(puntoInicio, puntoFinal);
		} else {
			caminarEnZigZag(puntoInicio, puntoFinal);
		}
	}

	// 50/50 chances, esta para dejar el codigo mas limpio en comenzar.
	public int girarMoneda() {
		return aleatorio.nextInt(2);
	}

	public void caminarEnLineaRecta(Coordenada puntoInicio, Coordenada puntoFinal) {
		CaminarEnLineaRecta caminarEnLineaRecta = new CaminarEnLineaRecta();
		caminoGodzilla = caminarEnLineaRecta.devolverCamino(puntoInicio,
				puntoFinal);
	}

	public void caminarEnZigZag(Coordenada puntoInicio, Coordenada puntoFinal) {
		CaminarEnZigZag caminarEnZigZag = new CaminarEnZigZag(tamanio, tamanio);
		caminoGodzilla = caminarEnZigZag.devolverCamino(puntoInicio,
				puntoFinal);
	}

	public void actuar(ArrayList<Daniable> objetivos) {
		for (Daniable u : objetivos) {
			u.aceptar(this);
		}
	}

	public LinkedList<Coordenada> genCaminoRecto() {
		comenzar();
		return caminoGodzilla;
	}

	// Metodo para tests.
	public LinkedList<Coordenada> generarCaminoRectoParaTests() {

		Coordenada puntoInicio;
		Coordenada puntoFinal;
		puntoInicio = new Coordenada(0, 0);
		puntoFinal = new Coordenada(tamanio, 0);
		caminarEnLineaRecta(puntoInicio, puntoFinal);
		return caminoGodzilla;
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

}
