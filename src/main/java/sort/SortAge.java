package sort;

public class SortAge {
    public void sortAge(int[] age){
        int length = age.length;
        int oldest = 99;
        int[] ageTimes = new int[oldest];

        for (int i = 0; i < length; i++) {
            int a = age[i];
            ageTimes[a]++;
        }

        int count = 0;
        for (int i = 0; i < oldest; i++) {
            for (int j = 0; j < ageTimes[i]; j++) {
                age[count++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] age = { 19,22, 45, 36,24,45,32};
        new SortAge().sortAge(age);
        for (int i : age){
            System.out.print(i + " ");
        }
    }
}
