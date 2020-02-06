package com.datastructures;

public class Node {

    protected Node link;
    protected int data;

    public Node(){
        link = null;
        data = 0;
    }

    public Node(int v, Node l){
        link = l;
        data = v;
    }

    public void setData(int d){
        data = d;
    }

    public void setLink(Node l){
        link = l;
    }

    public int getData(){
        return data;
    }

    public Node getLink(){
        return link;
    }
}
