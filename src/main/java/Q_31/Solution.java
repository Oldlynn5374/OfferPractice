package Q_31;

import java.util.Stack;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        int p1 = 0;
        int p2 = 0;

        while (p2 < popped.length){
            int num = popped[p2++];
            if (stack.isEmpty()){

            }else if (num == stack.peek()){
                stack.pop();
                continue;
            }



            while (true){
                if (p1 >= pushed.length){
                    return false;
                }
                stack.push(pushed[p1++]);
                if (num == stack.peek()){
                    stack.pop();
                    break;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] pushed = {};
        int[] popped = {4};
        System.out.println(new Solution().validateStackSequences(pushed,popped));
    }
}
