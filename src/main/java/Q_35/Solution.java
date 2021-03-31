package Q_35;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<>();
        Node node = new Node(head.val);
        Node result = node;
        nodeMap.put(head, node);

        while (head != null){
            Node next = nodeMap.get(head.next);


            if (next == null){
                if (head.next == null){
                    next = null;
                }else {
                    next = new Node(head.next.val);
                }
                nodeMap.put(head.next, next);
            }
            Node sibling = nodeMap.get(head.random);
            if (sibling == null){
                if (head.random == null){
                    sibling = null;
                }else {
                    sibling = new Node(head.random.val);
                }
                nodeMap.put(head.random, sibling);
            }

            node.next = next;
            node.random = sibling;

            head = head.next;
            if (head == null){
                break;
            }
            node = node.next;
        }

        return result;
    }

    public Node copyRandomList2(Node head) {
        Node start = head;
        Node result = null;
        if (start != null){
            Node copy = new Node(head.val);
            result = copy;
            copy.next = head.next;
            start.next = copy;
            start = copy.next;
        }
        // 拼接副本
        while (start != null){
            Node copy = new Node(start.val);
            copy.next = start.next;
            start.next = copy;
            start = copy.next;
        }

        // 副本 random 相连
        start = head;
        while (start != null){
            Node copy = start.next;
            Node random = start.random;
            if (random == null){
                copy.random = null;
            }else {
                copy.random = random.next;
            }

            start = copy.next;
        }

        // 解体
        start = head;
        while (start != null){
            Node copy = start.next;

            start.next = copy.next;
            if (copy.next != null){
                copy.next = copy.next.next;
            }


            start = start.next;
        }

        return result;
    }


    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        n1.random = n2;
        n2.random = n2;

        Node node = new Solution().copyRandomList2(null);
        System.out.println();
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}