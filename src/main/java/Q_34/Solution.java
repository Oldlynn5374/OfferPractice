package Q_34;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<BinaryTreeNode>> findKRoute(BinaryTreeNode root, int k){
        List<List<BinaryTreeNode>> results = new LinkedList<>();
        List<BinaryTreeNode> result = new LinkedList<>();
        backtracking(results,result,root,k);
        return results;
    }

    public void backtracking(List<List<BinaryTreeNode>> results, List<BinaryTreeNode> result, BinaryTreeNode node, int k){
        if (node == null){
            return;
        }

        result.add(node);
        int sum = 0;
        List<BinaryTreeNode> route = new LinkedList<>();
        for (int i = result.size() - 1; i >= 0; i--) {

            sum += result.get(i).val;
            route.add(result.get(i));
            if (sum == k){
                results.add(new ArrayList<>(route));
                result.remove(node);
                return;
            }
            if (sum >= k){
                break;
            }
        }

        backtracking(results, result, node.left, k);
        backtracking(results, result, node.right, k);

        result.remove(node);

    }

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(12);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(10);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;

        List<List<BinaryTreeNode>> results = new Solution().findKRoute(node1, 22);
        for (List<BinaryTreeNode> list : results){
            for (BinaryTreeNode node : list){
                System.out.print(node.val + " ");
            }
            System.out.println();
        }
    }
}

class BinaryTreeNode{
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int val) {
        this.val = val;
    }
}
