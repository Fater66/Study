package Amazon;

public class IntersectOfTwoLinkedList {
    /**
     * 查找两个linkedlist有没有相交点
     * 双指针分别遍历两个ListNode 如果有一个reach了结尾 将它换到另一个list的head
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1!=null || p2 !=null)
        {
            if(p1 == p2) return p1;
            if(p1 == null)
            {
                p1 = headB;
                p2 = p2.next;
            }
            else if(p2 == null)
            {
                p2 = headA;
                p1 = p1.next;
            }
            else
            {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return null;
    }
}



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

