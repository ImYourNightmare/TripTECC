package com.logic.structures;
//clase para crear vertices genéricos usados por el grafo
public class VertexNode<X> {
	//atributos de la clase
	private X element;
	private boolean visited;
	private LinkedList<GraphEdge<X>> edges;
	//getters & setters
	public X getElement() {
		return element;
	}
	public void setElement(X element) {
		this.element = element;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public LinkedList<GraphEdge<X>> getEdges() {
		return edges;
	}
	public void setEdges(LinkedList<GraphEdge<X>> vertices) {
		this.edges = vertices;
	}
	//Constructor para crear un vertice con elemento nulo
	public VertexNode() {
		this.element = null;
		this.visited = false;
		this.edges = new LinkedList<GraphEdge<X>>();
	}
	//constructor para crear un vertice que contenga un elemento
	public VertexNode(X element) {
		this.element = element;
		this.visited = false;
		this.edges = new LinkedList<GraphEdge<X>>();
	}
	//Metodo para indicar como se debe imprimir el vertice
	public String toString() {
		return this.element.toString();
	}
}
