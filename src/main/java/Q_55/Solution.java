package Q_55;

public class Solution {
    boolean isAVL = true;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if (Math.abs(left - right) > 1){
            isAVL = false;
        }

        return left > right ? left + 1 : right + 1;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}