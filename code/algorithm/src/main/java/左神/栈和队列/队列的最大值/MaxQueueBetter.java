package 左神.栈和队列.队列的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueueBetter {
    //存值的
    Queue<Integer> queue;
    //存最大值的
    Deque<Integer> maxQueue;
    public MaxQueueBetter() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if(maxQueue.isEmpty())
            return -1;
        return maxQueue.peek();
    }

    public void push_back(int value) {
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value)
            maxQueue.pollLast();
        maxQueue.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if(queue.isEmpty())
            return -1;
        int value = queue.poll();
        if(value == maxQueue.peekFirst())
            maxQueue.pollFirst();
        return value;
    }
}
