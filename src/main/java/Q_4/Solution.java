package Q_4;

public class Solution {

    public boolean contains(int[][] a, int target){

        // 从右上角开始
        int i = 0;
        int j = a[i].length - 1;

        while (true){
            if (i >= a.length || j < 0){
                return false;
            }
            int value = a[i][j];
            if (target == value){
                return true;
            }

            if (value > target){
                j--;
                continue;
            }
            if (value < target){
                i++;
                continue;
            }
        }

    }

    public static void main(String[] args) {
        int[][] a = {{1,2,8,9},
                     {2,4,9,12},
                     {4,7,10,13},
                     {6,8,11,15}};
        Solution solution = new Solution();
        System.out.println(solution.contains(a, 9));
    }
}
