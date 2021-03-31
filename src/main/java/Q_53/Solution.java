package Q_53;

public class Solution {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        int p1 = 2, p2 = 1;

        while (begin <= end) {
            int mid = (begin + end) >> 1;
            int value = nums[mid];
            if (value == target) {
                if (mid == 0 || nums[mid - 1] != target){
                    p1 = mid;
                    break;
                }
                end = mid;
            }

            if (value > target) {
                end = mid - 1;
            }

            if (value < target) {
                begin = mid + 1;
            }
        }

        begin = p1;
        end = nums.length - 1;

        while (begin <= end) {
            int mid = (begin + end) >> 1;
            int value = nums[mid];

            if (value == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    p2 = mid;
                    break;
                }
                begin = mid + 1;
            }

            if (value > target) {
                end = mid - 1;
            }

            if (value < target) {
                begin = mid + 1;
            }
        }

        return p2 - p1 + 1;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new Solution().search(nums, 10));
    }
}
