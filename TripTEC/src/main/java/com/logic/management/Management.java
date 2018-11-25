package com.logic.management;

import com.logic.objects.Client;
import com.logic.objects.Place;
import com.structures.graph.Edge;
import com.structures.graph.Graph;
import com.structures.graph.GraphManager;
import com.structures.graph.Vertex;
//clase para la creación de grafo general y los subgrafos de los clientes
public class Management {
	//atributos
	GraphManager manager = new GraphManager();
	Graph graph = new Graph(manager.getVertices(),manager.getEdges());
	//getters & setters
	public Graph getGraph() {
		return graph;
	}
	public void setGraph(Graph graph) {
		this.graph = graph;
	}
	/**metodo para añadir un lugar al grafo general
	 * @param place lugar que se añadirá
	 * @param id id del vertice
	 */
	public void addplace(Place place,String id) {
		manager.newVertes(id, place);
		graph.setVertices(manager.getVertices());
	}
	/** metodo para añadir aristas
	 * @param id id de la arista
	 * @param OriginID lugar de origen
	 * @param destinationID lugar destino
	 * @param distance distancia entre el lugar de origen y el de destino
	 */
	public void addroad(String id,int OriginID,int destinationID,double distance) {
		manager.newEdge(id, OriginID, destinationID, distance);
		graph.setEdges(manager.getEdges());
	}
	/**metodo para remover un lugar de un grafo
	 * @param vertex vertice del lugar que se quiere remover
	 */
	public void removeplace(Vertex<Object> vertex) {
		manager.removeVertex(vertex);
		for(int i=0 ; i < manager.getEdges().size() ; i++) {
			if(manager.getEdges().get(i).getPuntoLlegada().equals(vertex) || manager.getEdges().get(i).getPuntoPartida().equals(vertex)) {
				manager.getEdges().remove(i);
			}
		}	
	}
	/**metodo para remover una arista
	 * 
	 * @param edge arista que será removida
	 */
	public void removeroad(Edge edge) {
		manager.removeEdge(edge);
	}
	/**metodo para consultar un lugar
	 * 
	 * @param ID id del vertice del lugar que se quiere consultar 
	 * @return información del lugar 
	 */
	public Vertex<Object> consultplace(String ID) {
		return manager.consultbyVertexID(ID);
	}
	/**metodo para inicializar el grafo del cliente
	 * 
	 * @param client cliente al cual se le iniciará el grafo
	 */
	public void createclientgraph(Client client) {
		Graph graph = new Graph();
		client.setGraph(graph);
	}
	/**metodo para añadir un lugar al grafo de un cliente
	 * 
	 * @param id id del vertice del lugar
	 * @param place lugar que se añadirá
	 * @param client cliente al cual se le añadirá un lugar a su grafo
	 */
	public void addclientplace(String id,Place place,Client client) {
		Vertex<Object> vertex= new Vertex<Object>(id, place);
		client.getGraph().getVertices().add(vertex);

	}
	/**metodo para añadir una arista al grafo del cliente
	 * 
	 * @param id id de la arista
	 * @param OriginVertex vertice que contiene el lugar de origen
	 * @param DestinyVertex vertice que contiene el lugar de destino
	 * @param distance distancia del lugar de origen a destino
	 * @param client cliente al cual se le añadirá un camino a su grafo
	 */
	public void addclientroad(String id,Vertex<Object> OriginVertex,Vertex<Object> DestinyVertex,double distance, Client client) {
		Edge edge = new Edge(id, OriginVertex, DestinyVertex, distance);
		client.getGraph().getEdges().add(edge);
	}
	/**Metodo para remover el lugar que un cliente pensaba visitar
	 * 
	 * @param vertex vertice que contiene el lugar a remover
	 * @param client cliente al cual se le eliminará un lugar de su grafo
	 */
	public void removeclientplace(Vertex<Object> vertex,Client client) {
		client.getGraph().getVertices().remove(vertex);
	}
}
