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
public class ListLinked<E> {

    private int size;
    private Node<E> head;

    public ListLinked() {
    }

    public void addNode(E data) {
        Node<E> newNode = new Node<>(data);
        if (size == 0) { //Si la lista está vacía
            head = newNode;
            size++;
        } else {
            Node<E> aux = head;
            while (aux.hasNext()) {
                aux = aux.getNext();
            }
            aux.setNext(newNode);
            size++;
        }
    }

    public int getSize() {
        return size;
    }

    private String getData(Node<E> node) {
        if (!node.hasNext()) {
            return node.toString();
        }
        return node.toString() + " -> " + getData(node.getNext());
    }

    @Override
    public String toString() {
        return getData(head);
    }

}
