package com.logic.structures;

import com.logic.interfaces.StructureBehavior;

public class Graph<X> implements StructureBehavior<VertexNode<X>> {

	private LinkedList <VertexNode<X>> vertices = new LinkedList<VertexNode<X>>();
	
	public void create(VertexNode<X> element) {
		vertices.create((VertexNode<X>) element);
	}
	public void createEdge(VertexNode<X> oVertex,VertexNode<X> dVertex, int weight ) {
		vertices.consult(oVertex).getEdges().create(new GraphEdge<X>(dVertex,weight));
	}
	public void remove(VertexNode<X> vertex) {
		vertices.remove((VertexNode<X>) vertex);
	}
	public void removeEdge(VertexNode<X> oVertex, GraphEdge<X> Edge) {
		vertices.consult(oVertex).getEdges().remove(Edge);
	}
	public VertexNode<X> consult(VertexNode<X> vertex) {
		for(int i=0 ; i < vertices.getSize() ; i++) {
			if(this.vertices.consult(i) == vertex)
				return this.vertices.consult(i);
		}
		return null;
	}
	public GraphEdge<X> consultEdge(VertexNode<X> oVertex, X Delement) {
		VertexNode<X> temp = ((VertexNode<X>) vertices.consult(oVertex));
		for(int i = 0; i < temp.getEdges().getSize(); i++) {
			if(temp.getEdges().consult(i).equals(Delement))
				return temp.getEdges().consult(i);
		}
		return null;
	}
	public VertexNode<X> consultNOTvisited() {
		for(int i=1; i < vertices.getSize()+1; i++) {
			if((!vertices.consult(i).isVisited())){
				return vertices.consult(i);
			}
		}
		return null;
	}
	public void setallNOTVisited() {
		for (int i=1; i < vertices.getSize()+1; i++) {
			vertices.consult(i).setVisited(false);
		}
	}
	public void DFS(VertexNode<X> oVertex) {
		VertexNode<X> current = consult(oVertex);
		while(current != null) {
			if(!current.isVisited()) {
				System.out.println(current);
				current.setVisited(true);
				for(int i=1; i < current.getEdges().getSize()+1; i++) {
					DFS(current.getEdges().consult(i).getVertex());
				}
			}
			current = consultNOTvisited();
		}
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
			msg = msg+"Vertex:"+temp+"\n";
			for(int y=1; y < temp.getEdges().getSize()+1; y++) {
				msg = msg + "Edge of:"+temp.getElement()+" "+"to"+temp.getEdges().consult(y)+" "+"with weight:"+((GraphEdge<X>)temp.getEdges().consult(y)).getWeight() +"\n";
			}
			msg = msg + "\n";
		}
		return msg;
	}
}
