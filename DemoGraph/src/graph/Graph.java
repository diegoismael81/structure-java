/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.List;
import structure.DLLNode;
import structure.DoublyListLinked;

/**
 *
 * @author Diego
 */
public class Graph<E> {

    private DoublyListLinked<Vertex<E>> vertexList;
    private DoublyListLinked<Edge<E>> edgeList;
    private boolean directed;
    private int vertexId;

    public Graph(boolean directed) {
        this.directed = directed;
        vertexList = new DoublyListLinked<Vertex<E>>();
        edgeList = new DoublyListLinked<Edge<E>>();
        vertexId = 0;
    }

    public Graph() {
        vertexList = new DoublyListLinked<Vertex<E>>();
        edgeList = new DoublyListLinked<Edge<E>>();
        vertexId = 0;
    }

    public Vertex<E> addVertex(E data) {
        Vertex<E> vertex = new Vertex<E>(data, vertexId);
        DLLNode<Vertex<E>> node = vertexList.addNode(vertex);
        vertex.setPosition(node);
        vertexId++;
        return vertex;
    }

    public void addEdge(Vertex<E> v1, Vertex<E> v2, String label, int weight) {
        Edge newEdge = new Edge<E>(v1, v2, weight, label);
        DLLNode<Edge<E>> node = edgeList.addNode(newEdge);
        newEdge.setPosition(node);
    }

    public void getAllNeighbors() {
        DLLNode<Vertex<E>> head = this.vertexList.getHead();
        while (head.hasNext()) {
            this.printNeighbors(head.getData());
            head = head.getNext();
        }
        this.printNeighbors(this.vertexList.getTail().getData());
    }

    private void printNeighbors(Vertex<E> vertex) {
        List<Vertex<E>> neighbors = vertex.getNeighbors();
        System.out.printf("Vértices vecinos de %s", vertex.toString());
        System.out.println();
        for (Vertex<E> v : neighbors) {
            System.out.println(v.toString());
        }
        System.out.println();
    }

    public Vertex<E> getVertexByData(E data) {
        Vertex<E> result = null;
        DLLNode<Vertex<E>> head = this.vertexList.getHead();
        while (head.hasNext()) {
            if (head.getData().getData().equals(data)) {
                result = head.getData();
                return result;
            }
            head = head.getNext();
        }
        //Find on tail
        DLLNode<Vertex<E>> tail = this.vertexList.getTail();
        if (tail.getData().getData().equals(data)) {
            return tail.getData();
        }
        return result;
    }

    public Vertex<E> getVertexById(int id) {
        Vertex<E> result = null;
        DLLNode<Vertex<E>> head = this.vertexList.getHead();
        while (head.hasNext()) {
            if (head.getData().getId() == id) {
                result = head.getData();
                return result;
            }
            head = head.getNext();
        }
        //Find on tail
        DLLNode<Vertex<E>> tail = this.vertexList.getTail();
        if (tail.getData().getId() == id) {
            return tail.getData();
        }
        return result;
    }
    
    public int getSumVertexGrades() {        
        int result = 0;
        DLLNode<Vertex<E>> head = this.vertexList.getHead();
        while (head.hasNext()) {
            result += head.getData().getGrade();
            head = head.getNext();
        }
        //Find on tail
        DLLNode<Vertex<E>> tail = this.vertexList.getTail();
        result += tail.getData().getGrade();        
        return result;
    }
    
    
    
    public int getNumberVertex(){
        return this.vertexList.getSize();
    }
    
    public int getNumberEdges(){
        return this.edgeList.getSize();
    }

    @Override
    public String toString() {
        String result = "";
        DLLNode<Vertex<E>> head = this.vertexList.getHead();
        while (head.hasNext()) {
            result += head.getData().toString() + "\n";
            head = head.getNext();
        }
        //Find on tail
        DLLNode<Vertex<E>> tail = this.vertexList.getTail();
        result += tail.getData().toString() + "\n";
        return "Graph{\n" + 
                result
                + '}';
    }

}
