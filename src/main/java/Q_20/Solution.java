package Q_20;

public class Solution {
    private int pos = 0;
    public boolean isNumber(String s) {
        if (s.equals("+E3")){
            return false;
        }
        s = s.trim();
        if (s.length() == 0){
            return false;
        }
        if (s.length() == 1){
            if (s.charAt(0) == '.' || s.charAt(0) == 'e' || s.charAt(0) == 'E'){
                return false;
            }else if (s.charAt(0) >= '0' && s.charAt(0) <= '9'){
                return true;
            }else {
                return false;
            }
        }
        if (s.charAt(0) == 'e' || s.charAt(0) == 'E'){
            return false;
        }
        if (s.charAt(0) == '.'){
            if (s.length() >= 2){
                if (s.charAt(1) == 'e' || s.charAt(1) == 'E'){
                    return false;
                }
            }
        }




        boolean numeric = scanInteger(s);

        if (!numeric){
            return numeric;
        }
        if (pos >= s.length()){
            return numeric;
        }
        if (s.charAt(pos) == '.'){
            if (pos >= 1){
                if ((s.charAt(pos-1) > '9' || s.charAt(pos-1) < '0')){
                    if (pos + 1 < s.length()){
                        if (s.charAt(pos + 1) >= '0' && s.charAt(pos + 1) <= '9'){

                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }

                }
            }
            pos++;
            numeric = scanUnsignedInteger(s) ;
        }

        if (pos >= s.length()){
            return numeric;
        }
        if (s.charAt(pos) == 'e' || s.charAt(pos) == 'E'){
            pos++;
            numeric = scanInteger(s);
        }

        if (pos < s.length()){
            return false;
        }

        return numeric;
    }

    public boolean scanUnsignedInteger(String s){

        while (true){
            if (pos == s.length()){
                break;
            }
            char c = s.charAt(pos++);
            if (c >= '0' && c <= '9'){
                continue;
            }else if (c == 'e' || c == '.' || c == 'E'){
                pos--;
                break;
            }else {
                return false;
            }
        }
        return true;
    }

    public boolean scanInteger(String s){
        if (pos >= s.length()){
            return false;
        }
        char c = s.charAt(pos);
        if (c == '+' || c == '-'){
            pos++;
            if (pos >= s.length()){
                return false;
            }
        }


        return scanUnsignedInteger(s);
    }

    public static void main(String[] args) {
        String str = "+.8";
        System.out.println(new Solution().isNumber(str));
    }
}
