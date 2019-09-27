package com.datastructures;

public class QueueLinkedList extends LinkedList{

    protected Node first;
    protected int size;

    public QueueLinkedList(){
        first = null;
    }

    public void addToQueue(int data){
        insertAtEnd(data);
    }

    public void displayQueue(){
        displayLinkedList();
    }

    public void leaveQueue(){
        deleteAtPos(1);
    }

}
