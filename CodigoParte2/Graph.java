import java.util.ArrayList;
import java.util.logging.*;


public class Graph {

	//Atributos
	
	private ArrayList<Integer> listaDeNodos;
	private ArrayList<Arco> listaDeArcos;
	
	private static Logger logger;


	// Constructor
	public Graph(){	
		listaDeNodos = new ArrayList<Integer>();
		listaDeArcos = new ArrayList<Arco>();	
		
		if(logger == null){
			
			logger = Logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();
			
			hnd.setLevel(Level.FINE);
			
			logger.addHandler(hnd);
			
			logger.setLevel(Level.WARNING);
			
			Logger rootloger = logger.getParent();
			
			for(Handler h: rootloger.getHandlers()){
				h.setLevel(Level.OFF);
				
			}
		}
}



// Metodos y Consultas



	public void addNode(int node){
		boolean encontre; 
		
		
		encontre = perteneceNodo(node);
		
		
		if(!encontre){			
			
			listaDeNodos.add(node);
		}
		else{
			
			logger.fine("El nodo con rotulo "+node+" ya se encontraba en la estructura");
			
		}
		
	}
	
	public void addEdge(int node1,int node2){
		boolean encontre; int i;
		Arco actual;
		Arco nuevo;
		
		
		encontre = false;
		
		if(!perteneceNodo(node1) || !perteneceNodo(node2)){
			
			logger.warning("El nodo "+ node1 + " y/o el "+ node2 +" no pertenece/n a la estructura");
			
		}
		else{
		
		for(i = 0; i<listaDeArcos.size() && !encontre;i++){     // Checa si ya hay un arco con esos nodos
			actual = listaDeArcos.get(i);
			if(actual.getOrigen() == node1 && actual.getExtremo() == node2)
				encontre = true;			
		}
		
		if(!encontre){		
	
			nuevo = new Arco(node1,node2);
			
			listaDeArcos.add(nuevo);
			
		} else {
			
			logger.fine("Ya hay un arco entre "+ node1 +" y "+ node2);
		}		
		
	  }
	}
	
	public void removeNode(int node){
		ArrayList<Integer> indicesAEliminar;
	
		Arco actual; 
		boolean cortar; int i,j; 
		
		indicesAEliminar = new ArrayList<Integer>();
		
		cortar = false;
		
		i = 0;
		
		if(!perteneceNodo(node)){
			
			logger.warning("El nodo "+ node +" no pertenece a la estructura");
			
		} else{
		
		while(i < listaDeArcos.size()){   // Guarda el indice de cada arco que tenga el nodo a eliminar en algun extremo
			
			actual = listaDeArcos.get(i);	
			
			if(actual.getOrigen() == node || actual.getExtremo() == node){				
					indicesAEliminar.add(i);
					
			}
			
			i++;
		}	
	
		i = 0;
		j = 0; 
		
		while(i < indicesAEliminar.size()){ // Elimina de la lista de arcos todos los arcos que tengan el nodo a eliminar en algun extremo
			
			int indice = (int) indicesAEliminar.get(i);
			
			if(indice == 0)
				listaDeArcos.remove(indice);
			else listaDeArcos.remove(indice-j);		
			j++;i++;
				
			}
			
	
		
	
		
		for(i = 0; i<listaDeNodos.size() && !cortar;i++){ // Busca el indice del nodo a eliminar si es que este esta en la lista
			if(listaDeNodos.get(i) == node)
				cortar = true;			
		}
		
		 listaDeNodos.remove(i-1);	
	
		}	
}
	public void removeEdge(int node1,int node2){
		Arco actual;  boolean terminar;
		
		terminar = false;
		
		if(perteneceNodo(node1) && perteneceNodo(node2)) {
		
		for(int i = 0; i<listaDeArcos.size() && !terminar;i++){			
			actual = listaDeArcos.get(i);			
				
			if(actual.getOrigen()==node1 && actual.getExtremo()==node2){				
				listaDeArcos.remove(i);				
				terminar = true;				
			}
			
		}	
		
		if(!terminar) logger.warning("El arco entre "+ node1 + " y "+ node2 +" no pertenece a la estructura");
		
		}
		else {
			logger.warning("Almenos uno de los nodos ingresados no pertenece a la estructura");
		}
		
	}
	
	private boolean perteneceNodo(int node){
		boolean encontre; int i;
		
		
		encontre = false;
		
		for(i = 0; i<listaDeNodos.size() && !encontre;i++){
			if(listaDeNodos.get(i) == node)
				encontre = true;			
		}
		
		return encontre;
	}
	
	
		
		
	
	
}	