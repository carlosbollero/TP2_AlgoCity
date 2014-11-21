package algo3.algocity.model;

<<<<<<< HEAD
import java.util.ArrayList;

public class Juego {
	
	final int anchoMapaJuego = 100;
	final int altoMapaJuego = 100;
	private Mapa mapaDeUnidadesOcupables;
	private Mapa mapaDeTerreno;
	//..Todos los mapas que generemos
	private Edificador edificador;
	
	
	
	public Juego(){
		this.mapaDeUnidadesOcupables = this.generarMapa();
		this.edificador = this.generarEdificador();
	}
	
	
	private Mapa generarMapa(){
		return (new Mapa(altoMapaJuego,anchoMapaJuego));
	}
	

	private Edificador generarEdificador(){
		return new Edificador();
	}
	
	
	//TODO
	public ArrayList<Ubicable> getContenidoEnPosicion(int coordenadaX, int coordenadaY){
		//para cada mapa del juego --> getContenido(coordenadaX,coordenadaY)
		//agregarlo los ubicables q haya en esa posicion al array a devolver
		//..devolver, despues la interfaz grafica vera que hace con eso
		return new ArrayList<Ubicable>();
	}

	
	//TODO
	public void agregarPozoDeAguaEn(int coordenadaX, int coordenadaY) {
		//No quise tocar mapa porque falta que carlos suba lo q modifico
		if(this.mapaDeTerreno.esAgua(coordenadaX,coordenadaY)){
			Ubicable pozoDeAgua = edificador.construirPozoDeAgua();
			mapaDeUnidadesOcupables.agregar(pozoDeAgua,coordenadaX,coordenadaY);
		}
		
	}
	
	
	
	
	
	
	
	
=======
public class Juego {

	Usuario usuario;
	
	MapaEdilicio mapaEdilicio;
	MapaConexiones mapaTuberias;
	MapaConexiones mapaRutas;
	MapaConexiones mapaLineasDeTension;
>>>>>>> 3f4e54114ceaf5ad055c2d51f22099618fed01ff
	
	
}
