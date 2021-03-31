package Q_51;

public class Solution {
    private int result = 0;
    public int reversePairs(int[] nums) {
        sort(nums, 0, nums.length - 1, new int[nums.length]);
        return result;
    }

    public void sort(int[] nums, int begin, int end, int[] temp) {
        if (begin >= end) {
            return;
        }
        int mid = (begin + end) >> 1;
        sort(nums, begin, mid, temp);
        sort(nums, mid + 1, end, temp);
        merge(nums, begin, mid, end, temp);
    }

    public void merge(int[] nums, int begin, int mid, int end, int[] temp) {
        int p1 = mid;
        int p2 = end;
        int p3 = end;
        while (p3 >= begin) {
            int v1 = nums[p1];
            int v2 = nums[p2];

            if (v1 > v2) {
                result += p2 - mid;
                temp[p3--] = v1;
                p1--;
            } else {
                temp[p3--] = v2;
                p2--;
            }

            if (p1 < begin) {
                while (p2 >= mid + 1) {
                    temp[p3--] = nums[p2--];
                }
                break;
            }

            if (p2 < mid + 1) {
                while (p1 >= begin) {
                    temp[p3--] = nums[p1--];
                }
                break;
            }
        }


        while (begin <= end) {
            nums[begin] = temp[begin];
            begin++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        System.out.println(new Solution().reversePairs(nums));
    }
}
