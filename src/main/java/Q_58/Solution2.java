package Q_58;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public String reverseLeftWords(String s, int n) {
        String str1 = s.substring(n);
        String str2 = s.substring(0, n);
        List<Integer> list = null;


        return str1 + str2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().reverseLeftWords("lrloseumgh", 6));
    }
}
