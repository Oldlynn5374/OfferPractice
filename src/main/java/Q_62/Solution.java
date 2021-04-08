package Q_62;

import java.io.BufferedInputStream;
import java.net.ServerSocket;

public class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length + 1];
        int buy = Integer.MAX_VALUE;

        for (int i = 1; i <= prices.length; i++) {
            buy = Math.min(buy, prices[i - 1]);
            dp[i] = Math.max(dp[i - 1], prices[i - 1] - buy);
        }
        return dp[prices.length];
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(prices));
        BufferedInputStream
    }
}
