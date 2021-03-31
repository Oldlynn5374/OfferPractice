package Q_24;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }

        ListNode last = null;
        ListNode result = null;
        while (result == null){

            ListNode next = head.next;

            head.next = last;
            last = head;
            if (next == null){
                result = head;
                return result;
            }
            head = next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node = new Solution().reverseList(node1);
        System.out.println();



    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }