package Q_41;

import java.util.*;

public class MedianFinder2 {
    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;
    private int minNum = 0;
    private int maxNum = 0;

    public MedianFinder2() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        Integer minHead = minHeap.peek();
        Integer maxHead = maxHeap.peek();

        if (minHead == null){
            minHeap.offer(num);
            minNum++;
        }else if (maxHead == null){
            if (num >= minHead){
                int temp = minHeap.poll();
                maxHeap.offer(temp);
                minHeap.offer(num);
            }else {
                maxHeap.offer(num);
            }

            maxNum++;
        }else {
            if (num >= minHead){

                if ((minNum - maxNum) >= 1){
                    Integer temp = minHeap.poll();
                    maxHeap.offer(temp);
                    minHeap.offer(num);
                    maxNum++;
                }else {
                    minHeap.offer(num);
                    minNum++;
                }

            }else {

                if ((maxNum - minNum) >= 0){
                    Integer temp = maxHeap.peek();
                    if (temp > num){
                        temp = maxHeap.poll();
                        minHeap.offer(temp);
                        maxHeap.offer(num);
                    }else {
                        minHeap.offer(num);
                    }
                    minNum++;
                }else {
                    maxHeap.offer(num);
                    maxNum++;
                }

            }
        }

    }

    public double findMedian() {
        if ((minNum + maxNum) % 2 == 0){
            double d1 = minHeap.peek();
            double d2 = maxHeap.peek();
            return (d1 + d2) / 2;
        }else {
            return (double)minHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder2 medianFinder = new MedianFinder2();
        medianFinder.addNum(40);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(12);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(16);
        System.out.println(medianFinder.findMedian());



    }
}
