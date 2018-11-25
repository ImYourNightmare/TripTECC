package com.logic.objects;

import com.structures.graph.Graph;

public class Client implements Comparable<Client> {
	//attributes class
	private String name, birthdate, phone;
	private int id;
	private Graph graph;

	//Constructor de la clase

	public Client(String name, String birthdate, int id, String phone){
		this.name = name;
		this.birthdate = birthdate;
		this.id = id;
		this.phone = phone;
		this.graph = null;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public int compareTo(Client comp) {
		// TODO Auto-generated method stub
		//Retorna -1 cuando el comparador es menor para insertar a la izquierda del arbol
		if (id > comp.getId())
			return 1;
		//Retorna 1 cuando el comparable es mayor, para que inserte a la derecha del arbol
		else if (id < comp.getId())
			return -1;
		return 0;
	}

	public String toString() {
		return this.name;
	}
}
