package com.logic.structures;

public class VertexNode<X> {
	private X element;
	private boolean visited;
	private LinkedList<GraphEdge<X>> aristas;
	
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
		return aristas;
	}
	public void setEdges(LinkedList<GraphEdge<X>> vertices) {
		this.aristas = vertices;
	}
	public VertexNode() {
		this.element = null;
		this.visited = false;
		this.aristas = new LinkedList<GraphEdge<X>>();
	}
	public VertexNode(X element) {
		this.element = element;
		this.visited = false;
		this.aristas = new LinkedList<GraphEdge<X>>();
	}
	public String toString() {
		return this.element.toString();
	}
}
