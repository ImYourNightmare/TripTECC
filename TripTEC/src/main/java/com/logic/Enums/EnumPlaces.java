package com.logic.Enums;

public enum EnumPlaces {
	airport(0,"airport"), bank(1,"bank"), bar(2,"bar"), bus_station(3,"bus_station"), cafe(4,"cafe"), casino(5,"casino"), church(7,"hospital"), hospital(7,"hospital"),
	fire_station(8,"fire_station"),laundry(9,"laundry"), library(10,"library"), movie_theater(11,"movie_theater"), museum(12,"museum"), park(13,"park"), parking(14,"parking"), police(15,"police"),
	post_office(16,"post_office"), restaurant(17,"restaurant"), shopping_mall(18,"shopping_mall"), stadium(19,"stadium"), supermarket(20,"supermarket"), taxi_stand(21,"taxi_stand"), train_station(22,"train_station"), travel_agency(23,"travel_agency");
		
	private int order;
	private String place;

	
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	private EnumPlaces(int order, String place) {
		this.order = order;
		this.place = place;
		
	}
	
	

}
