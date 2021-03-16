/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demodoublylistlinked;

import structure.DoublyListLinked;

/**
 *
 * @author Diego
 */
public class DemoDoublyListLinked {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-- Lista doblemente enlazada --");
        System.out.println("1° Ejemplo");
        DoublyListLinked<String> listDLLString = new DoublyListLinked<>();
        listDLLString.addNode("A");
        listDLLString.addNode("B");
        listDLLString.addNode("C");
        listDLLString.addNode("D");
        System.out.println(listDLLString.toString());
        System.out.printf("Tamaño :%d" , listDLLString.getSize());        
        System.out.println();   
    }
    
}
