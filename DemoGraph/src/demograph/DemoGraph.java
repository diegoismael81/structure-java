/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demograph;

import graph.Graph;
import graph.Vertex;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Diego
 */
public class DemoGraph {

    private static Graph graph = new Graph();
    private static Scanner sc = new Scanner(System.in);

    private static void addVertex(int index) {
        System.out.printf("Vértice #%d", index);
        System.out.println();
        System.out.print("Ingrese el nombre: ");
        String n = sc.next();
        graph.addVertex(n);
    }

    private static Vertex<String> findVertex(String message) {
        int vertexId;
        Vertex<String> result = null;
        do {            
            System.out.print(message);            
            try{                
                vertexId = sc.nextInt();
                result = graph.getVertexById(vertexId);
            }
            catch(Exception ex){
                System.out.println("Por nombre....");                            
                result = graph.getVertexByData(sc.next());
            }
        } while (result == null);
        return result;
    }

    private static void addEdges() {
        String option;
        String label;
        int weigth = 0;
        int index = 1;
        do {
            System.out.printf("Arista #%d", index);
            System.out.println();
            Vertex<String> v1 = findVertex("Ingrese el vértice 1: ");
            Vertex<String> v2 = findVertex("Ingrese el vértice 2: ");
            if (!v1.getData().equals(v2.getData())) {
                System.out.print("Ingrese la etiqueta de la arista: ");
                label = sc.next();
                System.out.print("Ingrese el peso de la arista: ");
                weigth = sc.nextInt();
                graph.addEdge(v1, v2, label, weigth);
                index++;
            } else {
                System.out.print("No es permitido crear una arista entre el mismo vértice");
            }
            System.out.print("Continuar S/N......");
            option = sc.next();
        } while (!"N".equals(option) && !"n".equals(option));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-- Implementación de Grafos --");
        System.out.print("Ingrese el número de vértices: ");
        int numVertex = sc.nextInt();
        for (int i = 1; i <= numVertex; i++) {
            addVertex(i);
        }              
        addEdges();
        
        System.out.println("-- Vértices adyacentes --");
        graph.getAllNeighbors();
        
        System.out.println("-- Grafo --");
        System.out.println(graph.toString());
        
        System.out.println("-- Lema del apretón de manos --");
        int sumGrades = graph.getSumVertexGrades();
        
        System.out.printf("Sumatoria del grado de los vértices: %d", sumGrades);
        System.out.println();
        int twiceEdges = graph.getNumberEdges() * 2;
        System.out.printf("2 veces el número de artistas: %d", twiceEdges);
        System.out.println();        
        
        
        System.out.println("-- Búsqueda en anchura BFS --");
        Vertex<String> start = findVertex("Ingrese el vértice inicial: ");
        graph.BFS(start);        
        List<Vertex<String>> bfs = graph.getBfs();
        for(Vertex<String> v : bfs){
            System.out.println(v.toString());
        }        
        
        graph.reset();
        
        System.out.println("-- Búsqueda en profundidad DFS --");
        start = findVertex("Ingrese el vértice inicial: ");
        graph.DFS(start);        
        List<Vertex<String>> dfs = graph.getDfs();
        for(Vertex<String> v : dfs){
            System.out.println(v.toString());
        }                     
        
        
    }

}
