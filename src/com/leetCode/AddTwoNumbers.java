package com.leetCode;

public class AddTwoNumbers {

      //Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            //check if any is null:
            //if li1 is null, return l2, if l2 is null return l1, if all null, return null;
            if(l1==null)
                return l2;
            else if(l2==null)
                return l1;

            ListNode head = new ListNode(0);//head
            ListNode caller =addNumbers(l1,l2,head,0);

            return head;


        }
        public ListNode addNumbers(ListNode l1,ListNode l2,ListNode results, int carrier)
        {
            if(l1==null && l2==null && carrier==0)
            {

                return results;
            }
            int newCarrier = 0;

            if(l1!=null)
                results.val+=l1.val;

            if(l2!=null)
                results.val+=l2.val;
            newCarrier=(results.val+carrier)/10;
            results.val= (results.val+carrier)%10;
            if(newCarrier>0||(l1!=null&&l1.next!=null)||(l2!=null&&l2.next!=null))
            {
                results.next = new ListNode(0);

                return addNumbers(l1==null?null:l1.next,l2==null?null:l2.next,results.next,newCarrier);
            }
            return results;

        }

    }
}