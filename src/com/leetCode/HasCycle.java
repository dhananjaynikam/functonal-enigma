package com.leetCode;

public class HasCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String args[]){

    }

    public static boolean hasCycle(ListNode head){

        if(head == null || head.next == null){
            return false;
        }
        ListNode first = head;
        ListNode second = head.next;
        while(second != first){
            if(second == null || second.next == null){
                return false;
            }else{
                first = first.next;
                second = second.next.next;
            }
        }
        return true;
    }
}
