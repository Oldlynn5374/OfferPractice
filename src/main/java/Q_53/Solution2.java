package Q_53;

public class Solution2 {
    public int missingNumber(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;

        while (begin <= end) {
            int mid = (begin + end) >> 1;
            int value = nums[mid];

            if (value == mid) {
                begin = mid + 1;
            }

            if (value > mid) {
                if (mid == 0 || nums[mid - 1] == mid - 1) {
                    return mid;
                }
                end = mid;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,3,4,5,6,7,8,9};
        System.out.println(new Solution2().missingNumber(nums));
        int begin = 0;
        int end = 3;
        System.out.println(begin + ((end - begin) >> 1));
    }
}
