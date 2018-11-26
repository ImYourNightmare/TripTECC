package com.logic.management;

import com.logic.objects.Client;
import com.structures.tree.BinarySearchTree;

public class ClientManagement {
	
	BinarySearchTree<Client> clients = new BinarySearchTree<Client>();
	
	public void setclients(BinarySearchTree<Client> clients) {
		this.clients = clients;
	}
	public BinarySearchTree<Client> getclients() {
		return this.clients;
	}
	public void addclients(Client client) {
		clients.insertNode(client);
	}
}
