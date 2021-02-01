package Q_3;

import java.util.ArrayList;
import java.util.List;

/*
    找出数组中重复的数字
    时间复杂度 O(n)
    空间复杂度 O(1)
 */
public class Solution {
    public void duplicate(int[] a, List<Integer> result){
        int i = 0;
        while (true){
            if (i == a.length){
                break;
            }
            int m = a[i];
            if (m == i){


            }else if (a[m] == m){
                // 重复了
                result.add(m);

            }else {
                int temp = a[m];
                a[m] = a[i];
                a[i] = temp;
                continue;
            }
            i++;

        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,0,2,0,3};
        Solution solution = new Solution();
        List<Integer> result = new ArrayList<>();
        solution.duplicate(a,result);
        for (Integer i : result){
            System.out.println(i);
        }
    }
}
