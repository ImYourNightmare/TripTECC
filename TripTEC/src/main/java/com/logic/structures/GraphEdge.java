package com.logic.structures;

public class GraphEdge<X> {
	private VertexNode<X> vertex;
	private int weight;
	
	public VertexNode<X> getVertex() {
		return vertex;
	}
	public void setVertex(VertexNode<X> element) {
		this.vertex = element;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public GraphEdge(){
		this.vertex = null;
		this.weight = 0;
	}
	public GraphEdge(VertexNode<X> vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	public String toString() {
		return "["+this.vertex+"]";
	}
}
