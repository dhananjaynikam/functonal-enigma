package com.leetCode;

public class RemoveDuplicateFromSortedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String args[]){

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode answer = head;
        while(answer != null && answer.next!=null){
            if(answer.next.val == answer.val){
                answer.next = answer.next.next;
            }else {
                answer = answer.next;
            }
        }

        return head;
    }
}
