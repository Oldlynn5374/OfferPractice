package Q_60;

public class Solution {
    public double[] dicesProbability(int n) {
        if (n <= 0) {
            return new double[0];
        }
        int min = n;
        int max = 6 * n;
        double[][] dp = new double[n + 1][max + 1];

        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1.0 / 6.0;
        }

        for (int i = 2; i <= n ; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k < 0) {
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - k] * (1.0 / 6.0);
                }
            }
        }
        double[] result = new double[dp[n].length - n];
        for (int i = 0; i < result.length; i++) {
            result[i] = dp[n][i + n];
        }
        return result;
    }

    public static void main(String[] args) {
        double[] result = new Solution().dicesProbability(3);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
