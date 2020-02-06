package com.datastructures;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Scanner;

public class LinkedListApplication {

    public static void main(String[] args){

        LinkedList apply = new LinkedList();

        apply.insertAtStart(2);
        apply.insertAtStart(3);
        apply.insertAtEnd(4);
        apply.insertAtPos(10, 2);

        LinkedList l2 = new LinkedList();
        l2.insertAtStart(1);
        l2.insertAtStart(2);
        l2.insertAtEnd(3);
        l2.insertAtPos(10, 2);

        ArrayList<LinkedList> list = new ArrayList<>();
        list.add(apply);
        list.add(l2);

        for(LinkedList item : list){
            item.displayLinkedList();
            System.out.println("new list from here\n");
        }
    }
}