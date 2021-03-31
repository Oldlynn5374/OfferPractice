package Q_17;


import java.util.Arrays;

public class Solution2 {
    public void printDigits(int n){
        char[] numbers = new char[n];
        printRecur(numbers,0);
    }

    public void print(char[] numbers){
        boolean isBegin = false;
        for (int i = 0; i < numbers.length-1; i++){
            if (numbers[i] != '0'){
                isBegin = true;
            }
            if (isBegin){
                System.out.print(numbers[i]);
            }
        }
        System.out.println();
    }

    public void printRecur(char[] numbers, int pos){
        if (pos >= numbers.length){
            print(numbers);
            return;
        }

        for (int i = 0; i < 10; i++){
            numbers[pos] = (char) ('0' + i);
            printRecur(numbers, pos + 1);
        }
    }

    public static void main(String[] args) {
        new Solution().printDigits(3);
    }
}
