package Q_9;


import java.util.Stack;

public class StackToQueue {
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public StackToQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int n){
        stack1.push(n);
    }

    public Integer dequeue(){
        Integer result = null;
        if (!stack2.empty()){

        }else {
            if (stack1.empty()){
                return null;
            }
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        result = stack2.pop();
        return result;
    }

    public static void main(String[] args) {
        StackToQueue queue = new StackToQueue();
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(5);
        while (true){
            Integer value = queue.dequeue();
            if (value == null){
                break;
            }
            System.out.println(value);
        }
    }
}

