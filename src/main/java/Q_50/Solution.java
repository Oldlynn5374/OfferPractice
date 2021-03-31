package Q_50;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public char firstUniqChar(String s) {
        int len = s.length();
        int[][] table = new int[26][1];

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int pos = c - 'a';
            table[pos][0]++;
        }

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int pos = c - 'a';
            if (table[pos][0] == 1){
                return c;
            }
        }
        return ' ';
    }

    public char firstUniqChar2(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
        }

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry entry : entries) {
            if ((Integer)entry.getValue() == 1) {
                return (Character) entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar2("leetcode"));
    }
}
