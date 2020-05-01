package LeetCode.LinkedList;


import java.util.LinkedList;

public class ReorderList {

    public void reorderList(ListNode head) {
        if(head == null) return ;
        //find middle node
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null &&fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the second half of the linkedlist
        ListNode prev = null;
        ListNode post = slow.next;
        while(post != null)
        {
            ListNode temp = post.next;
            post.next = prev;
            prev = post;
            post= temp;
        }
        slow.next = null;
        //construct new linkedlist one by one
        //most difficult part
        while(head != null && prev!=null)
        {
            ListNode t1 = head.next;
            ListNode t2 = prev.next;
            prev.next = head.next;
            head.next = prev;
            head = t1;
            prev = t2;
        }
    }
}


  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }