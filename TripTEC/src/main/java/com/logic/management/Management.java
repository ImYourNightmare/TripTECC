package com.logic.management;

import com.logic.objects.Client;
import com.logic.objects.Place;
import com.structures.graph.Edge;
import com.structures.graph.Graph;
import com.structures.graph.GraphManager;
import com.structures.graph.Vertex;

public class Management {
	GraphManager manager = new GraphManager();
	Graph graph = new Graph(manager.getVertices(),manager.getEdges());

	public Graph getGraph() {
		return graph;
	}
	public void setGraph(Graph graph) {
		this.graph = graph;
	}
	public void addplace(Place place,String id) {
		manager.newVertes(id, place);
		graph.setVertices(manager.getVertices());
	}
	public void addroad(String id,int OriginID,int destinationID,double distance) {
		manager.newEdge(id, OriginID, destinationID, distance);
		graph.setEdges(manager.getEdges());
	}
	public void removeplace(Vertex<Object> vertex) {
		manager.removeVertex(vertex);
		for(int i=0 ; i < manager.getEdges().size() ; i++) {
			if(manager.getEdges().get(i).getPuntoLlegada().equals(vertex) || manager.getEdges().get(i).getPuntoPartida().equals(vertex)) {
				manager.getEdges().remove(i);
			}
		}	
	}
	public void removeroad(Edge edge) {
		manager.removeEdge(edge);
	}
	public Vertex<Object> consultplace(String ID) {
		return manager.consultbyVertexID(ID);
	}
	public void createclientgraph(Client client) {
		Graph graph = new Graph();
		client.setGraph(graph);
	}
	public void addclientplace(String id,Place place,Client client) {
		Vertex<Object> vertex= new Vertex<Object>(id, place);
		client.getGraph().getVertices().add(vertex);

	}
	public void addclientroad(String id,Vertex<Object> OriginVertex,Vertex<Object> DestinyVertex,double distance, Client client) {
		Edge edge = new Edge(id, OriginVertex, DestinyVertex, distance);
		client.getGraph().getEdges().add(edge);
	}
	public void removeclientplace(Vertex<Object> vertex,Client client) {
		client.getGraph().getVertices().remove(vertex);
	}
}
