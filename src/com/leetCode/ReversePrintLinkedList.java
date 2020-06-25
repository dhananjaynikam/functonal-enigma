package com.leetCode;

public class ReversePrintLinkedList {
    public static void main(String args[]){

    }

    public static void reversePrintLinkedList(ListNode head){
        if(head == null){
            return;
        }
        reversePrintLinkedList(head.next);
        System.out.println(head.val);
    }
}
