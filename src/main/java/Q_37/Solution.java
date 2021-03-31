package Q_37;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == null){
                Iterator<TreeNode> iterator = queue.iterator();
                while (iterator.hasNext()){
                    TreeNode next = iterator.next();
                    if (next != null){
                        sb.append(",");
                        sb.append("null");
                        break;
                    }
                }
                continue;
            }else {
                sb.append(",");
                sb.append(node.val);
            }

            if (node.left == null){
                queue.offer(null);
            }else {
                queue.offer(node.left);
            }

            if (node.right == null){
                queue.offer(null);
            }else {
                queue.offer(node.right);
            }
        }
        if (sb.length() >= 3){
            sb.delete(1,2);
        }
        sb.append("]");

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 2){
            return null;
        }else {
            data = data.substring(1, data.length() - 1);
        }

        String[] splits = data.split(",");
        TreeNode head = null;
        if (!splits[0].equals("null")){
            head = new TreeNode(Integer.valueOf(splits[0]));
        }else {
            return head;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        int pos = 1;
        TreeNode node = null;
        while (pos < splits.length){
            node = queue.poll();
            String left = splits[pos++];
            if (left.equals("null")){
                node.left = null;
            }else {
                node.left = new TreeNode(Integer.valueOf(left));
                queue.offer(node.left);
            }

            if (pos >= splits.length){
                break;
            }
            String right = splits[pos++];
            if (right.equals("null")){
                node.right = null;
            }else {
                node.right = new TreeNode(Integer.valueOf(right));
                queue.offer(node.right);
            }
        }

        return head;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;

        n3.left = n4;
        n3.right = n5;
        Solution solution = new Solution();
        String str = solution.serialize(n1);
        System.out.println(str);
        TreeNode tree = solution.deserialize("[1]");
        System.out.println();
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}