package Q_43;

public class Solution {
    public int countDigitOne(int n) {
        String nums = String.valueOf(n);
        int bit = 1; // 位
        int sum = 0;

        for (int i = nums.length() - 1; i >= 0; i--){
            int num = nums.charAt(i) - '0';
            int left;
            int right;

            if (i == 0){
                left = 0;
            }else {
                left = Integer.valueOf(nums.substring(0, i));
            }

            if (i == nums.length() - 1){
                right = 0;
            }else {
                right = Integer.valueOf(nums.substring(i + 1, nums.length()));
            }

            switch (num){
                case 0 : sum += left * bit;break;
                case 1 : sum += left * bit + right + 1;break;
                default: sum += left * bit + bit;
            }

            bit *= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countDigitOne(0));
    }
}
