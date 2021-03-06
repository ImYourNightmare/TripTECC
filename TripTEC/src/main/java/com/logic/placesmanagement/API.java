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
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.google.maps.model.TrafficModel;
import com.google.maps.model.TransitMode;
import com.google.maps.model.TransitRoutingPreference;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import java.time.Instant;


public class API{
	//Atributos de la clases
	GeoApiContext context;
	Gson gson;
	String placeId, placeName;
	Place place = new Place();
	String data = ""; 
	double distance;
	int time;
	
	
	
	
	
	//Atributos de la clase
	
	
	public Place getPlace() {
		return place;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
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
	
	
	public void createPlaceName(String placeName) {
		this.placeName = placeName;
		
		}
	//Método que establece la cnexion con los lugares que ofrece google maps
	public void ConexionPlace() throws ApiException, InterruptedException, IOException {
		this.context = new GeoApiContext.Builder().apiKey("AIzaSyAMNKLnQIP4wvOZFQUB0PKnANDMuK9hty0").build();//Obtiene en results los lugares qe coincidan con la busqueda
		GeocodingResult[] results =  GeocodingApi.geocode(context, placeName).await();
		placeId = results[0].placeId;//se guarda en la variable placeid el id del lugar
		place.setPlaceId(placeId);// se guarda el placeid 
	}
	public String placeDetails(GeoApiContext context, String placeId) throws ApiException, InterruptedException, IOException {
		PlaceDetailsRequest request = new PlaceDetailsRequest(context);//Se guarda en request los detalles que no estan parseados
		request.placeId(placeId);
		gson = new GsonBuilder().setPrettyPrinting().create();//se guarada en gson el json de los datos del lugar 
		data = gson.toJson(request.await());//Se guarda el codigo json en data para luego parsear el codigo	
		return data;
		
		}
	
	//Métedo que permite obtener los datos del api ya parseados
	public Place  Parse(String data) {
		
		final String dataD= data;//se obtine los datos de json para parsearlos
		// Se hace un Try y execpt para poder obtener del código json los diferentes datos del lugar
		//Try para obtener el website del lugar 
		try {
			final String regex = "\"website\": ([\\a-zA-Z].*),";//SE busca los carácteres que puedan obetner dol website
			
			
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(dataD);
			
			while (matcher.find()) {
		    //System.out.println("Full match: " + matcher.group(0));
				for (int i = 1; i <= matcher.groupCount(); i++) {
					//System.out.println(matcher.group(i));
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
						//System.out.println(matcher.group(i));
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
					//System.out.println(matcher.group(i));
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
					//System.out.println(matcher.group(i));
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
					//System.out.println(matcher.group(i));
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
					//System.out.println(matcher.group(i));
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
					//System.out.println(matcher.group(i));
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
			    //System.out.println("Full match: " + matcher.group(0));
				for (int i = 1; i <= matcher.groupCount(); i++) {
					//System.out.println(matcher.group(i));
					place.setSchedule((matcher.group(i)));
					}								
			}				
					}catch(Exception e) {
						place.setSchedule(null);			
								}
		//System.out.println(place.toString());
		
		return place;
}
	public void getDriveDist(String addrOne, String addrTwo) throws ApiException, InterruptedException, IOException{
		//se crea la variable de tipo GeoApiContext llamdada distCAlcer que ayuda los request de DistanceMAtrixApiRequest
	   	GeoApiContext distCalcer = new GeoApiContext.Builder()
			    .apiKey("AIzaSyAMNKLnQIP4wvOZFQUB0PKnANDMuK9hty0")//Se necesita la apiKey para poder ejecutar el método
			    .build();//Llama al método construir
	   	
	   		DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(distCalcer); 
	   	//Se crea la matriz con los origenes y destinos de la 
	       DistanceMatrix result = req.origins(addrOne)
	               .destinations(addrTwo)
	               .mode(TravelMode.DRIVING)
	               .avoid(RouteRestriction.TOLLS)
	               .language("en-US")
	               .await();
	       //se crea la matriz	       
				DistanceMatrixElement distApart = result.rows[0].elements[0];
				
				
				String textD = distApart.distance.toString();//se obtione en string la distancia
				System.out.println(textD);
				long textT = distApart.duration.inSeconds;//se obtiene la duracion en segundos en tipo de dato long
				
				/*
				 * Se calcula la distacia
				 * 1) Se obtiene la distancia en string y se pasa a una variable tipo duoble que servirá para las arista del grafo
				 */
				String []  distAnce = textD. split(" ");
				distance = Double.parseDouble(distAnce[0]);
				
				/*
				 * Se pasa de long a int para obtener los segundos en int
				 * luego se divide en 60 para hacer la conversión a minutes
				 */
				int i = (int) textT;
				time = i/60;		
	}
	
	
	
	
	

	
			
		
			
}
		
		


	

