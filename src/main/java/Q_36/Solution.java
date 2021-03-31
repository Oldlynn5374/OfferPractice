package Q_36;

public class Solution {

    private Node lastNode = null;
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        Node min = root;
        Node max = root;
        while (true){
            if (min.left == null && max.right == null){
                break;
            }

            if (null != min){
                if (min.left != null){
                    min = min.left;
                }
            }

            if (null != max){
                if (max.right != null){
                    max = max.right;
                }
            }
        }

        recur(root);

        min.left = max;
        max.right = min;

        return min;
    }

    public void recur(Node node){
        if (node == null){
            return;
        }
        recur(node.left);

        if (lastNode != null){
            lastNode.right = node;
            node.left = lastNode;
        }
        lastNode = node;
        recur(node.right);
    }

    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(6);
        Node n3 = new Node(14);
        Node n4 = new Node(4);
        Node n5 = new Node(8);
        Node n6 = new Node(12);
        Node n7 = new Node(16);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        Node head = new Solution().treeToDoublyList(null);
        System.out.println();
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};