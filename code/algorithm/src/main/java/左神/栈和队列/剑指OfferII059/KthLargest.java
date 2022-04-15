package 左神.栈和队列.剑指OfferII059;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            add(num);
        }

    }

    public int add(int val) {
        queue.add(val);
        if(queue.size() > k)
            queue.poll();
        return queue.peek();
    }
}
