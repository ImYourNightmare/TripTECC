package com.structures.tree;

public class AppMain {
	public static void main(String[] args) {
		System.out.println("PROBANDO CON UNA LISTA DE ENTEROS");
		Integer[] a = { 6,3,2,5,8,7,4,5,9,9 };
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		for (Integer n : a)
			bst.insertarNodo(n);

		///POST ORDEN
		bst.posOrder();
		System.out.println();

		/**
		 * Crea un espejo de BST con la regla: izq ---> padre ----> derecha
		 * Utiliza el comparador para llegar al inicio
		 */
		System.out.print("\n\nPROBANDO CON UNA COMPOSICIÓN DE COMPARABLES");
		bst = new BinarySearchTree<Integer>(new Composition());
		
		for (Integer n : a)
			bst.insertarNodo(n);

		System.out.println("\npreorden");
		bst.preOrder();
		System.out.println("\norden");
		bst.inOrder();
		System.out.println("\npostorden");
		bst.posOrder();

		/*for (Integer n : bst)
			System.out.print(n);
		*/
		
		System.out.println("\n\nContenido del árbol");

		System.out.println(bst);

		// Restaurar un árbol a partir de transversales desordenados
		bst.restore(new Integer[] { 11, 8, 6, 4, 7, 10, 19, 43, 31, 29, 37, 49 },
				new Integer[] { 4, 6, 7, 8, 10, 11, 19, 29, 31, 37, 43, 49 });
		
		System.out.println("\nPre orden");
		bst.preOrder();
		System.out.println("\nIn orden");
		bst.inOrder();
		System.out.println("\nPost orden");
		bst.posOrder();
		
		System.out.println("\n");

		// Diámetro
		System.out.println("DIAMETRO = " + bst.diameter());
		// Ancho
		System.out.println("ANCHO = " + bst.width());
	}
}
