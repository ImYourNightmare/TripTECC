package com.logic.TripTEC;

import java.io.IOException;


import com.google.maps.errors.ApiException;
import com.logic.management.Management;
import com.logic.objects.Client;
import com.logic.objects.Place;
import com.logic.placesmanagement.API;
import com.structures.graph.Dijkstra;

public class App {
    public static void main( String[] args ) throws ApiException, InterruptedException, IOException{
    	
    	
    	
        API api = new API();
        
        
        api.Test();
        
        
        
        
        
        
        //api.getDriveDist(api.placeDetails(api.getContext(), api.getPlaceId()), api.placeDetails(api.getContext(), api.getDestiny());
        api.Parse(api.placeDetails(api.getContext(), api.getPlaceId()));
        
        
        
        //System.out.println(api.placeDetails(api.getContext(), api.getPlaceId()));
    	/*Place lugar1 = new Place(null, null, null, "Mollejones", null, null, null);
    	Place lugar2 = new Place(null, null, null, "San Isidro", null, null, null);
    	Place lugar3 = new Place(null, null, null, "San Pablo", null, null, null);
    	Place lugar4 = new Place(null, null, null, "San Rafael", null, null, null);
    	Place lugar5 = new Place(null, null, null, "Los Reyes", null, null, null);
    	Place lugar6 = new Place(null, null, null, "Mollejoncitos", null, null, null);
    	Client cliente1 = new Client("Marcos", null, 0, 0);
    	Management gestion = new Management();
    	gestion.addplace(lugar1, "1");
    	gestion.addplace(lugar2, "2");
    	gestion.addplace(lugar3, "3");
    	gestion.addplace(lugar4, "4");
    	gestion.addplace(lugar5, "5");
    	gestion.addplace(lugar6, "6");
    	gestion.addroad("01", 0, 1, 23);
    	gestion.addroad("02", 0, 2, 6);
    	gestion.addroad("03", 0, 3, 4);
    	gestion.addroad("04", 0, 4, 2);
    	gestion.addroad("05", 2, 5, 1);
    	gestion.addroad("06", 1, 0, 23);
    	gestion.addroad("07", 2, 0, 6);
    	gestion.addroad("08", 3, 0, 4);
    	gestion.addroad("09", 4, 0, 2);
    	gestion.addroad("10", 5, 2, 1);
    	gestion.createclientgraph(cliente1);
    	gestion.addclientplace("1", lugar1, cliente1);
    	gestion.addclientplace("2", lugar2, cliente1);
    	gestion.addclientroad("1", gestion.getGraph().getVertices().get(0), gestion.getGraph().getVertices().get(1), 23, cliente1);
    	//gestion.removeplace(gestion.getGraph().getVertices().remove(0));
    	//System.out.println(gestion.getGraph());
    	Dijkstra dijkstra;
    	dijkstra = new Dijkstra(gestion.getGraph());
    	dijkstra.runGraph(dijkstra.getVertices().get(1));
    	System.out.println(dijkstra.getDistancias().toString());
    	//System.out.println(cliente1.getGraph().getVertices());	*/
    
    }
}
