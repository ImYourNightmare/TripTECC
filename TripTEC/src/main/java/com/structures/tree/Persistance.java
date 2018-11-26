package com.structures.tree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistance {
	String Namefromtxt;
	String Idfromtxt;
	String Birthfromtxt;
	String Phonefromtxt;
	
	//método para escribir en archivo
	public void writefile(Object Users) throws IOException {
		
		FileOutputStream create = new FileOutputStream(new File("Users.txt"));
		ObjectOutputStream o = new ObjectOutputStream(create);
		// Write objects to file
		
		o.writeObject(Users);
	
		o.close();
		create.close();
	}
	//método para leer del archivo txt
	public void datapersistance() throws IOException, ClassNotFoundException {
		
		
		//se elige el archivo para leer
		FileInputStream file = new FileInputStream(new File("Users.txt"));
		ObjectInputStream oi = new ObjectInputStream(file);

		// Leer objetos y recorrer archivos

		String pr2 = (String) oi.readObject();
		String[] gran = pr2.split("\n");
		for (int i=0;i<=bst.getSize();) {
			int cuantity=4;
			String gr = gran[i];
			for(int p=0;p<=cuantity;p++) {
				String[] gr2 = gr.split(" ");
				//System.out.println(gr2[p]);
			}
			String[] gr2 = gr.split(" ");
			Namefromtxt=gr2[2];
			Birthfromtxt=gr2[4];
			Idfromtxt=gr2[0];
			Phonefromtxt=gr2[3];
			break;
			//System.out.println(gran[i]);
		}
		//cierra el archivo
		oi.close();
		file.close();
	}
}
