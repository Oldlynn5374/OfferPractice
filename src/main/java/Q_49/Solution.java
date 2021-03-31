package Q_49;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }
        Set<Integer> hash = new HashSet<>();

        hash.add(1);
        hash.add(2);
        hash.add(3);
        hash.add(4);
        hash.add(5);
        hash.add(6);
        int last = 6;

        int counter = 6;

        while (counter != n) {
            last++;
            if ((last % 2 == 0 && hash.contains(last / 2)) || (last % 3 == 0 && hash.contains(last / 3)) || last % 5 == 0 && hash.contains(last / 5)) {
                hash.add(last);
                counter++;
            }
        }


        return last;
    }

    public int nthUglyNumber2(int n) {
        if (n <= 6) {
            return n;
        }
        int[] dp = new int[n];
        int a = 0, b = 0, c = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));

            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber2(10));
    }


}
