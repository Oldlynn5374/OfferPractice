package Q_59;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxQueue {

    private List<Integer> list;
    private Queue<Integer> queue;

    public MaxQueue() {
        list = new ArrayList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        if (list.size() == 0) {
            return -1;
        }
        return list.get(0);
    }

    public void push_back(int value) {
        queue.add(value);

        int max = max_value();
        if (value > max) {
            list.clear();
            list.add(value);
        }else {
            int p = list.size() - 1;
            while (true) {
                if (p < 0) {
                    break;
                }
                int rear = list.get(p);
                if (rear < value) {
                    list.remove(p);
                    p--;
                }else {
                    break;
                }
            }
            list.add(value);
        }
    }

    public int pop_front() {
        if (queue.size() == 0) {
            return -1;
        }
        int head = list.get(0);
        if (queue.peek() == head) {
            list.remove(0);
        }
        return queue.poll();
    }
}
