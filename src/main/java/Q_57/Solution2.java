package Q_57;

import java.util.*;

public class Solution2 {
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (target % 2 != 0) {
            List<Integer> list = new ArrayList<>();
            if (target / 2 == 0) {
                list.add(target / 2);
                results.add(list);
            }else {
                list.add(target / 2);
                list.add(target / 2 + 1);
                results.add(list);
            }
        }

        for (int i = 3; i < target; i += 2) {
            if (target % i == 0) {
                int halfLen = i / 2;
                int mid = target / i;
                List<Integer> array = new ArrayList<>();

                for (int j = 0; j < halfLen; j++) {
                    int value = mid - halfLen + j;
                    if (value == 0) {
                        continue;
                    }
                    array.add(mid - halfLen + j);
                }
                array.add(mid);
                for (int j = 0; j < halfLen; j++) {
                    array.add(mid + j + 1);
                }


                if (array.get(0) < 0) {
                    int end = -array.get(0);
                    while (array.get(0) <= end) {
                        array.remove(0);
                    }
                }

                results.add(array);

            }
        }
        int[][] finalResult = new int[results.size()][];
        for (int i = 0; i < results.size(); i++) {
            int[] a = new int[results.get(i).size()];
            for (int j = 0; j < results.get(i).size(); j++) {
                a[j] = results.get(i).get(j);
            }
            finalResult[i] = a;
        }
        Arrays.sort(finalResult, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        return finalResult;
    }

    public static void main(String[] args) {
        int[][] result = new Solution2().findContinuousSequence(15);
        for (int[] a : result) {
            for (int i : a){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
