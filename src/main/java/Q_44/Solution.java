package Q_44;

public class Solution {
    public int findNthDigit(int n){
        if ( n < 10){
            return n;
        }
        n -= 10;

        int begin = 10;
        int bit = 2;
        long count = 90;

        while (true){
            long num = bit * count;
            if (n < num){
                int pos = n / bit;
                int seg = n % bit;
                int result = begin;
                result += pos;
                String str = String.valueOf(result);
                return str.charAt(seg) - '0';
            }else {
                n -= num;
                begin *= 10;
                bit++;
                count *= 10;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(1000000000));
    }
}
