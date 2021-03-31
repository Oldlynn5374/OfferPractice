package Q_33;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 1){
            return true;
        }

        int root = postorder[postorder.length - 1];
        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();
        int pos = 0;
        while (pos < postorder.length - 1){
            int num = postorder[pos];
            if (num < root){
                left.add(num);
            }else {
                break;
            }
            pos++;
        }

        while (pos < postorder.length - 1){
            int num = postorder[pos++];
            if (num > root){
                right.add(num);
            }else {
                return false;
            }
        }

        int[] la = new int[left.size()];
        int[] ra = new int[right.size()];

        for (int i = 0; i < left.size(); i++) {
            la[i] = left.get(i);
        }

        for (int i = 0; i < right.size(); i++) {
            ra[i] = right.get(i);
        }

        return verifyPostorder(la) && verifyPostorder(ra);

    }

    public static void main(String[] args) {
        int[] arr = {7,1};
        System.out.println(new Solution().verifyPostorder(arr));
    }
}
