/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demolistlinked;

import structure.ListLinked;

/**
 *
 * @author Diego
 */
public class DemoListLinked {
           
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-- Lista simplemente enlazada --");
        System.out.println("1° Ejemplo");
        ListLinked<String> listString = new ListLinked<>();
        listString.addNode("A");
        listString.addNode("B");
        listString.addNode("C");
        listString.addNode("D");        
        System.out.println(listString.toString());
        System.out.printf("Tamaño :%d" , listString.getSize());        
        System.out.println();        
        
        System.out.println("2° Ejemplo");
        ListLinked<Integer> listNumbers = new ListLinked<>();
        listNumbers.addNode(14);
        listNumbers.addNode(52);
        listNumbers.addNode(25);
        listNumbers.addNode(19);
        listNumbers.addNode(65);
        System.out.println(listNumbers.toString());
        System.out.printf("Tamaño: %d" , listNumbers.getSize());        
        System.out.println();
        System.out.println();
        
             
        
    }    
}
