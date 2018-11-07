package com.logic.structures;

public class VertexNode<X> {
	private X element;
	private boolean visited;
	private LinkedList<GraphNode<X>> aristas;
	
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
	public LinkedList<GraphNode<X>> getEdges() {
		return aristas;
	}
	public void setEdges(LinkedList<GraphNode<X>> vertices) {
		this.aristas = vertices;
	}
	public VertexNode() {
		this.element = null;
		this.visited = false;
		this.aristas = new LinkedList<GraphNode<X>>();
	}
	public VertexNode(X element) {
		this.element = element;
		this.visited = false;
		this.aristas = new LinkedList<GraphNode<X>>();
	}
	public String toString() {
		return "["+this.element+"]";
	}
}
