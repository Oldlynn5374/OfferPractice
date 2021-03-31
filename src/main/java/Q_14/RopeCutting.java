package Q_14;

public class RopeCutting {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= i / 2; j++){
                dp[i] = Math.max(dp[i],Math.max(j * (i - j), dp[i - j] * j));
            }
        }

        return dp[n];
    }

    public int greedy(int n){
        if (n == 4){
            return 4;
        }
        if (n == 2){
            return 2;
        }
        if (n < 2){
            return 1;
        }

        return 3 * greedy(n - 3);
    }

    public static void main(String[] args) {
        RopeCutting ropeCutting = new RopeCutting();
        System.out.println(ropeCutting.greedy(4));
    }
}
