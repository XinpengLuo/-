package 主要练习.栈和队列.队列的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);

    }
}
class MaxQueue {
    Queue<Integer> queue;
    TreeMap<Integer,Integer> map;
    public MaxQueue() {
        queue = new LinkedList<>();
        map = new TreeMap<>();
    }

    public int max_value() {
        if(map.isEmpty())
            return -1;
        return map.lastKey();
    }

    public void push_back(int value) {
        queue.offer(value);
        map.put(value,map.getOrDefault(value , 0) + 1);
    }

    public int pop_front() {
        if(map.isEmpty())
            return -1;
        int value = queue.poll();
        if(map.get(value) == 1)
            map.remove(value);
        else
            map.put(value,map.get(value) - 1);
        return value;
    }
}