package com.leetCode;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String args[]){
        Node list = new Node(7);
        Node list1 = new Node(13);
        Node list2= new Node(11);
        Node list3 = new Node(10);
        Node list4 = new Node(1);

        list.next=list1;
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;

        list1.random = list;
        list2.random = list4;
        list3.random = list2;
        list4.random = list;

        Node answer = copyRandomList(list);
    }

    public static Node copyRandomList(Node head){
        if(head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node newList = new Node(head.val);

        Node p = head;
        Node q = newList;
        map.put(p,q);
        p = p.next;

        while(p !=null){
            Node temp = new Node(p.val);
            map.put(p, temp);
            q.next = temp;
            q = temp;
            p = p.next;
        }

        p = head;
        q = newList;
        while (p!=null){
            if(p.random != null){
                q.random = map.get(p.random);
            }else {
                q.random = null;
            }
            p = p.next;
            q = q.next;
        }

        return newList;
    }
}
