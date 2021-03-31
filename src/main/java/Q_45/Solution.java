package Q_45;

public class Solution {
    public String minNumber(int[] nums) {
        String[] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }
        quickSort(numbers, 0, numbers.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String s : numbers){
            sb.append(s);
        }

        return sb.toString();
    }

    public void quickSort(String[] numbers, int l, int r){
        if (l >= r) return;
        int i = l;
        int j = r;
        String tmp = numbers[i];
        while (i < j){
            while (i < j && (numbers[j] + tmp).compareTo(tmp + numbers[j]) >= 0) j--;
            numbers[i] = numbers[j];
            while (i < j && (numbers[i] + tmp).compareTo(tmp + numbers[i]) <= 0) i++;
            numbers[j] = numbers[i];
        }
        numbers[i] = tmp;
        quickSort(numbers, l, i - 1);
        quickSort(numbers, i + 1, r);
    }


    public static void main(String[] args) {

        int[] nums = {};

        System.out.println(new Solution().minNumber(nums));
    }
}
