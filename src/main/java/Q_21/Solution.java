package Q_21;

public class Solution {
    public int[] exchange(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;

        while (p1 < p2){
            while (p1 < p2 && isOk(nums[p1])){
                p1++;
            }

            while (p1 < p2 && !isOk(nums[p2])){
                p2--;
            }

            if (p1 < p2){
                int temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = temp;
            }
        }

        return nums;
    }

    public boolean isOk(int n){

        if (n % 2 == 0){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[] nums = {};
        new Solution().exchange(nums);
        for (int i : nums){
            System.out.print(i + " ");
        }
    }
}
