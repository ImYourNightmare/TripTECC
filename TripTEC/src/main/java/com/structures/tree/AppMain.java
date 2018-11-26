package com.structures.tree;

import java.io.*;
import com.structures.tree.*;
import com.logic.objects.*;

public class AppMain {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		BinarySearchTree<Client> bst = new BinarySearchTree<Client>();
		System.out.println("PROBANDO CON CLIENTES");
		Client cliente1 = new Client("Marcos","5-10",13,"201520");
		Client cliente2 = new Client("Bryan","6",3,"20");
		Client cliente3 = new Client("Manuel","3",65,"20");
		Client cliente4 = new Client("Melina","5",14,"20");
		Client cliente5 = new Client("Segreda","6",18,"20");
		bst.insertNode(cliente1);
		bst.insertNode(cliente2);
		bst.insertNode(cliente3);
		bst.insertNode(cliente4);
		bst.insertNode(cliente5);
		//Client cliente5 = bst.searchNode(cliente1); // Se extrae un cliente del árbol para clonar un usuario
		
		//System.out.println(bst.searchClient(14));
		bst.posOrder();

	}
}
