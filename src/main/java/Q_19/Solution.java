package Q_19;

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 || p.length() == 0){
            return false;
        }

        return matchCore(s, p);
    }

    public boolean matchCore(String s, String p){
        if (s.length() == 0 && p.length() == 0){
            return true;
        }

        if (s.length() != 0 && p.length() == 0){
            return false;
        }
        char s1;
        char p1;
        if (s.length() == 0){
            s1 = '\0';
        }else {
            s1 = s.charAt(0);
        }
        if (p.length() == 0){
            p1 = '\0';
        }else {
            p1 = p.charAt(0);
        }

        char pn;
        if (p.length() <= 1){
            pn = p1;
        }else {
            pn = p.charAt(1);
        }


        if (pn == '*'){
            if (s1 == p1 || (p1 == '.' && s1 != '\0')){
                return matchCore(s.substring(1), p) || matchCore(s.substring(1), p.substring(2)) || matchCore(s, p.substring(2));
            }else {
                return matchCore(s, p.substring(2));
            }
        }else {
            if (s1 == p1|| (p1 == '.' && s1 != '\0')){
                return matchCore(s.substring(1), p.substring(1));
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "aab";
        String p  = "c*a*b";
        System.out.println(new Solution().isMatch(s,p));
    }
}
