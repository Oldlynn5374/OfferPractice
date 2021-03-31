package Q_32;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);

            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }

        int[] arr = new int[result.size()];
        int pos = 0;
        for (int i : result){
            arr[pos++] = i;
        }
        return arr;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}