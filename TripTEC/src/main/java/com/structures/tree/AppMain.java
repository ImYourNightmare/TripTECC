package com.structures.tree;

import com.logic.objects.*;

public class AppMain {
	public static void main(String[] args) {
		System.out.println("PROBANDO CON CLIENTES");
		Client cliente1 = new Client("Marcos","5-10",13,201520);
		Client cliente2 = new Client("Bryan","6",3,20);
		Client cliente3 = new Client("Manuel","3",65,20);
		Client cliente4 = new Client("Melina","5",-14,20);
		BinarySearchTree<Client> bst = new BinarySearchTree<Client>();
		bst.insertarNodo(cliente1);
		bst.insertarNodo(cliente2);
		bst.insertarNodo(cliente3);
		//bst.insertarNodo(cliente4);
		bst.posOrder();
		if (bst.searchNode(cliente4))
			System.out.println("Si estoy");
		else
			System.out.println("No estoy");
	}
}
