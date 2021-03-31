package Q_17;

import java.util.Arrays;

public class Solution {
    public void printDigits(int n){
        char[] numbers = new char[n + 1];
        Arrays.fill(numbers,'0');
        numbers[n] = '\0';

        while (!increment(numbers)){
            print(numbers);
        }
        System.out.println();
    }

    public boolean increment(char[] numbers){
        boolean isOverFlow = false;
        int nTakeOver = 0;
        int len = numbers.length;
        for (int i = len-2; i >= 0; i--){

            int nSum = numbers[i] - '0' + nTakeOver;
            if (i == len - 2){
                nSum++;
            }

            if (nSum >= 10){
                if (i == 0){
                    isOverFlow = true;
                    break;
                }

                nSum -= 10;
                numbers[i] = (char) ('0' + nSum);
                nTakeOver = 1;

            }else {
                numbers[i] = (char) ('0' + nSum);
                break;
            }

        }

        return isOverFlow;
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

    public static void main(String[] args) {
        new Solution().printDigits(3);
    }
}
