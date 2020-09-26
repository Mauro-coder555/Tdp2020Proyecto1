
public class Principal {
	
	public static void main(String[]args){
		
		Graph miGrafo = new Graph();
		
		
		miGrafo.addNode(1);
		miGrafo.addNode(1); // Ingreso nodo repetido
		miGrafo.addNode(3);
		
		
		miGrafo.addEdge(1,2);   // Pido agregar un arco con un nodo que no pertenece a la estructura
		
		miGrafo.removeEdge(1,45); // Pido remover un arco entre dos nodos, uno de esos nodos no pertenece a la estructura
		miGrafo.removeEdge(1,3);  // Pido remover un arco entre dos nodos pertenecientes a la estructura, pero dicho arco no existe
	
	
		
	    miGrafo.removeNode(22); // Pido remover un nodo que no pertenece a la estructura
		
		
		
		
	}
	
}
