package com.logic.structures;

import com.logic.interfaces.StructureBehavior;

public class LinkedList<X> implements StructureBehavior<X>{

	private LinkedListNode<X> head, tail;
	private int size;
	
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
	public LinkedList() {
		this.head = new LinkedListNode<X>(null);
		this.tail = this.head;
		this.size = 0;
	}
	@SuppressWarnings("unchecked")
	public void create(X element) {
		if(isEmpty()) {
			head.setNext(new LinkedListNode<X>(element));
		}else {
			tail.setNext(new LinkedListNode<X>(element));
		}
		tail = tail.getNext();
		size++;
	}

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

	public X consult(X element) {
		LinkedListNode<X> temp = head.getNext();
		while(!temp.getElement().equals(element)) {
			temp = temp.getNext();
		}
		return temp.getElement();
	}
	public X consult(int position) {
		LinkedListNode<X> temp = head;
		for(int i=0 ; i < position ; i++) {
			temp = temp.getNext();
		}
		return temp.getElement();
	}
	public int getSize() {
		return this.size;
	}
	public void clear() {
		tail = head;
	}
	public boolean isEmpty() {
		return size == 0;
	}
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
