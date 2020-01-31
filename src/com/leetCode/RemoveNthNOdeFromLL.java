package com.leetCode;

public class RemoveNthNOdeFromLL {
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

    public static void main(String args[]){

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headIterate = new ListNode(0);
        headIterate.next = head;
        ListNode toRemove = headIterate;
        ListNode beforeToRemove = headIterate;

        for(int i = 1; i <= n+1; i++){
            toRemove = toRemove.next;
        }

        while(toRemove != null){
            toRemove = toRemove.next;
            beforeToRemove = beforeToRemove.next;
        }
        beforeToRemove.next = beforeToRemove.next.next;

        return headIterate.next;
    }
}
