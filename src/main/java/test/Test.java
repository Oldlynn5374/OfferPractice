package test;

public class Test {
    public int countVowelStrings(int n) {
        int sum = 0;
        int[] dp = new int[5];
        for (int i = 0; i < 5; i++){
            dp[i] = 1;
        }
        sum = 5;
        for (int i = 0; i < n - 1; i++){
            dp[0] = dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
            dp[1] = dp[1] + dp[2] + dp[3] + dp[4];
            dp[2] = dp[2] + dp[3] + dp[4];
            dp[3] = dp[3] + dp[4];;
            dp[4] = dp[4];
            sum = dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
        }
        return sum;
    }

    public static void main(String[] args) {
        int i = 'b' - 'a';
        System.out.println((char)('a' + 1));
    }
}
