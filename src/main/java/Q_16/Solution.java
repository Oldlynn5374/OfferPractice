package Q_16;

public class Solution {
    public double absPow(double x, int n){
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return x;
        }

        double result = absPow(x, n >> 1);
        result *= result;

        if (n % 2 != 0){
            result *= x;
        }

        return result;
    }

    public double pow (double base, int exponent){
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().absPow(2.0, 5));
    }
}
