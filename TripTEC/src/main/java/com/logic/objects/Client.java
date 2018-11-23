package com.logic.objects;

import com.structures.graph.Graph;

public class Client {
	//attributes class
	private String name, birthdate;
	private int id, phone;
	private Graph graph;
	
	//Constructor de la clase
	
	public Client(String name, String birthdate, int id, int phone){
		this.name = name;
		this.birthdate = birthdate;
		this.id = id;
		this.phone = phone;
		this.graph = null;
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
	public void setId(int id) {
		this.id = id;
	}
	public int getPhone() {
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

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}
	public String toString() {
		return this.name;
	}

}
	
	
	