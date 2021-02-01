package Q_5;

public class Solution2 {
    public static void main(String[] args) {
        int[]a = {1,3,4,5,8,0,0,0};
        int[]b = {2,6,7};
        Solution2 solution = new Solution2();
        solution.sortMerge(a,b);
        for (int i : a){
            System.out.println(i);
        }

    }

    public void sortMerge(int[] a, int[] b){
        int pos = a.length - 1;
        int pa = pos - b.length;
        int pb = b.length - 1;

        while (pos >= 1){
            if (a[pa] > b[pb]){
                a[pos] = a[pa];
                pa--;
                if (pa < 0){
                    pa++;
                }

            }else {
                a[pos] = b[pb];
                pb--;
                if (pb < 0){
                    pb++;
                }
            }
            pos--;
        }
    }


}
