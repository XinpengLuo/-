package 主要练习.栈和队列.设计循环队列;

import java.util.*;

class MyCircularQueue {
    int[] queue;
    int size;
    int front;
    int end;
    public MyCircularQueue(int k) {
        queue = new int[k];
        size = 0;
        front = 0;
        end = 0;
    }

    public boolean enQueue(int value) {
        if(isFull())
            return false;
        queue[end] = value;
        end = (end + 1) % queue.length;
        size++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty())
            return false;
        size--;
        front = (front + 1) % queue.length;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[(end - 1 + queue.length) % queue.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        HashMap<Integer,Integer> map = new HashMap<>();

        return size == queue.length;


    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */