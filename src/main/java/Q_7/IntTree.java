package Q_7;

import java.util.Arrays;

/*
    输入先序和中序遍历序列，重建一个二叉树
 */

public class IntTree {
    public int value;
    public IntTree leftChild;
    public IntTree rightChild;


    public static IntTree rebuildTree(int[] firstOrder, int[] middleOrder, IntTree head){

        if (firstOrder.length == 0){
            return null;
        }

        int root = firstOrder[0];
        head.value = root;

        // 在中序遍历序列找出 root 的位置，root 左边的元素都在左子树，右边的元素都在右子树
        int pos = 0;
        while (true){
            if (middleOrder[pos] == root){
                break;
            }
            pos++;
        }

        // 中序遍历中的左右子树
        int[] leftInMiddle = Arrays.copyOfRange(middleOrder, 0, pos);
        int[] rightInMiddle = Arrays.copyOfRange(middleOrder, pos + 1, middleOrder.length);

        // 先序遍历中的左右子树
        int[] leftInFirst = new int[leftInMiddle.length];
        int[] rightInFirst = new int[rightInMiddle.length];

        int leftCount = 0;
        int rightCount = 0;
        for (int i = 1; i < firstOrder.length; i++) {
            if (leftCount < leftInFirst.length){
                leftInFirst[leftCount++] = firstOrder[i];
            }else {
                rightInFirst[rightCount++] = firstOrder[i];
            }
        }

        head.leftChild = rebuildTree(leftInFirst,leftInMiddle,new IntTree());
        head.rightChild = rebuildTree(rightInFirst,rightInMiddle,new IntTree());

        return head;
    }

    public static void printInFirst(IntTree head){
        if (head == null){
            return;
        }
        System.out.print(head.value + " ");
        printInFirst(head.leftChild);
        printInFirst(head.rightChild);
    }

    public static void printInMiddle(IntTree head){
        if (head == null){
            return;
        }
        printInMiddle(head.leftChild);
        System.out.print(head.value + " ");
        printInMiddle(head.rightChild);
    }

    public static void main(String[] args) {
        int[] first = new int[]{1,2,4,7,3,5,6,8};
        int[] middle = new int[]{4,7,2,1,5,3,8,6};
        IntTree head = new IntTree();
        head = IntTree.rebuildTree(first,middle,head);
        IntTree.printInFirst(head);
        System.out.println();
        IntTree.printInMiddle(head);

    }

}
