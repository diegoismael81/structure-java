/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import structure.DLLNode;

/**
 *
 * @author Diego
 */
public class Edge<E> {
    
    private Vertex<E> v1;
    private Vertex<E> v2;       
    private int weigth;
    private String label;
    private DLLNode<Edge<E>> position;
    

    public Edge(Vertex<E> from, Vertex<E> to) {
        this.v1 = from;
        this.v2 = to;
        this.v1.addOutEdge(this);        
    }

    public Edge(Vertex<E> from, Vertex<E> to, int weigth, String label ) {
        this.v1 = from;
        this.v2 = to;
        this.weigth = weigth;        
        this.label = label;        
        this.v1.addOutEdge(this);
        this.v2.addInEdge(this);        
    } 
        
    public Vertex<E> getV1() {
        return v1;
    }

    public void setV1(Vertex<E> v1) {
        this.v1 = v1;
    }

    public Vertex<E> getV2() {
        return v2;
    }

    public void setV2(Vertex<E> v2) {
        this.v2 = v2;
    } 

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    
    
    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public DLLNode<Edge<E>> getPosition() {
        return position;
    }

    public void setPosition(DLLNode<Edge<E>> position) {
        this.position = position;
    }
    
    
    
    
    
}
