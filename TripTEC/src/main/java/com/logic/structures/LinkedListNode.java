package com.logic.structures;
//Clase para crear nodos genericos usados por la LinkedList
public class LinkedListNode<X> {
	//Atributos de la clase
	private X element;
	private LinkedListNode<X> next;
	//getters & setters
	public X getElement() {
		return element;
	}

	public void setElement(X element) {
		this.element = element;
	}

	public LinkedListNode<X> getNext() {
		return next;
	}

	public void setNext(LinkedListNode<X> next) {
		this.next = next;
	}
	//constructor de la clase
	public LinkedListNode(X element) {
		this.element = element;
		this.next = null;
	}
	//metodo para indicar como se debe de imprimir el nodo
	public String toString() {
		return ""+element;
	}
}
