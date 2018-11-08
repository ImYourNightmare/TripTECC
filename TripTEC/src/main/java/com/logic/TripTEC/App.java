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
    	VertexNode<Integer> nodo1 = new VertexNode<Integer>(1);
    	VertexNode<Integer> nodo2 = new VertexNode<Integer>(2);
    	VertexNode<Integer> nodo3 = new VertexNode<Integer>(3);
    	VertexNode<Integer> nodo4 = new VertexNode<Integer>(4);
    	VertexNode<Integer> nodo5 = new VertexNode<Integer>(5);
    	grafo.create(nodo1);
    	grafo.create(nodo2);
    	grafo.create(nodo3);
    	grafo.create(nodo4);
    	grafo.create(nodo5);
    	grafo.createEdge(nodo1, nodo2, 5);
    	grafo.createEdge(nodo1, nodo3, 2);
    	grafo.createEdge(nodo2, nodo1, 2);
    	grafo.createEdge(nodo1, nodo4, 2);
    	grafo.createEdge(nodo1, nodo5, 2);
    	//System.out.println(grafo);
    	grafo.DFS(nodo1);
    }
}
