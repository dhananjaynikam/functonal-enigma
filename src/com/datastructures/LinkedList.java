package com.datastructures;

public class LinkedList {

    protected Node start;
    protected Node end;
    protected int size;

    public LinkedList(){
        start = null;
        end = null;
        size = 0;
    }

    public boolean isEmpty(){
        return start == null;
    }

    public int getSize(){
        return size;
    }

    public void insertAtStart(int val){

        Node newptr = new Node(val, null);

        if(start == null){
            start = newptr;
            end = newptr;
        }else{
            newptr.setLink(start);
            start = newptr;
        }
        size++;
    }

    public void insertAtEnd(int val){

        Node newptr = new Node(val, null);

        if(start == null){
            start = newptr;
            end = newptr;
        }else{
            end.setLink(newptr);
            end = newptr;
        }
        size++;
    }

    public void insertAtPos(int val, int pos){

        Node newptr = new Node(val, null);

        Node ptr = start;
        if(pos > (size+1)){
            System.out.println("ERROR position bigger than size");
            return;
        }

        for(int i = 1; i < pos; i++){

            if(i == (pos-1)){
                Node temp = ptr.getLink();
                ptr.setLink(newptr);
                newptr.setLink(temp);
                break;
            }
            ptr.getLink();

        }
        size ++;

    }

    public void deleteAtPos(int pos){

        if(pos > size){
            System.out.println("ERROR invalid position");
        }
        if(pos == 1){

            start = start.getLink();
            size--;
            return;

        }else if(pos == size){
            Node n = start;
            Node s = start;

            while(s != end){
                n = s;
                s = s.getLink();
            }
            end = n;
            end.setLink(null);
            size--;
            return;

        }else{

            Node n = start;
            Node s = start.getLink();

            for(int i = 1; i < pos; i++){
                n = s;
                s = s.getLink();
                if(i == pos-1){
                    s = s.getLink();
                    n.setLink(s);
                }
            }
            size --;
            return;
        }
    }

    public void displayLinkedList(){
        if(start == null){
            System.out.println("Empty LinkedList");
            return;
        }

        System.out.print("Linked List data = ");
        Node n = start;

        for(int i = 1; i <= size; i++){
            System.out.print(n.getData()+"->");
            n = n.getLink();
        }
        System.out.println("end");
    }

}
