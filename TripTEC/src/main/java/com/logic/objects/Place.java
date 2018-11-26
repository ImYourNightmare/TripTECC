package com.logic.objects;

public class Place {

	//Atrbutos de la clase place
	private String latitude, lenght, addres, placeName, placeActivities, website, phoneNumber,rating,schedule , description, activities, price, placeId; ;


	//getters and setters of class

	public String getPlaceId() {
		return placeId;
	}



	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}



	public String getSchedule() {
		return schedule;
	}



	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}


	public String getLatitude() {
		return latitude;
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

	public String getPlaceActivities() {
		return placeActivities;
	}

	public void setPlaceActivities(String placeActivities) {
		this.placeActivities = placeActivities;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActivities() {
		return activities;
	}

	public void setActivities(String activities) {
		this.activities = activities;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Place() {

	}
	//Constructor que recibe todos los atributos de la clase
	public Place(String latitude, String lenght, String addres, String placeName, String placeActivities,
			String website, String phoneNumber, String rating,String schedule, String description, String activities, String price, String placeId) {
		super();
		this.latitude = latitude;
		this.lenght = lenght;
		this.addres = addres;
		this.placeName = placeName;
		this.placeActivities = placeActivities;
		this.website = website;
		this.phoneNumber = phoneNumber;
		this.rating = rating;
		this.schedule = schedule;
		this.description = description;
		this.activities = activities;
		this.price = price;
		this.placeId = placeId;
	}



	@Override
	//Funcion utilizada para convertir la clase a Strings
	/*
	public String toString() {
		return "Place [latitude=" + latitude + ", lenght=" + lenght + ", addres=" + addres + ", placeName=" + placeName
				+ ", placeActivities=" + placeActivities + ", website=" + website + ", phoneNumber=" + phoneNumber
				+ ", rating=" + rating + ", schedule=" + schedule + ", description=" + description + ", activities="
				+ activities + ", price=" + price + ", placeId=" + placeId + "]";
	}
	*/
	public String toString() {
		return this.placeName;
	}





	}
