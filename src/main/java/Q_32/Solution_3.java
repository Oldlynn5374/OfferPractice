package Q_32;

import java.util.*;

public class Solution_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> results = new ArrayList<>();
        if (root == null){
            return results;
        }
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean isLeft = true;
        while (!queue.isEmpty()){
            List<Integer> result = new ArrayList<>();
            int len = queue.size();

            List<TreeNode> queue2 = new LinkedList<>();
            for (int i = 0; i < len; i++){
                TreeNode node = queue.get(queue.size() - 1);
                queue.remove(node);
                result.add(node.val);

                if (isLeft){
                    if (node.left != null){
                        queue2.add(node.left);
                    }
                    if (node.right != null){
                        queue2.add(node.right);
                    }
                }else {
                    if (node.right != null){
                        queue2.add(node.right);
                    }
                    if (node.left != null){
                        queue2.add(node.left);
                    }
                }

            }
            isLeft = !isLeft;
            queue = queue2;

            results.add(new ArrayList<>(result));

        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;

        new Solution_3().levelOrder(node1);
        System.out.println();
    }
}
