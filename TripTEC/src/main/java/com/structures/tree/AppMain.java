package com.structures.tree;
import java.io.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.logic.objects.*;


public class AppMain {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("PROBANDO CON CLIENTES");
<<<<<<< HEAD
		Client cliente1 = new Client("Marcos","5-10",13,201520);
		Client cliente2 = new Client("Bryan","6",3,20);
		Client cliente3 = new Client("Manuel","3",65,20);
		Client cliente4 = new Client("Melina","5",14,20);
		Client cliente5 = new Client("ChiquiDios","45",45,20);
		Client cliente6 = new Client("Messi","9",6,20);
		Client cliente7 = new Client("Ronaldo","47",4,20);
=======
		Client cliente1 = new Client("Marcos","5-10",13,"201520");
		Client cliente2 = new Client("Bryan","6",3,"20");
		Client cliente3 = new Client("Manuel","3",65,"20");
		Client cliente4 = new Client("Melina","5",14,"20");
>>>>>>> d1a99233869a0d067508ed7cb56a9f40864ba74a
		BinarySearchTree<Client> bst = new BinarySearchTree<Client>();
		bst.insertarNodo(cliente1);
		bst.insertarNodo(cliente2);
		bst.insertarNodo(cliente3);
		
		bst.insertarNodo(cliente4);
		//Client cliente5 = bst.searchNode(cliente1); // Se extrae un cliente del árbol para clonar un usuario

		bst.insertarNodo(cliente5);
		bst.insertarNodo(cliente6);
		bst.insertarNodo(cliente7);
		//Client cliente5 = bst.searchNode(cliente1); // Se extrae un cliente del árbol para clonar un usuario
		bst.preOrder();
		String prueba = bst.getpreorder();
		System.out.println(prueba);
		
		FileOutputStream f = new FileOutputStream(new File("Usuarios.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		String data="";
		// Write objects to file
		
		o.writeObject(prueba);

		o.close();
		f.close();

		FileInputStream fi = new FileInputStream(new File("Usuarios.txt"));
		ObjectInputStream oi = new ObjectInputStream(fi);

		// Read objects
		int p=7;
		String pr2 = (String) oi.readObject();
		for (int i=0;i<=bst.width();i++) {
			String[] split = pr2.split("\n");
			System.out.println(split[i]);
		}
		//System.out.println(pr2);
		oi.close();
		fi.close();
		//System.out.println(cliente5);
		//System.out.println(bst.searchClient(14));
		//bst.posOrder();
	}
}
