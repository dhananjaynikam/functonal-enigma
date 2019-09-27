package com.datastructures;

import java.util.Scanner;

public class LinkedListApplication {

    public static void main(String[] args){

        LinkedList apply = new LinkedList();

        apply.insertAtStart(2);
        apply.displayLinkedList();
        apply.insertAtStart(3);
        apply.displayLinkedList();
        apply.insertAtEnd(4);
        apply.displayLinkedList();
        apply.insertAtPos(10, 2);
        apply.displayLinkedList();


    }
}