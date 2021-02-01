package Q_8;


/*
    输入一个二叉树和其中一节点，返回中序遍历的下一个节点
 */
public class Solution {


    public Tree findNextMiddle(Tree node) {
        Tree res = null;

        if (node.rightChild == null && node.value.equals(node.father.leftChild.value)) {
            res = node.father;

        } else if (node.rightChild != null) {
            Tree pos = node.rightChild;
            while (pos.leftChild != null) {
                pos = pos.leftChild;
            }
            res = pos;
        } else if (node.rightChild == null && node.father.value == node.father.father.rightChild.value) {
            Tree pos = node.father;
            while (true) {
                if (pos.value == pos.father.leftChild.value) {
                    res = pos.father;
                    break;
                }
                if (pos == null) {
                    res = null;
                    break;
                }
                pos = pos.father;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Tree head = new Tree();
        head.value = "a";
        Tree p1 = new Tree("b");
        Tree p2 = new Tree("c");
        head.leftChild = p1;
        head.rightChild = p2;
        p1.father = head;
        p2.father = head;

        Tree p3 = new Tree("d");
        Tree p4 = new Tree("e");
        Tree p5 = new Tree("h");
        Tree p6 = new Tree("i");

        p1.leftChild = p3;
        p3.father = p1;
        p1.rightChild = p4;
        p4.father = p1;
        p4.leftChild = p5;
        p5.father = p4;
        p4.rightChild = p6;
        p6.father = p4;

        System.out.println(solution.findNextMiddle(p5).value);
    }
}

class Tree {
    public String value;
    public Tree father;
    public Tree leftChild;
    public Tree rightChild;

    public Tree() {
    }

    public Tree(String value) {
        this.value = value;
    }
}

