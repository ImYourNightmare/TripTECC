package com.logic.structures;

public class LinkedListNode<X> {
	
	private X element;
	private LinkedListNode<X> next;
	
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

	public LinkedListNode(X element) {
		this.element = element;
		this.next = null;
	}
	public String toString() {
		return ""+element;
	}
}
