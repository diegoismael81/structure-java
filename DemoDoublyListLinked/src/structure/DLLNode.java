/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

/**
 *
 * @author Diego
 */
public class DLLNode<E> {  //DoublyListLinked Node    
    private E data;
    private DLLNode<E> next;
    private DLLNode<E> previous;

    public DLLNode(E data) {
        this.data = data;
    }

    public DLLNode(E data, DLLNode<E> next, DLLNode<E> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public DLLNode<E> getNext() {
        return next;
    }

    public void setNext(DLLNode<E> next) {
        this.next = next;
    }

    public DLLNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode<E> previous) {
        this.previous = previous;
    }
    
    public boolean hasNext() {
        return this.next != null;
    }
    
    public boolean hasPrevious() {
        return this.previous != null;
    }
    
    @Override
    public String toString() {
        return "[" + data + ']';
    }    
        
}
