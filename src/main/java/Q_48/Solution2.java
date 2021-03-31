package Q_48;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        if (len == 0){
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        map.put(s.charAt(0), 0);

        for (int i = 1; i < len; i++) {
            Character c = s.charAt(i);
            Integer last = map.get(c);
            if (last == null) {
                dp[i] = dp[i - 1] + 1;
            }else {
                if (i - last > dp[i - 1]){
                    dp[i] = dp[i - 1] + 1;
                }else {
                    dp[i] = i - last;
                }
            }
            map.put(c, i);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new Solution2().lengthOfLongestSubstring(s));
    }
}
