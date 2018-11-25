package com.structures.tree;

import com.logic.objects.*;

public class AppMain {
	public static void main(String[] args) {
		BinarySearchTree<Client> bst = new BinarySearchTree<Client>();

		bst.insertarNodo(cliente4);
		//Client cliente5 = bst.searchNode(cliente1); // Se extrae un cliente del árbol para clonar un usuario

		bst.insertarNodo(cliente4);
		//Client cliente5 = bst.searchNode(cliente1); // Se extrae un cliente del árbol para clonar un usuario
		bst.preOrder();
		String prueba = bst.getpreorder();
		System.out.println(prueba);

		System.out.println(bst.getSize());
		//System.out.println(bst.searchClient(14));
		//bst.posOrder();
	}
}
