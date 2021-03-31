package Q_56;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer times = map.get(num);
            if (times == null) {
                map.put(num, 1);
            }else if (times == 1){
                map.remove(num);
            }else {
                map.put(num, times + 1);
            }
        }

        int[] result = new int[2];
        int count = 0;
        for (Integer key : map.keySet()) {
            result[count++] = key;
        }
        return result;
    }

    public int[] singleNumbers2(int[] nums) {
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }

        int mask = 1;
        while (true) {
            if ((mask & k) == 0) {
                mask = mask << 1;
            }else {
                break;
            }
        }

        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & mask) == 0){
                a ^= num;
            }else {
                b ^= num;
            }
        }
        return new int[] {a, b};
    }

    public static void main(String[] args) {
        int[] nums = {6,2,3,3};
        new Solution().singleNumbers2(nums);
    }
}
