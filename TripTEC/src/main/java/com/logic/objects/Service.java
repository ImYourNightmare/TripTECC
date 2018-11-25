package com.logic.objects;

import com.structures.graph.Graph;
import com.structures.tree.BinarySearchTree;;

public class Service {
	private Graph graph;
	private BinarySearchTree<Client> clientTree = new BinarySearchTree<Client>();
	private static String password = "TRIPTEC";
	
	//Getters y setters
	public Graph getGraph() {
		return graph;
	}
	public void setGraph(Graph graph) {
		this.graph = graph;
	}
	public BinarySearchTree<Client> getClientTree() {
		return clientTree;
	}
	public void setClientTree(BinarySearchTree<Client> clientTree) {
		this.clientTree = clientTree;
	}
	public String getPassword() {
		return password;
	}
}
