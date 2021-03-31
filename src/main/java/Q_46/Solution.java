package Q_46;

public class Solution {
    public int translateNum(int num) {
        String nums = String.valueOf(num);
        int[] dp = new int[nums.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++){
            char prev = nums.charAt(i - 2);
            switch (prev){
                case '0' : dp[i] = dp[i - 1];break;
                case '1' : dp[i] = dp[i - 1] + dp[i - 2];break;
                case '2' : if (nums.charAt(i - 1) <= '5'){
                    dp[i] = dp[i - 1] + dp[i - 2];
                }else {
                    dp[i] = dp[i - 1];
                }break;
                default: dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(01));
    }
}
