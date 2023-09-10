/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HELLO
 */
public class Node {
    Person infor;
    Node next;

    public Node() {
    }

    
    public Node(Person infor, Node next) {
        this.infor = infor;
        this.next = next;
    }
    
    public Node(Person x){
        this(x, null);
    }
}
