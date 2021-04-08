package Q_57;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = lower_bound(nums, target);
        if (right == -1) {
            return null;
        }

        while (left < right) {
            int lv = nums[left];
            int rv = nums[right];
            int sum = lv + rv;

            if (sum == target) {
                return new int[]{lv, rv};
            } else if (sum < target) {
                left++;
            }else {
                right--;
            }
        }

        return null;
    }

    public int lower_bound(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;

        while (begin <= end) {
            int mid = (begin + end) >> 1;
            int value= nums[mid];
            if (end == begin) {
                if (value > target) {
                    return -1;
                }
                return mid;
            }
            if (value <= target) {
                if (begin == mid) {
                    if (nums[end] <= target) {
                        return end;
                    }else {
                        return begin;
                    }
                }
                begin++;
            } else if (value > target) {
                end = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] result = new Solution().twoSum(nums, 9);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
