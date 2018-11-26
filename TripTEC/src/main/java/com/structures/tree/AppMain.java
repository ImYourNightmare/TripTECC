package com.structures.tree;

import java.io.*;

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
		bst.preOrder();
		String prueba = bst.getpreorder();
		//System.out.println(prueba);
		
		Object arreglo[]= {"a","b","c"};

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

		String pr2 = (String) oi.readObject();
		String[] gran = pr2.split("\n");
		for (int i=0;i<=bst.getSize();i++) {
			int cuantity=5;
			for(int p=0;p<=cuantity;p++) {
				String[] gr = pr2.split("");
				System.out.print(gr[p]);
			}
			//System.out.println(gran[i]);
		}
		//System.out.println(pr2);
		oi.close();
		fi.close();
		//System.out.println(bst.searchClient(14));
		//bst.posOrder();
	}
}
