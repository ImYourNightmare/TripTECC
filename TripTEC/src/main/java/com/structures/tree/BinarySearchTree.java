package com.structures.tree;

import java.util.Comparator;

import java.util.Iterator;
import java.util.Stack;

import com.logic.objects.Client;

public class BinarySearchTree<X extends Comparable<X>> implements Iterable<X> {
	/**
	 * Al ser recursivo es totalmente necesario que el nodo se encuentre dentro de la clase
	 * Debido a que debe tener acceso directo a los par�metros de memoria dentro del codigo
	 * @author jearo
	 *
	 * @param <X>
	 */
	@SuppressWarnings("hiding") class Node<X> {
		private X element;
		private Node<X> left, right;

		public Node(X data, Node<X> left, Node<X> right) {
			this.left = left;
			this.right = right;
			this.element = data;
		}

		public Node(X data) {
			this(data, null, null);
		}

		public String toString() {
			return element.toString();
		}

		public X getElement() {
			return element;
		}

		public void setElement(X element) {
			this.element = element;
		}

		public Node<X> getLeft() {
			return left;
		}

		public void setLeft(Node<X> left) {
			this.left = left;
		}

		public Node<X> getRight() {
			return right;
		}

		public void setRight(Node<X> right) {
			this.right = right;
		}
	}
	
	/**
	 * Atributos de la clase �rbol
	 */
	private Node<X> root;
	private Comparator<X> comparator;
	String preorder="";
	
	public String getpreorder() {
		return this.preorder;
	}

	public Node<X> getRoot() {
		return root;
	}

	public void setRoot(Node<X> root) {
		this.root = root;
	}

	public Comparator<X> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<X> comparator) {
		this.comparator = comparator;
	}

	/**
	 * Constructor de la clase
	 */
	public BinarySearchTree() {
		root = null;
		comparator = null;
	}

	public BinarySearchTree(Comparator<X> comp) {
		root = null;
		comparator = comp;
	}

	public int compare(X elemA, X elemB) {
		if (comparator == null)
			return elemA.compareTo(elemB);
		else
			return comparator.compare(elemA, elemB);
	}

	/**
	 * Insertar
	 * 
	 * @param data
	 */
	public void insertarNodo(X data) {
		root = insert(root, data);
	}
	//Auxiliar de la funcion recursiva de insertar
	private Node<X> insert(Node<X> nuevoNodo, X nodoInsertado) {
		if (nuevoNodo == null)
			return new Node<X>(nodoInsertado);
		//Si el comparable retorna 0, significa que el id del cliente ya existe y no puede ser insertado de nuevo
		if (compare(nodoInsertado, nuevoNodo.element) == 0)
			return nuevoNodo;
		//Cuando el comparable retorna -1, significa que el nuevo ID es menor y debe ir a la izquierda
		if (compare(nodoInsertado, nuevoNodo.element) < 0)
			nuevoNodo.left = insert(nuevoNodo.left, nodoInsertado);
		//De otra manera, el comparable retorna 1 y el nuevo nodo va a la derecha del arbol
		else
			nuevoNodo.right = insert(nuevoNodo.right, nodoInsertado);

		return nuevoNodo;
	}

	/**
	 * Buscar
	 * 
	 * @param toSearch
	 * @return
	 */
	//Funcion utilizada para saber si algun elemento se encuentra dentro del arbol (retorna un boolean)
	public boolean searchNode(X toSearch) {
		return search(root, toSearch);
	}
	//Funcion auxiliar del buscador
	private boolean search(Node<X> p, X toSearch) {
		//Si mientras se esta buscando se encuentra con que p es nulo, significa que la busqueda ya termino y el elemento no se encuentra en el arbol
		if (p == null)
			return false;
		//Se usa el compare para guiar la busqueda.
		//Si el compare retorna 0, quiere decir que el elemento fue encontrado dentro del arbol
		else if (compare(toSearch, p.element) == 0) {
			return true;
		}	
		//Si aun no se ha encontrado el elemento y hay mas hijos, se utilizan los valores del compare para ir ya sea a la izq. o a la der.
		else if (compare(toSearch, p.element) < 0)
			return search(p.left, toSearch);
		else
			return search(p.right, toSearch);
	}
	/**
	 * Retornar un cliente. Metodo no generico
	 */
	//Funcion utilizada para buscar un cliente por su ID y retornarlo
		public Node<Client> searchClient(int toSearch) {
			return searchClientHelper((BinarySearchTree<X>.Node<Client>) root, toSearch);
		}
		//Funcion auxiliar del buscador
		private Node<Client> searchClientHelper(Node<Client> p, int toSearch) {
			//Si mientras se esta buscando se encuentra con que p es nulo, significa que la busqueda ya termino y el elemento no se encuentra en el arbol
			if (p == null)
				return null;
			//Se usa el compare para guiar la busqueda.
			//Si el compare retorna 0, quiere decir que el elemento fue encontrado dentro del arbol
			else if (p.getElement().getId() == toSearch)
				return p;
			//Si aun no se ha encontrado el elemento y hay mas hijos, se utilizan los valores del compare para ir ya sea a la izq. o a la der.
			else if (p.getElement().getId() > toSearch)
				return searchClientHelper(p.left, toSearch);
			else
				return searchClientHelper(p.right, toSearch);
		}

	/**
	 * Eliminar
	 * 
	 * @param eliminarNodo
	 */
	public void deleteNode(X eliminarNodo) {
		root = delete(root, eliminarNodo);
	}
	//Funcion auxiliar del deleteNode
	private Node<X> delete(Node<X> nodoTemp, X nodoElim) {
		//Si se busca eliminar un nodo que no esta dentro del arbol, se envia un error para avisar
		if (nodoTemp == null)
			throw new RuntimeException("cannot delete.");
		else if (compare(nodoElim, nodoTemp.element) < 0)
			nodoTemp.left = delete(nodoTemp.left, nodoElim);
		else if (compare(nodoElim, nodoTemp.element) > 0)
			nodoTemp.right = delete(nodoTemp.right, nodoElim);
		else {
			if (nodoTemp.left == null)
				return nodoTemp.right;
			else if (nodoTemp.left == null)
				return nodoTemp.right;
			else {
				// Obtiene los datos por el lado derecho
				nodoTemp.element = recieveData(nodoTemp.left);
				// Obtiene los datos del lado izquierdo
				nodoTemp.left = delete(nodoTemp.right, nodoTemp.element);
			}
		}
		return nodoTemp;
	}

	private X recieveData(Node<X> p) {
		while (p.right != null)
			p = p.right;

		return p.element;
	}

	/**
	 * TO STRING
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (X data : this)
			sb.append(data.toString());
		return sb.toString();
	}

	/**
	 * Preorden
	 */
	//Tipo de recorrido para el toString. Va en el orden Root-Left-Right
	public void preOrder() {
		preOrderHelper(root);
	}
	private String preOrderHelper(Node<X> nodoTemp) {
		if (nodoTemp != null) {
			preorder+= nodoTemp + "\n";
			//System.out.print(nodoTemp + " ");
			preOrderHelper(nodoTemp.left);
			preOrderHelper(nodoTemp.right);
		}
		return preorder;
	}

	/**
	 * En orden
	 */
	//Tipo de toString con el orden Left-Root-Right
	public void inOrder() {
		inOrderHelper(root);
	}

	private void inOrderHelper(Node<X> nodoTemp) {
		if (nodoTemp != null) {
			inOrderHelper(nodoTemp.left);
			System.out.print(nodoTemp + " ");
			inOrderHelper(nodoTemp.right);
		}
	}

	/**
	 * Post Orden
	 */
	//Tipo de recorrido que va Left-Right-Root
	public void posOrder() {
		postOrderHelper(root);
	}

	private void postOrderHelper(Node<X> nodoTemp) {
		if (nodoTemp != null) {
			inOrderHelper(nodoTemp.left);
			inOrderHelper(nodoTemp.right);
			System.out.print(nodoTemp + " ");
		}
	}

	/**
	 * Clonado
	 */
	public BinarySearchTree<X> clone() {
		BinarySearchTree<X> twin = null;

		if (comparator == null)
			twin = new BinarySearchTree<X>();
		else
			twin = new BinarySearchTree<X>(comparator);

		twin.root = cloneHelper(root);
		return twin;
	}

	private Node<X> cloneHelper(Node<X> p) {
		if (p == null)
			return null;
		else
			return new Node<X>(p.element, cloneHelper(p.left), cloneHelper(p.right));
	}

	/**
	 * Altura del �rbol
	 * 
	 * @return
	 */
	public int height() {
		return height(root);
	}

	private int height(Node<X> p) {
		if (p == null)
			return -1;
		else
			return 1 + Math.max(height(p.left), height(p.right));
	}

	/**
	 * Contar las horas del �rbol
	 * 
	 * @return
	 */
	public int countLeaves() {
		return countLeaves(root);
	}

	private int countLeaves(Node<X> p) {
		if (p == null)
			return 0;
		else if (p.left == null && p.right == null)
			return 1;
		else
			return countLeaves(p.left) + countLeaves(p.right);
	}

	/**
	 * Restaura el �rbol en orden y preorden
	 * 
	 * @param pre
	 * @param in
	 */
	public void restore(X[] pre, X[] in) {
		root = restore(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node<X> restore(X[] pre, int preL, int preR, X[] in, int inL, int inR) {
		if (preL <= preR) {
			int count = 0;
			// find the root in the inorder array
			while (pre[preL] != in[inL + count])
				count++;

			Node<X> tmp = new Node<X>(pre[preL]);
			tmp.left = restore(pre, preL + 1, preL + count, in, inL, inL + count - 1);
			tmp.right = restore(pre, preL + count + 1, preR, in, inL + count + 1, inR);
			return tmp;
		} else
			return null;
	}

	/**
	 * Corresponde al m�ximo n�mero de elementos en un nivel del �rbol
	 * 
	 * @return
	 */
	public int width() {
		int max = 0;
		for (int k = 0; k <= height(); k++) {
			int tmp = width(root, k);
			if (tmp > max)
				max = tmp;
		}
		return max;
	}

	/**
	 * Retorna el n�mero de nodos de un determinado nivel
	 * 
	 * @param p
	 * @param depth
	 * @return
	 */
	public int width(Node<X> p, int depth) {
		if (p == null)
			return 0;
		else if (depth == 0)
			return 1;
		else
			return width(p.left, depth - 1) + width(p.right, depth - 1);
	}

	/**
	 * El diametro del �rbol es el n�mero de nodos El camino m�s largo entre dos
	 * hojas
	 * 
	 * @return
	 */
	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node<X> p) {
		if (p == null)
			return 0;

		// El camino va por la ra�z
		int len1 = height(p.left) + height(p.right) + 3;

		// El camino no pasa por la ra�z
		int len2 = Math.max(diameter(p.left), diameter(p.right));

		return Math.max(len1, len2);
	}

	public Iterator<X> iterator() {
		return new IteradorBST();
	}

	// pre-order
	private class IteradorBST implements Iterator<X> {
		Stack<Node<X>> stk = new Stack<Node<X>>();

		public IteradorBST() {
			if (root != null)
				stk.push(root);
		}

		public boolean hasNext() {
			return !stk.isEmpty();
		}

		public X next() {
			Node<X> cur = stk.peek();
			if (cur.left != null) {
				stk.push(cur.left);
			} else {
				Node<X> tmp = stk.pop();
				while (tmp.right == null) {
					if (stk.isEmpty())
						return cur.element;
					tmp = stk.pop();
				}
				stk.push(tmp.right);
			}

			return cur.element;
		}
	}
	
}
