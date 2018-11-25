package com.structures.tree;

import com.logic.objects.*;

public class AppMain {
	public static void main(String[] args) {
		BinarySearchTree<Client> bst = new BinarySearchTree<Client>();
		System.out.println("PROBANDO CON CLIENTES");
		Client cliente1 = new Client("Marcos","5-10",13,"201520");
		Client cliente2 = new Client("Bryan","6",3,"20");
		Client cliente3 = new Client("Manuel","3",65,"20");
		Client cliente4 = new Client("Melina","5",14,"20");
		bst.insertarNodo(cliente1);
		bst.insertarNodo(cliente2);
		bst.insertarNodo(cliente3);
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
