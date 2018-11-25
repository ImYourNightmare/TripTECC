package com.logic.placesmanagement;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.logic.objects.Place;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;
import com.google.maps.model.TravelMode;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.*;
import java.util.ArrayList;

public class API {
	
	
	GeoApiContext context;
	Gson gson;
	String placeId, addrOne, addrTwo;
	String origin;
	String destiny;
	Place place = new Place();
	String data = ""; 
	
	
	//Atributos de la clase
	
	public String getAddrOne() {
		return addrOne;
	}
	public void setAddrOne(String addrOne) {
		this.addrOne = addrOne;
	}
	public String getAddrTwo() {
		return addrTwo;
	}
	public void setAddrTwo(String addrTwo) {
		this.addrTwo = addrTwo;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
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
	public String getDestiny() {
		return destiny;
	}
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	
	
	
	public void Test() throws ApiException, InterruptedException, IOException {
		context = new GeoApiContext.Builder().apiKey("AIzaSyAMNKLnQIP4wvOZFQUB0PKnANDMuK9hty0").build();
		GeocodingResult[] results =  GeocodingApi.geocode(context,"tecnologico de costa rica").await();
		GeocodingResult[] results2 =  GeocodingApi.geocode(context,"basilica de los angeles").await();
		// GeocodingApi.geocode(context, "hotel barcelo");
		
		
		placeId = results[0].placeId;
		addrOne = results[0].placeId;
		addrTwo = results2[0].placeId;


		
	}

	public String placeDetails(GeoApiContext context, String placeId) throws ApiException, InterruptedException, IOException {
		PlaceDetailsRequest request = new PlaceDetailsRequest(context);
		request.placeId(placeId);
		gson = new GsonBuilder().setPrettyPrinting().create();
		
		//System.out.println(gson.toJson(request.await()));
		data = gson.toJson(request.await());
		
		
		return data;
		}
	

	public DistanceMatrixElement[] getDriveDist(String addrOne, String addrTwo) throws ApiException, InterruptedException, IOException{
	
		//set up key
	   	GeoApiContext distCalcer = new GeoApiContext.Builder()
			    .apiKey("AIzaSyAMNKLnQIP4wvOZFQUB0PKnANDMuK9hty0")
			    .build();
	   	
	   	DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(distCalcer); 
	       DistanceMatrix result = req.origins(addrOne)
	               .destinations(addrTwo)
	               .mode(TravelMode.DRIVING)
	               .avoid(RouteRestriction.TOLLS)
	               .language("en-US")
	               .await();
	       
	       
				DistanceMatrixElement[] distApart = result.rows[0].elements;
				
				System.out.println(distApart);
				
		return distApart;
	}
	
	public void  Parse(String data) {
		
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
			final String regex = "\"internationalPhoneNumber\": ([\\a-ZA-Z]*),";
							
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(dataD);
							
			while (matcher.find()) {
			    //System.out.println("Full match: " + matcher.group(0));
				for (int i = 1; i <= matcher.groupCount(); i++) {
					System.out.println(matcher.group(i));
					place.setPhoneNumber((matcher.group(i)));
						
					}
					break;
					
			}
							
			}catch(Exception e) {
				place.setPhoneNumber("NO ENCONTRADO");			
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
			final String regex = "\"types\": (.*[\\a-z].*),";
							
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(dataD);
											
			while (matcher.find()) {
			    //System.out.println(matcher.group(0));
				for (int i = 1; i <= matcher.groupCount(); i++) {
					//System.out.println(matcher.group(i));
					
					place.setPlaceActivities((matcher.group(i)) + "]");
					}
				
				
									
			}				
					}catch(Exception e) {
						place.setPlaceActivities(null);			
						}
		
		
		//Se extrae el tipo de lugar
		try {
			final String regex = "\"weekdayText\":(.*.*\\n.*\\n.*\\n.*\\n.*\\n.*\\n.*\\n.*)";
							
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(dataD);
										
			while (matcher.find()) {
			    System.out.println("Full match: " + matcher.group(0));
				for (int i = 1; i <= matcher.groupCount(); i++) {
					System.out.println(matcher.group(i));
					place.setSchedule((matcher.group(i)));
					}
					
								
			}				
					}catch(Exception e) {
						place.setSchedule(null);			
								}
		
		
		
		System.out.println(place.toString());
		
						
		
	}
	
	
	
	
	

	
			
		
			
}
		
		


	

