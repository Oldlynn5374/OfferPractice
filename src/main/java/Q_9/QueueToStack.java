package Q_9;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public QueueToStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int n){
        Queue<Integer> queue;
        if (queue1.isEmpty()){
            queue = queue2;
        }else {
            queue = queue1;
        }
        queue.offer(n);
    }

    public Integer pop(){
        Queue<Integer> fromQueue;
        Queue<Integer> toQueue;
        if (queue1.isEmpty()){
            toQueue = queue1;
            fromQueue = queue2;
        }else {
            toQueue = queue2;
            fromQueue = queue1;
        }

        while (!fromQueue.isEmpty()){
            if (fromQueue.size() == 1){
                return fromQueue.poll();
            }
            toQueue.offer(fromQueue.poll());
        }
        return null;
    }

    public static void main(String[] args) {
        QueueToStack stack = new QueueToStack();
        stack.push(1);
        stack.push(2);
        stack.push(7);

        while (true){
            Integer value = stack.pop();
            if (value == null){
                break;
            }
            System.out.println(value);
        }
    }
}
