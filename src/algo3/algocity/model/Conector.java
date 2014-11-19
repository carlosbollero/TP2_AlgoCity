package algo3.algocity.model;

public class Conector implements Ubicable, Reparable {
	
	int costo;
	int porcentajeDanios;
    final int ESTADOINICIAL = 100; 
	
	
	public Conector(int costo){
		this.costo = costo;
		this.porcentajeDanios = 0;
	}

   public int devolverCosto () {
	   
	   return (this.costo); 
	   
   }
   
  public boolean tieneCosto (){
	  
	  return(this.costo != 0); 
  }

  public boolean tieneDanios (){
	  
	  return (this.porcentajeDanios!= 0); 
	  
  }
  
  //interface//
  @Override 
  public void repararse (){
	  
	//  TODO
  }
 
  
  @Override
   public void aplicarDanio (int cantidad ){
	   if (this.porcentajeDanios >100){
		   this.porcentajeDanios =100;	
	   }else{
		   
		  this.porcentajeDanios = cantidad; 
	   }
	   
	   
   }
   
  @Override
   public int getSalud (){
	   
	 return (this.ESTADOINICIAL - this.porcentajeDanios);   
	   
   }

}
