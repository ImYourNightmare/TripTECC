package com.logic.structures;

import com.logic.interfaces.StructureBehavior;
//clase para crear estructuras LinkedList
public class LinkedList<X> implements StructureBehavior<X>{
	//atributos de la clase
	private LinkedListNode<X> head, tail;
	private int size;
	//getters & setters
	public LinkedListNode<X> getHead() {
		return head;
	}
	public void setHead(LinkedListNode<X> head) {
		this.head = head;
	}
	public LinkedListNode<X> getTail() {
		return tail;
	}
	public void setTail(LinkedListNode<X> tail) {
		this.tail = tail;
	}
	public void setSize(int size) {
		this.size = size;
	}
	//constructor de la clase
	public LinkedList() {
		this.head = new LinkedListNode<X>(null);
		this.tail = this.head;
		this.size = 0;
	}
	@SuppressWarnings("unchecked")
	//metodo para añadir un elemento a la lista
	public void create(X element) {
		if(isEmpty()) {
			head.setNext(new LinkedListNode<X>(element));
		}else {
			tail.setNext(new LinkedListNode<X>(element));
		}
		tail = tail.getNext();
		size++;
	}
	//metodo para remover un elemento de la lista
	public void remove(X element) {
		LinkedListNode<X> temp = this.head;
		while(temp.getNext() != tail) {
			if(temp.getNext().getElement().equals(element)) {
				temp.setNext(temp.getNext().getNext());
				size--;
				break;
			}else {
				temp = temp.getNext();
			}
		}
		if(temp.getNext().equals(tail) && element.equals(tail.getElement())) {
			temp.setNext(null);
			tail = temp;
			size--;
		}
	}
	//metodo para consultar un metodo de la lista
	public X consult(X element) {
		LinkedListNode<X> temp = head.getNext();
		while(!temp.getElement().equals(element)) {
			temp = temp.getNext();
		}
		return temp.getElement();
	}
	//Metodo para consultar un elemento de la lista por su indice
	public X consult(int position) {
		LinkedListNode<X> temp = head;
		if(position > this.getSize())
			return null;
		for(int i=0 ; i < position ; i++) {
			temp = temp.getNext();
		}
		return temp.getElement();
	}
	//Metodo para obtener el tamaño de la lista
	public int getSize() {
		return this.size;
	}
	//Metodo para vaciar la lista
	public void clear() {
		tail = head;
	}
	//Metodo para comprobar si al lista está vacía
	public boolean isEmpty() {
		return size == 0;
	}
	//Metodo para imprimir la lista de manera legible
	public String toString() {
		String list = "";
		LinkedListNode<X> temp = head.getNext();
		for(int i=0; i < size;i++) {
			list = list + temp+"\n";
			temp = temp.getNext();
		}
		return list;
	}
}
