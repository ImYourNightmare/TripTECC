package com.logic.interfaces;

public interface StructureBehavior<X> {
	public void create(X element);
	public void remove(X element);
	public X consult(X element);
	public int getSize();
	public void clear();
	public boolean isEmpty();
	public String toString();
}
