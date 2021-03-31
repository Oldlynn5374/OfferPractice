package Q_54;

public class Solution {
    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return result == null ? -1 : result.val;
    }
    private int counter = 0;
    private TreeNode result = null;
    public void dfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        dfs(node.right, k);
        if (result != null) {
            return;
        }

        counter++;
        if (counter == k) {
            result = node;
            return;
        }

        dfs(node.left, k);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}