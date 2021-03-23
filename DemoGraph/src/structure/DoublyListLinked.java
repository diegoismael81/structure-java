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
public class DoublyListLinked<E> {

    private int size;
    private DLLNode<E> head;
    private DLLNode<E> tail;

    public DoublyListLinked() {
    }
    
    public DLLNode<E> getHead(){
        return head;
    }
    
    public DLLNode<E> getTail(){
        return tail;
    }

    public DLLNode<E> addNode(E data) {
        DLLNode<E> newNode = new DLLNode<>(data);
        if (size == 0) { //Si la lista está vacía
            head = newNode;            
        } else {           
            tail.setNext(newNode);
            newNode.setPrevious(tail);            
        }        
        tail = newNode;
        size++;
        return newNode;
    }

    public int getSize() {
        return size;
    }

    private String getDataAsc(DLLNode<E> node) {
        if (!node.hasNext()) {
            return node.toString();
        }
        return node.toString() + " <=> " + getDataAsc(node.getNext());
    }
    
    private String getDataDesc(DLLNode<E> node) {
        if (!node.hasPrevious()) {
            return node.toString();
        }
        return node.toString() + " <=> " + getDataDesc(node.getPrevious());
    }

    @Override
    public String toString() {
        return getDataAsc(head) + "\n" + getDataDesc(tail);
    }

}
