package com.logic.TripTEC;

import java.io.IOException;


import com.google.maps.errors.ApiException;
import com.logic.placesmanagement.API;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ApiException, InterruptedException, IOException
    {
        API api = new API();
        api.Test();
        System.out.println(api.placeDetails(api.getContext(), api.getPlaceId()).await());
    }
}
