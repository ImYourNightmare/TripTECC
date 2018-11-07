package com.logic.structures;

import com.logic.interfaces.StructureBehavior;

public class Graph<X> implements StructureBehavior<VertexNode<X>> {

	private LinkedList <VertexNode<X>> vertices = new LinkedList<VertexNode<X>>();
	
	public void create(VertexNode<X> element) {
		vertices.create((VertexNode<X>) element);
	}
	public void createEdge(VertexNode<X> Oelement,X Delement, int weight ) {
		vertices.consult(Oelement).getEdges().create(new GraphNode<X>(Delement,weight));
	}
	public void remove(VertexNode<X> element) {
		vertices.remove((VertexNode<X>) element);
	}
	public VertexNode<X> consult(VertexNode<X> element) {
		for(int i=0 ; i < vertices.getSize() ; i++) {
			if(this.vertices.consult(i) == element)
	               return this.vertices.consult(i);
		}
		return null;
	}
	public GraphNode<X> consultEdge(VertexNode<X> Oelement, X Delement) {
		VertexNode<X> temp = ((VertexNode<X>) vertices.consult(Oelement));
		for(int i = 0; i < temp.getEdges().getSize(); i++) {
			if(temp.getEdges().consult(i).equals(Delement))
				return temp.getEdges().consult(i);
		}
		return null;
	}
	public VertexNode<X> consultNOTvisited() {
		for(int i=0; i < vertices.getSize(); i++) {
			if((!vertices.consult(i).isVisited())){
				return vertices.consult(i);
			}
		}
		return null;
	}
	public int getSize() {
		return vertices.getSize();
	}

	public void clear() {
		vertices.clear();
	}

	public boolean isEmpty() {
		return vertices.getSize() == 0;
	}
	public String toString() {
		String msg="";
		VertexNode<X> temp;
		for(int i=1; i < vertices.getSize()+1; i++) {
			temp= vertices.consult(i);
			//System.out.println("Vertex:"+temp);
			msg = msg+"\n"+"Vertex:"+temp+"\n";
			for(int y=1; y < temp.getEdges().getSize()+1; y++) {
				msg = msg + "Edge of:"+temp.getElement()+" "+"to"+temp.getEdges().consult(y)+" "+"with weight:"+((GraphNode<X>)temp.getEdges().consult(y)).getWeight() +"\n";
				//System.out.println("Edge of:"+temp.getElement()+" "+"to"+temp.getEdges().consult(y)+" "+"with weight:"+((GraphNode<X>)temp.getEdges().consult(y)).getWeight());
			}
		}
		return msg;
	}
}
