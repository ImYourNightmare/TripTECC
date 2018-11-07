package com.logic.TripTEC;

import java.io.IOException;

import com.google.maps.errors.ApiException;
import com.logic.placesmanagement.API;
import com.logic.structures.Graph;
import com.logic.structures.LinkedList;
import com.logic.structures.VertexNode;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ApiException, InterruptedException, IOException
    {
        //API api = new API();
        //api.Test();
        //System.out.println(api.placeDetails(api.getContext(), api.getPlaceId()).await());
    	Graph<Integer> grafo = new Graph<Integer>();
    	VertexNode<Integer> nodo = new VertexNode<Integer>(1);
    	VertexNode<Integer> nodo2 = new VertexNode<Integer>(3);
    	grafo.create(nodo);
    	grafo.createEdge(nodo, 3, 5);
    	grafo.createEdge(nodo, 2, 7);
    	grafo.createEdge(nodo, 1, 9);
    	grafo.create(nodo2);
    	grafo.createEdge(nodo2, 6, 2);
    	grafo.createEdge(nodo2, 7, 1);
    	grafo.createEdge(nodo2, 9, 15);
    	System.out.println(grafo);
    }
}
