package com.logic.placesmanagement;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.logic.objects.Place;
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
	Place place;
	
	
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
		
		final String dataD= data;
		
		Place place = new Place();//Se crea un objeto tipo place
		
		//Try para poder obtener del código json los diferentes datos del lugar
		//Try para obtener el website del lugar 
		try {
			final String regex = "\"website\": ([\\a-zA-Z].*),";//SE busca los carácteres que puedan obetner dol website
			
			
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(dataD);

		
		
		
			while (matcher.find()) {
		    //System.out.println("Full match: " + matcher.group(0));
				for (int i = 1; i <= matcher.groupCount(); i++) {
					System.out.println(matcher.group(i));
			place.setWebsite(matcher.group(i));
				
					}
				}
		}catch (Exception e){
			place.setWebsite(null);
			}
		
		
		//Try para obtener el nombre del lugar
		try {
			final String regex = "\"name\": ([\\a-zA-Z].*),";
			
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(dataD);
			
			while (matcher.find()) {
			    //System.out.println("Full match: " + matcher.group(0));
					for (int i = 1; i <= matcher.groupCount(); i++) {
						System.out.println(matcher.group(i));
				place.setPlaceName(matcher.group(i));
					}
			}
			
		}catch(Exception e) {
			place.setPlaceName(null);
			
		}
		
		//Try para obtener el la latitud del lugar 
		try {
			final String regex = "\"lat\": ([\\d].*)";
					
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(dataD);
					
			while (matcher.find()) {
			    //System.out.println("Full match: " + matcher.group(0));
				for (int i = 1; i <= matcher.groupCount(); i++) {
					System.out.println(matcher.group(i));
					place.setLatitude(matcher.group(i));
					
					}
				break;
			
		}
					
		}catch(Exception e) {
			place.setLatitude(null);			
				}
		
		
		//Try para obtener el la longitud del lugar 
		try {
			final String regex = "\"lng\": (-[\\d].*)";
							
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(dataD);
							
			while (matcher.find()) {
			    //System.out.println("Full match: " + matcher.group(0));
				for (int i = 1; i <= matcher.groupCount(); i++) {
					System.out.println(matcher.group(i));
					place.setLenght((matcher.group(i)));
						
					}
					break;
					
			}
							
			}catch(Exception e) {
				place.setLenght(null);			
						}
		
		
		
		//Se obtiene el numero internacional  del lugar
		try {
			final String regex = "\"internationalPhoneNumber\": ([\\0-9]*)";
							
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(dataD);
							
			while (matcher.find()) {
			    //System.out.println("Full match: " + matcher.group(0));
				for (int i = 1; i <= matcher.groupCount(); i++) {
					System.out.println(matcher.group(i));
					place.setPhoneNumber((matcher.group(i)));
						
					}
					//break;
					
			}
							
			}catch(Exception e) {
				place.setPhoneNumber(null);			
						}		
		
		
		//Se obtiene el rating del lugar
		try {
			final String regex = "\"rating\": ([\\d].[\\d])";
							
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(dataD);
								
			while (matcher.find()) {
			    //System.out.println("Full match: " + matcher.group(0));
				for (int i = 1; i <= matcher.groupCount(); i++) {
					System.out.println(matcher.group(i));
					place.setRating((matcher.group(i)));
					}
					break;
							
			}				
					}catch(Exception e) {
						place.setRating(null);			
								}
				
				
				
		//Se obtiene el addres del lugar
		try {
			final String regex = "\"formattedAddress\": ([\\a-zA-Z].*),";
							
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(dataD);
										
			while (matcher.find()) {
			    //System.out.println("Full match: " + matcher.group(0));
				for (int i = 1; i <= matcher.groupCount(); i++) {
					System.out.println(matcher.group(i));
					place.setAddres((matcher.group(i)));
					}
					break;
								
			}				
					}catch(Exception e) {
						place.setAddres(null);			
								}
		
		
		
		
						
						
		//Se obtiene el tipo de lugar
		try {
			final String regex = "\"types\": ([\\a-zA-Z]*)]";
							
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(dataD);
											
			while (matcher.find()) {
			    //System.out.println("Full match: " + matcher.group(0));
				for (int i = 1; i <= matcher.groupCount(); i++) {
					System.out.println(matcher.group(i));
					place.setPlaceActivities((matcher.group(i)));
					}
					break;
									
			}				
					}catch(Exception e) {
						place.setPlaceActivities(null);			
						}
						
		
	}
	

	
			
		
			
}
		
		


	

