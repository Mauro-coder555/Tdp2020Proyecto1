
public class Arco {
	
	// Atributos
	
	private int origen;
	
	private int extremo;
	
	
	// Constructor
	
	public Arco(int origen, int extremo){
		
		this.origen = origen;
		this.extremo = extremo;
		
	}

	// Comandos y consultas

	public int getOrigen() {
		return origen;
	}


	public void setOrigen(int origen) {
		this.origen = origen;
	}


	public int getExtremo() {
		return extremo;
	}


	public void setExtremo(int extremo) {
		this.extremo = extremo;
	}
		
	
	
	

}