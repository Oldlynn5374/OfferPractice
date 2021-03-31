package Q_41;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MedianFinder {
    private boolean isOdd;
    private List<Integer> list;
    private int p;
    public MedianFinder() {
        isOdd = false;
        list = new ArrayList<>();
        p = -1;
    }

    public void addNum(int num) {
        isOdd = !isOdd;
        if (isOdd){
            p++;
        }
        list.add(num);
    }

    public double findMedian() {
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        if (isOdd){
            return list.get(p);
        }else {
            double result = ((double)list.get(p) + (double)list.get(p + 1)) / 2;short s = 1; 
            return result;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());

    }
}
