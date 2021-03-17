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
public class Vertex<E> {

    private int id;
    private E data;
    private DoublyListLinked<Edge<E>> inEdges;
    private DoublyListLinked<Edge<E>> outEdges;
    private DLLNode<Vertex<E>> position;

    public Vertex(E data, DLLNode<Vertex<E>> position, int id) {
        this.data = data;
        this.position = position;
        this.id = id;
    }

    public Vertex(E data, int id) {
        this.data = data;
        this.id = id;
        inEdges = new DoublyListLinked<>();
        outEdges = new DoublyListLinked<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public DLLNode<Vertex<E>> getPosition() {
        return position;
    }

    public void setPosition(DLLNode<Vertex<E>> position) {
        this.position = position;
    }

    public DoublyListLinked<Edge<E>> getInEdges() {
        return inEdges;
    }

    public DoublyListLinked<Edge<E>> getOutEdges() {
        return outEdges;
    }

    public void addInEdge(Edge<E> e) {
        inEdges.addNode(e);
    }

    public void addOutEdge(Edge<E> e) {
        outEdges.addNode(e);
    }

    public List<Vertex<E>> getNeighbors() {
        List<Vertex<E>> neighbors = new ArrayList<>();
        DLLNode<Edge<E>> head;        
        Vertex<E> vertexToAdd;
        int i = 0;

        //For each Edge in outEdges
        if (this.outEdges.getSize() > 0) {
            head = this.outEdges.getHead();
            do {
                vertexToAdd = head.getData().getV2();
                neighbors.add(vertexToAdd);
                head = head.getNext();
                i++;
            } while (i < this.outEdges.getSize());
        }

        if (this.inEdges.getSize() > 0) {
            //For each Edge in inEdges
            head = this.inEdges.getHead();
            i = 0;
            do {
                vertexToAdd = head.getData().getV1();
                if (neighbors.indexOf(vertexToAdd) == -1) {
                    neighbors.add(vertexToAdd);
                }
                head = head.getNext();
                i++;
            } while (i < this.inEdges.getSize());
        }

        return neighbors;
    }

    @Override
    public String toString() {
        return "[" + data + ']';
    }

}
