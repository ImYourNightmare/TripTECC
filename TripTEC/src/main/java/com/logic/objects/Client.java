package com.logic.objects;


public class Client {
	//attributes class
	private String name, birthdate;
	private int id, phone;
	
	
	//Constructor de la clase
	
	public Client(String name, String birthdate, int id, int phone){
		this.name = name;
		this.birthdate = birthdate;
		this.id = id;
		this.phone = phone;
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
}
	
	
	