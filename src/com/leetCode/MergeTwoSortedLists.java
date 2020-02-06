package com.leetCode;

public class MergeTwoSortedLists {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public static void main(String args[]){

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode temp;
        ListNode head;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        if(l1.val > l2.val) {
            temp = l2;
            l2 = l2.next;
        }else {
            temp = l1;
            l1 = l1.next;
        }

        head = temp;

        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                temp.next = l2;
                l2 = l2.next;
                temp.next.next = null;
            }else {
                temp.next = l1;
                l1 = l1.next;
                temp.next.next = null;
            }
            temp = temp.next;
        }

        while(l1 != null){
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }

        while(l2 != null){
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }

        return head;
    }
}
