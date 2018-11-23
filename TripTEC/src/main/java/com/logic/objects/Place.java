package com.logic.objects;

public class Place {
	
	//Atrbutos de la clase place
	private String latitude, lenght, addres, placeName, Description, placeActivities, placeVisit;

	
	//getters and setters of class
	
	public String getLatitude() {
		return latitude;
	}

	public Place(String latitude, String lenght, String addres, String placeName, String description,
			String placeActivities, String placeVisit) {
		this.latitude = latitude;
		this.lenght = lenght;
		this.addres = addres;
		this.placeName = placeName;
		Description = description;
		this.placeActivities = placeActivities;
		this.placeVisit = placeVisit;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLenght() {
		return lenght;
	}

	public void setLenght(String lenght) {
		this.lenght = lenght;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPlaceActivities() {
		return placeActivities;
	}

	public void setPlaceActivities(String placeActivities) {
		this.placeActivities = placeActivities;
	}

	public String getPlaceVisit() {
		return placeVisit;
	}

	public void setPlaceVisit(String placeVisit) {
		this.placeVisit = placeVisit;
	}
	public String toString() {
		return this.placeName;
	}
}
