package com.logic.structures;

public class GraphNode<X> {
	private X element;
	private int weight;
	
	public X getElement() {
		return element;
	}
	public void setElement(X element) {
		this.element = element;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public GraphNode(){
		this.element = null;
		this.weight = 0;
	}
	public GraphNode(X element, int weight) {
		this.element = element;
		this.weight = weight;
	}
	public String toString() {
		return "["+this.element+","+this.weight+"]";
	}
}
