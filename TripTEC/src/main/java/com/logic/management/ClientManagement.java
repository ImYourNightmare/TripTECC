package com.logic.management;

import com.logic.objects.Client;
import com.structures.tree.BinarySearchTree;

public class ClientManagement {
	
	BinarySearchTree<Client> clients = new BinarySearchTree<Client>();
	//Metodo utilizado para agregar los clientes cuando los leamos del txt
	public void setclients(BinarySearchTree<Client> clients) {
		this.clients = clients;
	}
	//Metodo para obtener todos los clientes del arbol
	public BinarySearchTree<Client> getclients() {
		return this.clients;
	}
	//Metodo para annadir un cliente al arbol
	public void addclients(Client client) {
		clients.insertNode(client);
	}
}
