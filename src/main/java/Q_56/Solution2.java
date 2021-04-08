package Q_56;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                int bit = num & mask;
                bits[31 - i] += bit == 0 ? 0 : 1;
                mask = mask << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bits[i] % 3;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new Solution2().singleNumber(nums));
    }
}
