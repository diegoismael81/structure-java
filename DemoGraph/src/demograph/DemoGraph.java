/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demograph;

import graph.Edge;
import graph.Vertex;
import java.util.List;

/**
 *
 * @author Diego
 */
public class DemoGraph {

    
    private static void getNeighbors(Vertex<String> vertex){
        List<Vertex<String>> neighbors = vertex.getNeighbors();
        System.out.printf("Vértices vecinos de %s", vertex.getData());
        System.out.println();
        for(Vertex<String> v : neighbors){
            System.out.println(v.toString());
        }
        System.out.println();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-- Ejemplo de grafo con DLL --");
        System.out.println("Vértices: A - B - C - D");
        
        Vertex<String> vA = new Vertex<>("A", 1);
        Vertex<String> vB = new Vertex<>("B", 2);
        Vertex<String> vC = new Vertex<>("C", 3);
        Vertex<String> vD = new Vertex<>("D", 4);
        Vertex<String> vG = new Vertex<>("G", 5);
        
        new Edge<>(vA, vB, 7, "Kms");
        new Edge<>(vA, vC, 5, "Kms");
        new Edge<>(vC, vB, 11, "Kms");
        new Edge<>(vB, vD, 4, "Kms");   
        new Edge<>(vD, vA, 14, "Kms");
        new Edge<>(vB, vG, 20, "Kms");
        
        getNeighbors(vA);
        getNeighbors(vB);
        getNeighbors(vC);
        getNeighbors(vD);
        getNeighbors(vG);
               
    }
    
}
