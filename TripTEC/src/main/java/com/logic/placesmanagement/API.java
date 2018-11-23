package com.logic.placesmanagement;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

public class API {
	GeoApiContext context;
	Gson gson;
	String placeId;
	
	
	String data = ""; 
	
	public GeoApiContext getContext() {
		return context;
	}
	public void setContext(GeoApiContext context) {
		this.context = context;
	}
	public Gson getGson() {
		return gson;
	}
	public void setGson(Gson gson) {
		this.gson = gson;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public void Test() throws ApiException, InterruptedException, IOException {
		context = new GeoApiContext.Builder().apiKey("AIzaSyAMNKLnQIP4wvOZFQUB0PKnANDMuK9hty0").build();
		GeocodingResult[] results =  GeocodingApi.geocode(context,"9.945722,-84.105160").await();
		gson = new GsonBuilder().setPrettyPrinting().create();
		//System.out.println(gson.toJson(results[0].addressComponents));
		//System.out.println(gson.toJson(results[0].placeId));
		//System.out.println(gson.toJson(results[0]));
		placeId = results[0].placeId;
	}
	public String placeDetails(GeoApiContext context, String placeId) throws ApiException, InterruptedException, IOException {
		PlaceDetailsRequest request = new PlaceDetailsRequest(context);
		request.placeId(placeId);
		gson = new GsonBuilder().setPrettyPrinting().create();
		
		//System.out.println(gson.toJson(request.await()));
		data = gson.toJson(request.await());
		
		
		
		
		
		
		
		return data;
		
	}
	
	public void Parse(String data) {
		
		final String regex = "\"website\": ([\\a-zA-Z].*),";
		final String dataD= data;
		
		
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(dataD);

		while (matcher.find()) {
		    //System.out.println("Full match: " + matcher.group(0));
		    for (int i = 1; i <= matcher.groupCount(); i++) {
		        System.out.println(matcher.group(i));
		    }
		}		
		
		
		
		
		
		
		
		
		
	}
}





