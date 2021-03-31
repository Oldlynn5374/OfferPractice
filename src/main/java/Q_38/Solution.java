package Q_38;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        List<Character> characterList = new LinkedList<>();
        for ( char c : chars ){
            characterList.add(c);
        }
        List<String> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++){
            backtracking(characterList, sb, i, result);
        }

        String[] results = new String[result.size()];
        for (int i = 0; i < result.size(); i++){
            results[i] = result.get(i);
        }

        return results;
    }


    HashSet<String> hashSet = new HashSet<>();
    public void backtracking(List<Character> s, StringBuilder sb, int pos, List<String> result){
        Character c = s.get(pos);
        s.remove(pos);
        sb.append(c);

        if (s.size() == 0){
            String str = String.valueOf(sb);
            if (hashSet.contains(str)){

            }else {
                result.add(str);
                hashSet.add(str);
            }

            sb.deleteCharAt(sb.length() - 1);
            s.add(pos, c);
            return;
        }

        for (int i = 0; i < s.size(); i++){
            backtracking(s, sb, i, result);
        }

        sb.deleteCharAt(sb.length() - 1);
        s.add(pos, c);
    }

    public String[] permutation2(String s) {
        List<String> result = new LinkedList<>();
        recur(s.toCharArray(), 0, result);
        String[] results = new String[result.size()];
        for (int i = 0; i < result.size(); i++){
            results[i] = result.get(i);
        }
        return results;
    }
    public void recur(char[] s, int begin, List<String> result){
        if (begin >= s.length){
            String value = String.valueOf(s);
            if (hashSet.contains(value)){

            }else {
                result.add(value);
                hashSet.add(value);
            }

            // System.out.println(s);
            return;
        }

        for (int i = begin; i < s.length; i++){
            char temp = s[i];
            s[i] = s[begin];
            s[begin] = temp;

            recur(s, begin + 1, result);

            temp = s[i];
            s[i] = s[begin];
            s[begin] = temp;
        }
    }

    public static void main(String[] args) {
        String str = "aab";
        String[] strings = new Solution().permutation2(str);
        for (String msg : strings){
            System.out.println(msg);
        }
    }

}
