package Q_58;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        int left = 0;
        List<String> wordList = new ArrayList<>();
        while (left < len) {
            if (s.charAt(left) == ' ') {
                left++;
                continue;
            }

            int p2 = left + 1;
            while (p2 < s.length() && s.charAt(p2) != ' ') {
                p2++;
            }
            String word = s.substring(left, p2);
            wordList.add(word);
            left = p2 + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = wordList.size() - 1; i >= 0 ; i--) {
            if (i == 0) {
                sb.append(wordList.get(i));
            }else {
                sb.append(wordList.get(i) + " ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("a good   example"));
    }
}
