package LeetCode.LinkedList;

public class OddEvenLinkedList {

    public static void main(String[] args) {
        OddEvenLinkedList test = new OddEvenLinkedList();

    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode odd = head,even = head.next, evenhead = even;
        while(even != null && even.next != null)
        {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
}
