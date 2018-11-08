package com.logic.structures;
//Clase que permite crear aristas
public class GraphEdge<X> {
	//atributos de la clase
	private VertexNode<X> vertex;
	private int weight;
	//getters & setters
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
	//constructor de la clase
	public GraphEdge(VertexNode<X> vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	public String toString() {
		return "["+this.vertex+","+this.weight+"]";
	}
}
