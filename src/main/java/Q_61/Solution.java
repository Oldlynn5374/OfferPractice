package Q_61;

import java.util.Arrays;

public class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int need = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int cur = nums[i];
            int next = nums[i + 1];
            if (cur != 0 && cur == next) {
                return false;
            }
            if (cur == 0) {
                count++;
                continue;
            }

            need += (next - cur - 1);
        }

        if (count >= need) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0,7,0,3,5};
        System.out.println(new Solution().isStraight(nums));
    }
}
